plugins {
    alias(libs.plugins.cookieclicker.android.feature)
    alias(libs.plugins.cookieclicker.android.library.compose)
}

android {
    namespace = "com.zorbeytorunoglu.cookieclicker.feature.game"
}

dependencies {
    implementation(project(":core:data"))
}