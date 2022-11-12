import org.jetbrains.kotlin.gradle.targets.js.webpack.*

@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    kotlin("js")
    alias(libs.plugins.kotlin.plugin.serialization)
}

fun KotlinWebpackConfig.DevServer?.proxies() = run {
    val map = this?.proxy ?: mutableMapOf()
    listOf(
        "/api",
        "/images",
    ).forEach {
        map[it] = "http://localhost:8080"
    }
    map
}

kotlin {
    useJs {
        commonWebpackConfig {
            cssSupport {
                enabled = true
            }

            devServer = devServer?.copy(
                port = 3000,
                proxy = devServer.proxies()
            )
        }
    }
}

dependencies {
    implementation(project(":common"))
    implementation(libs.kotlin.stdlib.js)
    implementation(libs.react)
    implementation(libs.react.dom)
    implementation(libs.emotion)
    implementation(libs.ktor.client.js)
    implementation(libs.kotlinx.coroutines.core.js)
}
