
// Centralize dependencies here instead of writing them out in the top-level
// build script(s).

object Versions {
    const val gson = "2.8.9"
    const val guava = "30.1-jre"
    const val launchdarklyJavaSdkCommon = "2.0.0-SNAPSHOT"
    const val launchdarklyLogging = "1.1.1"
    const val okhttp = "4.9.1"
    const val slf4j = "1.7.21"
    const val testHelpers = "1.2.0"
}

object PluginVersions {
    const val nexusPublish = "0.3.0"
    const val nexusStaging = "0.30.0"
}

object Libs {
    val implementation = listOf<String>(
        // We would put anything here that we want to go into the Gradle "implementation"
        // configuration, if and only if we want those things to show up in pom.xml.
        "com.google.code.gson:gson:${Versions.gson}",
        "com.google.guava:guava:${Versions.guava}",
        "com.launchdarkly:launchdarkly-java-sdk-common:${Versions.launchdarklyJavaSdkCommon}",
        "com.launchdarkly:launchdarkly-logging:${Versions.launchdarklyLogging}",
        "com.squareup.okhttp3:okhttp:${Versions.okhttp}",
        "org.slf4j:slf4j-api:${Versions.slf4j}"
    )

    val javaTestImplementation = listOf(
        "junit:junit:4.12",
        "org.hamcrest:hamcrest-library:1.3"
        // "com.launchdarkly:test-helpers:${Versions.testHelpers}"
        // test-helpers is special-cased in build.gradle.kts and build-android.gradle
    )

    val androidTestImplementation = javaTestImplementation + listOf(
        "com.android.support.test:runner:1.0.2"
    )

    val javaBuiltInGradlePlugins = listOf(
        "java",
        "java-library",
        "checkstyle",
        "signing",
        "maven-publish",
        "idea",
        "jacoco"
    )

    val javaExtGradlePlugins = mapOf(
        "de.marcphilipp.nexus-publish" to PluginVersions.nexusPublish,
        "io.codearte.nexus-staging" to PluginVersions.nexusStaging
    )
}
