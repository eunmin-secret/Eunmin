plugins {
    id("eunmin.android.library")
    id("eunmin.android.hilt")
}

android {
    namespace = "dev.project.eunmin.feature.calculator.basic"

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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(":design:system-basic"))
    implementation(project(":design:keyboard-basic"))
    implementation(project(":core:calculator"))
    implementation(libs.orbit.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
}