plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")

}

android {
    namespace = "com.example.ecommerceappfirebase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ecommerceappfirebase"
        minSdk = 21
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-stdlib: $kotlin_version")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation("com.google.firebase:firebase-firestore:24.10.0")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    classpath 'androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5'
    kapt("androidx.room:room-compiler:2.4.3")


    //Navigation component
    var nav_version = "2.7.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
//    kapt("groupId:artifactId:1.9.21")
    //loading button
    implementation ("br.com.simplepass:loading-button-android:2.2.0")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    //circular image
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    //viewpager2 indicatior
    implementation ("io.github.vejei.viewpagerindicator:viewpagerindicator:1.0.0-alpha.1")
    //stepView
    implementation ("com.shuhart.stepview:stepview:1.5.1")
    //Android Ktx
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")




    //Dagger hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-compiler:2.48")


    //Firebase
    implementation("com.google.firebase:firebase-auth:22.3.0")

    //
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.1")

}