@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    useJs()
}

dependencies {
    commonMainApi(libs.kotlin.stdlib)
}
