plugins {
    alias(libs.plugins.cookieclicker.android.library)
    alias(libs.plugins.cookieclicker.android.hilt)
}

android {

    namespace = "com.zorbeytorunoglu.cookieclicker.core.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
}