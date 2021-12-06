plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Scripts.variants)
}

apply {
    from("$rootDir/commons.gradle")
    from("$rootDir/core_dependencies.gradle")
    from("$rootDir/network_dependencies.gradle")
}

android {
    defaultConfig {
        applicationId = AndroidConfig.applicationId

        testInstrumentationRunner = AndroidConfig.androidTestInstrumentation
    }

    android.buildFeatures.viewBinding = true
    android.buildFeatures.dataBinding = true

    sourceSets {
        map { it.java.srcDir("src/${it.name}/java") }
    }

    kapt { correctErrorTypes = true }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}