@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlin.plugin.serialization)
    application
    distribution
    id("com.dorongold.task-tree") version "2.1.0"
}

application {
    mainClass.set("ApplicationKt")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":common"))
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.server.cio)
    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.call.logging.jvm)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.kotlinx.coroutines.core.jvm)
    implementation(libs.logback.classic)
}

val buildAndCopyFrontend = tasks.register<Copy>("buildAndCopyFrontend") {
    val frontendDist = project(":frontend").tasks.named("browserDistribution")
    dependsOn(frontendDist)
    from(frontendDist)
    into("${project.projectDir}/src/main/resources/static")
}

val prepareAppResources = tasks.register("prepareAppResources") {
    dependsOn(buildAndCopyFrontend)
    finalizedBy("processResources")
}

val buildApp = tasks.register("buildApp") {
    dependsOn(prepareAppResources)
    finalizedBy("build")
}

tasks.named<JavaExec>("run") {
    dependsOn(buildApp)
    classpath(tasks.named<Jar>("jar"))
}
