plugins {
    id(Plugin.application)
    id(Plugin.kotlinAndroid)
    id("scripts.variants")
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
}

android {
    defaultConfig {
        applicationId = AndroidConfig.applicationId

        testInstrumentationRunner = AndroidConfig.androidTestInstrumentation
    }

    sourceSets {
        map { it.java.srcDir("src/${it.name}/java") }
    }
}

dependencies {
    implementation(project(":common"))

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}