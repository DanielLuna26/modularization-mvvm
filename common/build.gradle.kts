plugins {
    id(Plugins.androidLibrary)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
    from("$rootDir/network_dependencies.gradle")
}

android {
    android.buildFeatures.viewBinding = true
    android.buildFeatures.dataBinding = true
}

dependencies {
    implementation(Dependencies.coroutinesLibs)
    implementation(Dependencies.lifecycleLibs)
    implementation(Dependencies.navigationLibs)
    implementation(Dependencies.retrofitLibs)
}