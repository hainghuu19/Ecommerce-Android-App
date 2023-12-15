buildscript{
//    ext.kotlin_version = "1.5.31"
    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
        classpath("com.google.gms:google-services:4.4.0")
        val nav_version = "2.7.4"
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin: $kotlin_version")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("androidx.navigation.safeargs.kotlin") version "2.4.1" apply false
    id ("com.android.library") version "7.3.0" apply false
//    kotlin("kapt") version "1.9.21"
    id("com.google.dagger.hilt.android") version "2.48" apply false

}
