plugins {
    id("eunmin.android.application")
}

android {
    namespace = "dev.project.eunmin.app.calculator.basic"

    defaultConfig {
        applicationId = "dev.project.eunmin.app.calculator.basic"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(project(":design:system-basic"))
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}