plugins {
    id(Plugin.androidLibrary)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
    from("$rootDir/network_dependencies.gradle")
}

dependencies {
    implementation(Dependencies.coroutinesLibs)
    implementation(Dependencies.retrofitLibs)
}