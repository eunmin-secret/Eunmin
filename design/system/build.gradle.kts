plugins {
    id("eunmin.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "dev.project.eunmin.design.system"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.material.icons)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling.preview)
}