import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.1.0"
}

val supabaseUrl:String= gradleLocalProperties(rootDir,providers).getProperty("supabaseUrl").toString()
val supabaseKey:String= gradleLocalProperties(rootDir,providers).getProperty("supabaseKey").toString()

android {
    namespace = "com.example.happypockets"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.happypockets"
        minSdk = 26
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
            buildConfigField(type="String",name="SupabaseURL",value="\"$supabaseUrl\"")
            buildConfigField(type="String",name="SupabaseKey",value="\"$supabaseKey\"")
        }

        debug {
            buildConfigField(type="String",name="SupabaseURL",value="\"$supabaseUrl\"")
            buildConfigField(type="String",name="SupabaseKey",value="\"$supabaseKey\"")
        }
    }

    buildFeatures{
        buildConfig=true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}