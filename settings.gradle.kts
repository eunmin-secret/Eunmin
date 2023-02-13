pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Eunmin"
include(":design:system-basic")
include(":design:system-compose")

include(":design:keyboard-compose")
include(":design:keyboard-basic")

include(":core:calculator")

include(":feature:calculator-compose")
include(":feature:calculator-basic")

include(":app:calculator-basic")
include(":app:calculator-compose")

