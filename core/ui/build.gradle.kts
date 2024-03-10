plugins {
    alias(libs.plugins.cookieclicker.android.library)
    alias(libs.plugins.cookieclicker.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.zorbeytorunoglu.cookieclicker.core.ui"
}

dependencies {
    api(project(":core:designsystem"))
    api(project(":core:data"))

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}