plugins {
    id(Plugin.androidLibrary)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
}

dependencies {
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.apolloRuntime)
    implementation(Dependencies.apolloCoroutines)
}