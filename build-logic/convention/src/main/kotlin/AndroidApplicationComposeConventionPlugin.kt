import com.android.build.api.dsl.ApplicationExtension
import cookieclicker.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            configureAndroidCompose(extensions.getByType<ApplicationExtension>())
        }
    }
}