plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.testmvvm"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.testmvvm"
        minSdk = 24
        targetSdk = 35
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0-RC")
// Room
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation (libs.androidx.room.ktx)
    kapt ("androidx.room:room-compiler:2.6.1")
// Glide
    implementation (libs.glide)

// Gson
    implementation (libs.gson)

// Retrofit
    implementation (libs.retrofit.v2110)
    implementation (libs.converter.gson.v2110)

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
}