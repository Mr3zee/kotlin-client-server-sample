import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl


fun KotlinMultiplatformExtension.useJs() {
    js {
        useJsInternal()
    }
}

fun KotlinJsProjectExtension.useJs() {
    js {
        useJsInternal()
    }
}

private fun KotlinJsTargetDsl.useJsInternal() {
    browser {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
            }
        }
    }
}