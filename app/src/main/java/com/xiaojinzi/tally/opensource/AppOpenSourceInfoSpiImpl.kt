package com.xiaojinzi.tally.opensource

import com.xiaojinzi.component.anno.ServiceAnno
import com.xiaojinzi.tally.module.base.spi.AppInfoSpi
import com.xiaojinzi.tally.module.base.spi.BaseAppInfoSpiImpl

@ServiceAnno(AppInfoSpi::class)
class AppOpenSourceInfoSpiImpl : BaseAppInfoSpiImpl() {

    override val forOpenSource: Boolean
        get() = true

    override val appLauncherForegroundIconRsd: Int
        get() = R.mipmap.ic_launcher_foreground

    override val appLauncherIconRsd: Int
        get() = R.mipmap.ic_launcher

    override val appIconRsd: Int
        get() = R.drawable.app_icon

    override val officialUrl: String
        get() = "https://yike.icxj.cn"

}