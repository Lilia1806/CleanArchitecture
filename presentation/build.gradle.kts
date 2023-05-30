plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    //Safe args
    id("androidx.navigation.safeargs.kotlin")
    //Kapt
    id("kotlin-kapt")
    //Hilt
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Navigation
    val navVersion = "2.5.3"
    //   implementation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // ViewBindingPropertyDelegate
    val view_binding_property_delegate = "1.5.3"
    // To use only without reflection variants of viewBinding
    //noinspection GradleDependency
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    //hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    //Domain
    implementation(project(":domain"))
}