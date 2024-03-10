plugins {
    alias(libs.plugins.cookieclicker.android.library)
}

android {

    namespace = "com.zorbeytorunoglu.cookieclicker.core.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}