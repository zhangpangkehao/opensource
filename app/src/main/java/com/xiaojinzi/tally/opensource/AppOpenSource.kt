package com.xiaojinzi.tally.opensource

import com.xiaojinzi.tally.module.base.support.BaseApplication

class AppOpenSource : BaseApplication() {

    override val tag = "App"

    override val debug: Boolean
        get() = BuildConfig.DEBUG

    override val applicationIdFormat: String
        get() = BuildConfig.applicationIdFormat

}