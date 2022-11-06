@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    kotlin("js")
}

kotlin {
    useJs()
}

dependencies {
    implementation(project(":common"))
    implementation(libs.kotlin.stdlib.js)
    implementation(libs.react)
    implementation(libs.react.dom)
    implementation(libs.emotion)
}
