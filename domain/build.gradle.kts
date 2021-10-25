plugins {
    id(Plugins.androidLibrary)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
    from("$rootDir/network_dependencies.gradle")
}

dependencies {
    implementation(project(":common"))
    implementation(Dependencies.coroutinesLibs)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}