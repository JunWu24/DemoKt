package com.junwu.demokt

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.junwu.demokt.activity.MainActivity
import com.junwu.demokt.base.BaseVmActivity
import com.junwu.demokt.constants.Constants
import com.junwu.demokt.utils.DialogUtils
import com.junwu.demokt.utils.PrefUtils
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import java.util.concurrent.TimeUnit

class SplashActivity : BaseVmActivity(), EasyPermissions.PermissionCallbacks {

    private val tag : String = "SplashActivity"
    private var mDisposable : Disposable? = null
    private val tips = "WanAndroid现在要向您申请存储权限，用于访问您的本地音乐，您也可以在设置中手动开启或者取消。"
    private val perms = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    companion object {
        private const val WRITE_EXTERNAL_STORAGE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        changeTheme()
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate: ")
    }

    override fun init(savedInstanceState: Bundle?) {
        requestPermission()
    }

    override fun getLayoutId() = R.layout.activity_splash

    private fun changeTheme() {
        val theme = PrefUtils.getBoolean(Constants.SP_THEME_KEY,false)
        if (theme) {
            setTheme(R.style.AppTheme_Night)
        } else {
            setTheme(R.style.AppTheme)
        }
    }

    private fun requestPermission() {
        if (EasyPermissions.hasPermissions(this, *perms)) {
            startIntent()
        } else {
            DialogUtils.tips(this,tips) {
                requestLocationAndCallPermission()
            }
        }
    }

    private fun startIntent() {
        mDisposable = Observable.timer(2000, TimeUnit.MILLISECONDS)
            .subscribe {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable?.dispose()
    }

    @AfterPermissionGranted(WRITE_EXTERNAL_STORAGE)
    fun requestLocationAndCallPermission() {
        val perms = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        //数组中权限都已申请
        if (EasyPermissions.hasPermissions(this, *perms)) {
            startIntent()
        } else {
            EasyPermissions.requestPermissions(this, "请求写入权限", WRITE_EXTERNAL_STORAGE, *perms)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        startIntent()
    }

}