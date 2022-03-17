/**
 * des 管理第三方库依赖
 */
object ThirdParty {

    const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.14"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    const val easypermissions = "pub.devrel:easypermissions:3.0.0"

    val smart = Smart
    object Smart {
        private const val smart_version = "1.1.2"
        const val smart = "com.scwang.smartrefresh:SmartRefreshLayout:$smart_version"
        const val head = "com.scwang.smartrefresh:SmartRefreshHeader:$smart_version"
    }

}