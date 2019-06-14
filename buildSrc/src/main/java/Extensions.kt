import org.gradle.api.Project
import org.gradle.groovy.scripts.BasicScript

internal val BasicScript.project
    get() = this.properties["project"] as Project

internal fun Project.apply(pair: Pair<String, Any>) {
    apply(mutableMapOf(pair))
}