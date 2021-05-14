plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.app.test"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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

    buildFeatures.viewBinding = true

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {

    // Android
    implementation(com.app.test.build.Dependencies.kotlin)
    implementation(com.app.test.build.Android.coreKtx)
    implementation(com.app.test.build.Android.appcompat)
    implementation(com.app.test.build.Android.fragmentKtx)
    implementation(com.app.test.build.Android.navigationFragment)
    implementation(com.app.test.build.Android.navigationUIKtx)

    // Design
    implementation(com.app.test.build.Dependencies.materialDesign)
    implementation(com.app.test.build.Android.constraintLayout)

    //Google places
    implementation(com.app.test.build.Google.map)
    implementation(com.app.test.build.Google.places)
    implementation(com.app.test.build.Google.libPlace)

    // Architecture Components
    implementation(com.app.test.build.Lifecycle.viewModel)
    implementation(com.app.test.build.Lifecycle.liveData)

    // Coroutines
    implementation(com.app.test.build.Coroutines.core)
    implementation(com.app.test.build.Coroutines.android)

    // Retrofit
    implementation(com.app.test.build.Retrofit.retrofit)
    implementation(com.app.test.build.Retrofit.moshiRetrofitConverter)

    // Moshi
    implementation(com.app.test.build.Moshi.moshi)
    implementation(com.app.test.build.Moshi.codeGen)
    kapt(com.app.test.build.Moshi.codeGen)

    // Hilt + Dagger
    implementation(com.app.test.build.Hilt.hiltAndroid)
    implementation(com.app.test.build.Hilt.hiltViewModel)
    kapt(com.app.test.build.Hilt.daggerCompiler)
    kapt(com.app.test.build.Hilt.hiltCompiler)

    // Coil-kt
    implementation(com.app.test.build.Dependencies.coil)
}