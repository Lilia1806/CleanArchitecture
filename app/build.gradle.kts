plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Safe args
    id ("androidx.navigation.safeargs.kotlin")
    //Kapt
    id("kotlin-kapt")

    //Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.cleanarchitecture"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.cleanarchitecture"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        //ViewBinding
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.navigation:navigation-fragment:2.5.3")
    val activity_version = "1.7.1"
    // Kotlin
    implementation("androidx.activity:activity-ktx:$activity_version")

    val fragment_version = "1.5.7"
    // Kotlin
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    //Core
    implementation("androidx.core:core-ktx:1.10.1")

    //AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    //Material Design
    implementation("com.google.android.material:material:1.9.0")

    //UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    //View binding property delegate
    val view_binding_property_delegate = "1.5.8"

    //To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    // hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    //view pager
    implementation ("androidx.viewpager2:viewpager2:1.1.0-beta01")

}