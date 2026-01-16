import java.io.FileInputStream
import java.util.Properties

plugins {
    id("java")
    id("com.gradleup.shadow") version "9.3.1"
}

group = "com.venomie"
version = property("plugin_version") as String

repositories {
    mavenCentral()
}

// ------------------------
// HytaleServer JAR setup
// ------------------------
val localPropsFile = file("gradle/local.properties")
val localProps = Properties()
if (localPropsFile.exists()) {
    FileInputStream(localPropsFile).use { localProps.load(it) }
}

val hytaleServerJarPath = localProps.getProperty("hytaleServerJar")
    ?: property("hytaleServerJar") as String

val hytaleServerJar = file(hytaleServerJarPath)
require(hytaleServerJar.exists()) {
    "HytaleServer.jar not found at: $hytaleServerJarPath"
}

println("HytaleServerJar path: $hytaleServerJar")

dependencies {
    compileOnly(files(hytaleServerJar))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

// ------------------------
// Java setup
// ------------------------
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(property("java_version").toString().toInt()))
    withSourcesJar()
    withJavadocJar()
}

// ------------------------
// Tasks
// ------------------------
tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    test {
        useJUnitPlatform()
    }

    shadowJar {
        archiveClassifier.set("") // Optional: no "-all" suffix
    }

    jar {
        destinationDirectory.set(file("/mnt/c/Users/venom/Desktop"))
        archiveFileName.set("MyPlugin-${version}.jar")
    }
}
