# Hytale Plugin Template README

This template helps you set up a Hytale plugin project. Edit the following files for your project.

Files and Variables to Edit:

gradle.properties:
plugin_version=1.0.0           # Change to your plugin version
java_version=25                # Java version for compilation
hytaleServerJar=/path/to/HytaleServer.jar   # Absolute path to HytaleServer.jar

gradle/local.properties (optional):
hytaleServerJar=/local/path/to/HytaleServer.jar   # Overrides project path locally

build.gradle.kts:
- group = "com.yourname"                  # Change to match your package structure
- version = property("plugin_version")    # Already reads from gradle.properties
- hytaleServerJarPath                      # Points to your HytaleServer.jar
- jar.destinationDirectory.set(file("/your/custom/path"))  # Where JAR builds to
- jar.archiveFileName.set("MyPlugin-${version}.jar")        # Rename final JAR

PluginMain.java:
- package com.yourname;                     # Match your chosen package
- class PluginMain extends JavaPlugin       # Main plugin class
- setup() method                            # Register commands, events, etc.

Notes:
- Edit gradle.properties for project-wide values.
- Use gradle/local.properties for personal overrides (do not commit).
- jar task destinationDirectory sets where the final JAR will be built.
- shadowJar produces an optional "-all" JAR with dependencies if needed.
