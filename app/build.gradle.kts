plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.osingly"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.osingly"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Basic dependencies using version catalog
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Core Android dependencies
    implementation("androidx.core:core:1.12.0")
    implementation("androidx.activity:activity:1.8.2")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.7.0")

    // Google Generative AI
    implementation("com.google.ai.client.generativeai:generativeai:0.2.2") // Check for latest version

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // SharedPreferences
    implementation("androidx.preference:preference:1.2.1")

    // Image loading and processing
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    // OCR capabilities - Google ML Kit Text Recognition
    implementation("com.google.mlkit:text-recognition:16.0.0")

    // Language detection
    implementation("com.google.mlkit:language-id:17.0.4")

    // Network requests (optional - for future features)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // JSON parsing
    implementation("com.google.code.gson:gson:2.10.1")

    // Permission handling
    implementation("com.karumi:dexter:6.2.3")

    // Loading animations
    implementation("com.airbnb.android:lottie:6.2.0")

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}