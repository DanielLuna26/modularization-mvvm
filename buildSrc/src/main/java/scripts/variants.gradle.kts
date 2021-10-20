package scripts

plugins {
    id("com.android.application") apply false
}

private object BuildTypes {
    const val DEBUG = "debug"
    const val RELEASE = "release"
}

private object FlavorDimensions {
    const val DEFAULT = "default"
}

object Default {
    const val BUILD_TYPE = BuildTypes.DEBUG
    const val BUILD_FLAVOR = Flavors.DEV

    val BUILD_VARIANT = "${BUILD_FLAVOR.capitalize()}${BUILD_TYPE.capitalize()}"
}

android {
    buildTypes {
        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = false
            applicationIdSuffix = ".${BuildTypes.DEBUG}"
            isDebuggable = true
        }
        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    flavorDimensions.add(FlavorDimensions.DEFAULT)
    productFlavors {
        create(Flavors.DEV) {
            dimension = FlavorDimensions.DEFAULT
            applicationIdSuffix = ".${Flavors.DEV}"
            versionNameSuffix = "-${Flavors.DEV}"
        }
        create(Flavors.STAGING) {
            dimension = FlavorDimensions.DEFAULT
            applicationIdSuffix = ".${Flavors.STAGING}"
            versionNameSuffix = "-${Flavors.STAGING}"
        }
        create(Flavors.PROD) {
            dimension = FlavorDimensions.DEFAULT
        }
    }
}