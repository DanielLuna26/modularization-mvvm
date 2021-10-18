package scripts

plugins {
    id(Plugin.application) apply false
}

android {
    buildTypes {
        getByName("debug") {
            isMinifyEnable = true
        }
    }

    flavorDimensions("version")

    productFlavors {
        create("dev") {
            dimension = "version"
        }
    }
}