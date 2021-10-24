plugins {
    id(Plugin.androidLibrary)
    id("com.apollographql.apollo").version(Versions.apollo)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
    from("$rootDir/network_dependencies.gradle")
}

apollo {
    generateKotlinModels.set(false)
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(Dependencies.coroutinesLibs)
}