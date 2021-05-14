package com.app.test.build

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.31"
    const val gradle = "ccom.android.tools.build:gradle:4.1.3"
    const val materialDesign = "com.google.android.material:material:1.3.0"
    const val coil = "io.coil-kt:coil:0.9.5"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    const val playService = "com.google.gms:google-services:4.2.0"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.0"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:2.3.0"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.2"
    const val coreKtx = "androidx.core:core-ktx:1.3.2"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
}

object Google {
    const val map = "com.google.android.gms:play-services-maps:17.0.0"
    const val places = "com.google.android.gms:play-services-places:17.0.0"
    const val libPlace = "com.google.android.libraries.places:places:2.4.0"
}

object Lifecycle {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
}

object Hilt {
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    const val hiltAndroid = "com.google.dagger:hilt-android:2.28-alpha"
}

object Moshi {
    const val moshi = "com.squareup.moshi:moshi-kotlin:1.9.2"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:1.9.2"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:2.8.1"
    const val moshiRetrofitConverter = "com.squareup.retrofit2:converter-moshi:2.7.2"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5"
}