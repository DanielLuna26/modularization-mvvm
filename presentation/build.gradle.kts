plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.safeArgs)
    id(Plugins.hilt)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
}

android {
    android.buildFeatures.viewBinding = true
    android.buildFeatures.dataBinding = true

    kapt { correctErrorTypes = true }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))

    implementation(Dependencies.lifecycleLibs)
    implementation(Dependencies.activityFragmentKtxLibs)
    implementation(Dependencies.uILibs)
    implementation(Dependencies.navigationLibs)
    implementation(Dependencies.coroutinesLibs)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.lifecycleCompiler)
    kapt(Dependencies.glideCompiler)
}