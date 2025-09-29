rootProject.name = "HackathonGame"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

// APP
include(":composeApp")

// COMMON
include(":common:mvi:mvi-general")
include(":common:mvi:mvi-koin-voyager")
include(":common:logger")
include(":common:utils")

// FEATURES
include(":feature:main-screen:main-screen-api")
include(":feature:main-screen:main-screen-impl")
include(":feature:onboarding:onboarding-api")
include(":feature:onboarding:onboarding-impl")
include(":feature:course-screen:course-screen-api")
include(":feature:course-screen:course-screen-impl")

// CORE
include(":core:network")
include(":core:recources")
include(":core:settings")

// COMPONENTS
include(":components:pet")