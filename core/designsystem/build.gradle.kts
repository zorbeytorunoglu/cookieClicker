plugins {
    alias(libs.plugins.cookieclicker.android.library)
    alias(libs.plugins.cookieclicker.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.zorbeytorunoglu.cookieclicker.core.designsystem"
}

dependencies {

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)

    implementation(libs.coil.kt.compose)

    testImplementation(libs.androidx.compose.ui.test)
    testImplementation(libs.hilt.android.testing)

    androidTestImplementation(libs.androidx.compose.ui.test)

}