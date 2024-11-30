plugins {
    id("com.android.application")
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.uilover.project2002"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uilover.project2002"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)

    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.google.code.gson:gson:2.9.1")
    implementation("com.tbuonomo:dotsindicator:5.0")
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation(libs.firebase.database)
}