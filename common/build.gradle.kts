plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js {
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
}
