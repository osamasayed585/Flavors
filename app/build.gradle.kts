plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.osama.flavors"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.osama.flavors"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        manifestPlaceholders["hostName"] = "www.example.com"
    }

    buildTypes {
        debug {
            manifestPlaceholders["hostName"] = "debug.example.com"
            isMinifyEnabled = false
        }

        release {
            manifestPlaceholders += mapOf()
            manifestPlaceholders["hostName"] = "production.example.com"
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    // Adding Product Flavors
    flavorDimensions += "version"
    productFlavors {
        create("free") {
            dimension = "version"
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
            manifestPlaceholders["hostName"] = "free.example.com"
        }

        create("paid") {
            dimension = "version"
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
            manifestPlaceholders["hostName"] = "paid.example.com"
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
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Common libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Free-specific libraries
    freeImplementation(libs.play.services.measurement.api)

    // Paid-specific libraries
    paidImplementation(libs.retrofit)
    paidImplementation(libs.converter.gson)

}

fun DependencyHandler.paidImplementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add(
        libs.versions.paidImplementation.get(),
        dependency
    )
}

fun DependencyHandler.freeImplementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add(
        libs.versions.freeImplementation.get(),
        dependency
    )
}