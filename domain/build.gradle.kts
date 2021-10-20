plugins {
    id(Plugin.androidLibrary)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
}

dependencies {
    implementation(project(":common"))
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutines)
}