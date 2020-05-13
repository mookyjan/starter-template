import ApplicationConfig.versionCode
import ApplicationConfig.versionName
import GradlePluginId.androidApplication
import GradlePluginId.kotlinAndroid
import GradlePluginId.kotlinAndroidExtensions
import com.android.build.gradle.AndroidConfig
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    id(GradlePluginId.androidApplication)
    id(GradlePluginId.kotlinAndroid)
    id(GradlePluginId.kotlinAndroidExtensions)
    id(GradlePluginId.ktlintGradle)
}

android {
    compileSdkVersion(ApplicationConfig.compileSdk)

    defaultConfig {
        applicationId = ApplicationConfig.id
        minSdkVersion(ApplicationConfig.minSdk)
        targetSdkVersion(ApplicationConfig.targetSdk)
        buildToolsVersion(ApplicationConfig.buildTools)

        versionCode = ApplicationConfig.versionCode
        versionName = ApplicationConfig.versionName
        testInstrumentationRunner = ApplicationConfig.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android.txt", "proguard-rules.pro")

        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    //module
//    implementation(project(ModuleDependency.featureArtist))

    //core
    implementation(LibraryDependency.kotlin)

    //android
    implementation(LibraryDependency.supportAppCompact)
    implementation(LibraryDependency.supportConstraintLayout)
    implementation(LibraryDependency.supportRecyclerView)
    implementation(LibraryDependency.supportDesign)

    //jvm test
    testImplementation(LibraryDependency.junit)

    //android test
    androidTestImplementation(LibraryDependency.testRunner)
    androidTestImplementation(LibraryDependency.espressoCore)
}


//apply plugin: 'com.android.application'
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-android-extensions'
//
//android {
//    compileSdkVersion 29
//    buildToolsVersion "29.0.3"
//
//    defaultConfig {
//        applicationId "my.com.myeg.utillibrary"
//        minSdkVersion 16
//        targetSdkVersion 29
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//
//}
//
//dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//    implementation 'androidx.appcompat:appcompat:1.1.0'
//    implementation 'androidx.core:core-ktx:1.2.0'
//    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
//}
