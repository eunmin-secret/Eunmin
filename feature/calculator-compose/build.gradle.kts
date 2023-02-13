plugins {
    id("eunmin.android.library")
    id("eunmin.android.library.compose")
    id("eunmin.android.hilt")
}

android {
    namespace = "dev.project.eunmin.feature.calculator.compose"

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
    implementation(project(":design:system-compose"))
    implementation(project(":design:keyboard-compose"))
    implementation(project(":core:calculator"))
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.compose.viewmodel)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.orbit.viewmodel)
    implementation(libs.orbit.compose)
}