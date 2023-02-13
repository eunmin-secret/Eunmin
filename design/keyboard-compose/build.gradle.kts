plugins {
    id("eunmin.android.library")
    id("eunmin.android.library.compose")
}

android {
    namespace = "dev.project.eunmin.design.keyboard.compose"

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
    implementation(project(":design:system-compose"))
    implementation(libs.androidx.core.ktx)
}