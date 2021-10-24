plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinKapt)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
    from("$rootDir/network_dependencies.gradle")
}

dependencies {
    implementation(Dependencies.activityFragmentKtxLibs)
    implementation(Dependencies.navigationLibs)
    implementation(Dependencies.lifecycleLibs)
    implementation(Dependencies.uILibs)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.glideCompiler)
    kapt(Dependencies.lifecycleCompiler)
}