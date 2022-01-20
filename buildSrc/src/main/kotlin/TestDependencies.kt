object TestDependencies {
    private const val junit = "junit:junit:${Versions.junit}"
    private const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
    private const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    private const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    private const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    private const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    private const val roomTest = "androidx.room:room-testing:${Versions.room}"

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(mockitoKotlin)
        add(mockitoCore)
        add(coroutinesTest)
        add(coreTesting)
        add(mockWebServer)
        add(roomTest)
    }
}