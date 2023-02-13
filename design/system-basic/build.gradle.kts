plugins {
    id("eunmin.android.library")
}

android {
    namespace = "dev.project.eunmin.design.system.basic"

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
    api(libs.androidx.appcompat)
    api(libs.androidx.material)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}