object Dependencies {
    const val gradle = "com.android.tools.build:gradle:7.0.2"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(Dependencies.gradle)
    implementation(Dependencies.kotlinGradle)
}