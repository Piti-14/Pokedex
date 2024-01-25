// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false

    //TODO añadimos el plugin de ksp
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}

//TODO añadimos la dependencia de hilt para la construcción del proyecto
buildscript {
    dependencies {
        val hiltVersion = "2.48.1" // Reemplazar con la versión más reciente
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}
