// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

dependencies {
    implementation(libs.androidx.navigation.compose)
}

android {
    namespace = "com.example.amfoss"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
        targetSdk = 35
    }
}
