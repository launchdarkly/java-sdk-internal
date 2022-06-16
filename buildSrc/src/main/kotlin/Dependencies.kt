
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

    val javaTestImplementation = listOf(
        "org.hamcrest:hamcrest-library:1.3",
        "junit:junit:4.12",
        "com.launchdarkly:test-helpers:1.1.0"
    )

    val androidTestImplementation = javaTestImplementation + listOf(
        "com.android.support.test:runner:1.0.2"
    )

    val privateImplementation = listOf(
        // These will be used in the compile-time classpath, but they should *not* be put in
        // the usual Gradle "implementation" configuration, because we don't want them to be
        // visible at all in the module's published dependencies - not even in "runtime" scope.
        //
        // While java-sdk-internal does need Gson in order to work, the LaunchDarkly SDKs that
        // use java-sdk-internal have different strategies for packaging Gson. The Android SDK
        // exposes it as a regular dependency; the Java server-side SDK embeds and shades Gson
        // and does not expose it as a dependency. So we are leaving it up to the SDK to
        // provide Gson in some way.
        "com.google.code.gson:gson:${Versions.gson}"
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
