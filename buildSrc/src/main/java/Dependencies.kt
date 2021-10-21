object Dependencies {
    const val standardLibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val support = "androidx.legacy:legacy-support-v4:${Versions.support}"
    const val annotationLibrary = "androidx.annotation:annotation:${Versions.annotations}"

    // Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Apollo
    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime:${Versions.apollo}"
    const val apolloCoroutines = "com.apollographql.apollo:apollo-coroutines-support:${Versions.apollo}"

    // Lifecycle viewmodel
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifeCycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifeCycle}"

    // UI Dependencies
    private const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    private const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
}