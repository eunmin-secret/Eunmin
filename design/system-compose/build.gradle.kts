plugins {
    id("eunmin.android.library")
    id("eunmin.android.library.compose")
}

android {
    namespace = "dev.project.eunmin.design.system.compose"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.icons)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling.preview)
    debugApi(libs.debug.androidx.compose.ui.tooling)
}