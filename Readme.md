# Hytale Plugin Template README

This template helps you set up a Hytale plugin project. Follow these steps when creating your own plugin.

## Project Structure

hytale-plugin-template/
├── build.gradle.kts          # Gradle build file (edit group, version, jar settings)
├── gradle/
│   └── local.properties      # Optional: local overrides for HytaleServer.jar
├── gradle.properties         # Project-wide properties (plugin_version, java_version, hytaleServerJar)
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── src/
└── main/
├── java/
│   └── com/
│       └── yourname/
│           └── PluginMain.java  # Main plugin class
└── resources/
└── ...                     # Optional resource files

## Steps to Set Up Your Plugin

1. **Edit gradle.properties**
    - `plugin_version=1.0.0`  # Change to your plugin version
    - `java_version=25`       # Java version for compilation
    - `hytaleServerJar=/path/to/HytaleServer.jar`  # Absolute path to HytaleServer.jar

2. **(Optional) Edit gradle/local.properties**
    - `hytaleServerJar=/local/path/to/HytaleServer.jar`  # Overrides project path locally (do not commit)

3. **Edit build.gradle.kts**
    - `group = "com.yourname"`  # Change to match your package structure
    - `version = property("plugin_version")`  # Already reads from gradle.properties
    - `hytaleServerJarPath`  # Points to your HytaleServer.jar
    - `jar.destinationDirectory.set(file("/your/custom/path"))`  # Where the JAR will be built
    - `jar.archiveFileName.set("MyPlugin-${version}.jar")`  # Rename the final JAR

4. **Edit PluginMain.java**
    - `package com.yourname;`  # Match your chosen package
    - `class PluginMain extends JavaPlugin`  # Main plugin class
    - Implement the `setup()` method to register commands, events, etc.

## Notes

- Edit `gradle.properties` for project-wide values.
- Use `gradle/local.properties` for personal overrides (do not commit).
- The `jar` task `destinationDirectory` sets where the final JAR will be built.
- `shadowJar` produces an optional "-all" JAR with dependencies if needed.
- Keep package names consistent between `build.gradle.kts` and your `PluginMain.java` class.
- Always verify `hytaleServerJar` points to the correct Hytale dev server JAR.
