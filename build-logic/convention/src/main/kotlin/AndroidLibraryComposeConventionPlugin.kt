import com.android.build.api.dsl.LibraryExtension
import dev.project.eunmin.build.convention.configureAndroidCompose
import dev.project.eunmin.build.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
            }
        }
    }
}