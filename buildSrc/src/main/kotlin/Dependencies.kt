
// Centralize dependencies here instead of writing them out in the top-level
// build script(s).

object Versions {
    const val gson = "2.8.9"
    const val guava = "30.1-jre"
    const val launchdarklyJavaSdkCommon = "1.3.0"
    const val okhttp = "4.9.1"
    const val slf4j = "1.7.21"
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
        "com.squareup.okhttp3:okhttp:${Versions.okhttp}",
        "org.slf4j:slf4j-api:${Versions.slf4j}"
    )

    val testHamcrest = listOf(
        // This is in a separate category because some of our other test dependencies have
        // Hamcrest as a transitive dependency, but they use different artifacts, which
        // would cause conflicts if we didn't exclude Hamcrest when importing them.
        "org.hamcrest:hamcrest-library:1.3"
    )

    val javaTestImplementation = listOf(
        "junit:junit:4.12",
        "com.launchdarkly:test-helpers:1.1.0"
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
