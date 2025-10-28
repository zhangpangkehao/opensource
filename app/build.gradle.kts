plugins {
    id("appPlugin")
}

android {
    namespace = "com.xiaojinzi.tally.opensource"
    signingConfigs {
        maybeCreate("debug").apply {
            storeFile = file("./signForOpenSource")
            storePassword = "opensource"
            keyAlias = "opensource"
            keyPassword = "opensource"
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
        maybeCreate("release").apply {
            storeFile = file("./signForOpenSource")
            storePassword = "opensource"
            keyAlias = "opensource"
            keyPassword = "opensource"
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
    }
    // flavorDimensions("env")
    flavorDimensions.clear()
    flavorDimensions.addAll(
        elements = listOf(
            "env",
        )
    )
    productFlavors {
        maybeCreate("dev").apply {
            dimension = "env"
            buildConfigField(
                "String",
                "baseNetworkUrl",
                // "\"http://1978iy9407.zicp.fun:28080/api\"",
                "\"http://192.168.199.244:8080/api\"",
            )
            buildConfigField(
                "String",
                "baseWebUrl",
                "\"http://192.168.199.244:8080\"",
            )
        }
        maybeCreate("prd").apply {
            dimension = "env"
            buildConfigField(
                "String",
                "baseNetworkUrl",
                "\"https://yike.icxj.cn/api\"",
            )
            buildConfigField(
                "String",
                "baseWebUrl",
                "\"https://yike.icxj.cn\"",
            )
        }
    }
    defaultConfig {
        applicationId = namespace
        versionName = "1.0.2"
        versionCode = versionName?.toVersionCode()
        val applicationIdFormat = applicationId!!.replace(oldChar = '.', newChar = '_')
        buildTypes {
            maybeCreate("debug").apply {
                applicationIdSuffix = ".debug"
                signingConfig = signingConfigs.getByName("debug")
                manifestPlaceholders.putAll(
                    mapOf(
                        "applicationIdFormat" to applicationIdFormat,
                        "appLabel" to "@string/app_name_for_debug",
                        "appIcon" to "@mipmap/ic_launcher",
                        "appRoundIcon" to "@mipmap/ic_launcher_round",
                    )
                )
                buildConfigField(
                    "String",
                    "applicationIdFormat",
                    "\"$applicationIdFormat\"",
                )
            }
            maybeCreate("release").apply {
                isDebuggable = true  // 添加这一行！！！
                isMinifyEnabled = true
                signingConfig = signingConfigs.getByName("release")
                manifestPlaceholders.putAll(
                    mapOf(
                        "applicationIdFormat" to applicationId!!.replace(oldChar = '.', newChar = '_'),
                        "appLabel" to "@string/app_name",
                        "appIcon" to "@mipmap/ic_launcher",
                        "appRoundIcon" to "@mipmap/ic_launcher_round",
                    )
                )
                buildConfigField(
                    "String",
                    "applicationIdFormat",
                    "\"$applicationIdFormat\"",
                )
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro",
                )
            }
        }
        ndk {
            abiFilters.clear()
            abiFilters.addAll(
                elements = listOf(
                    "armeabi-v7a",
                    "arm64-v8a",
                )
            )
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":module-network:opensource"))
}
