import com.android.build.gradle.api.AndroidBasePlugin
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.groovy.scripts.BasicScript

object S {

    @JvmStatic
    fun feature(script: BasicScript, name: String) {
        with(script.project) {
            apply("from" to file("${rootDir.absolutePath}/gradle/feature-$name.gradle"))
        }
    }

    @JvmStatic
    fun isAndroid(script: BasicScript): Boolean {
        with(script.project) {
            return plugins.hasPlugin(AndroidBasePlugin::class.java)
        }
    }

    @JvmStatic
    fun isJava(script: BasicScript): Boolean {
        with(script.project) {
            return plugins.hasPlugin(JavaBasePlugin::class.java)
        }
    }
}