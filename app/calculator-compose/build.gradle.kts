plugins {
    id("eunmin.android.application")
    id("eunmin.android.application.compose")
}

android {
    namespace = "dev.project.eunmin.app.calculator.compose"

    defaultConfig {
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(project(":design:system-compose"))
    implementation(project(":feature:calculator-compose"))
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.saveable)
}