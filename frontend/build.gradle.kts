@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    kotlin("js")
    alias(libs.plugins.kotlin.plugin.serialization)
}

kotlin {
    useJs {
        commonWebpackConfig {
            cssSupport {
                enabled = true
            }

            devServer = devServer?.copy(port = 3000)
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
