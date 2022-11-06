plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("sysoev.sd.mvc.ServerKt")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-cio:2.1.3")
    implementation("io.ktor:ktor-server-html-builder-jvm:2.1.3")
}

tasks.named<Copy>("processResources") {
    val frontendBrowserDistribution = project(":frontend").tasks.named("browserDistribution")
    from(frontendBrowserDistribution)
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named<Jar>("jar"))
    classpath(tasks.named<Jar>("jar"))
}
