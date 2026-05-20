plugins {
    java
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.opencollab.dev/main/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")
    compileOnly("org.geysermc.floodgate:api:2.2.5-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

version = "0.0.0"

// ===== Custom Deploy Configurations =====
val pluginName = project.name
val targetDirFile = file("C:/Users/taika/mcss/servers/rel_test/plugins")

tasks.jar {
    // Removed the build number variable, naming it standard plugin-version.jar
    archiveFileName.set("$pluginName-${project.version}.jar")
}

tasks.register("cleanOldPlugin") {
    doLast {
        val dir = targetDirFile
        dir.listFiles()?.forEach { file ->
            if (file.name.startsWith(pluginName) && file.name.endsWith(".jar")) {
                println("Deleting old plugin: ${file.name}")
                file.delete()
            }
        }
    }
}

tasks.register<Copy>("deployPlugin") {
    dependsOn(tasks.jar)
    dependsOn("cleanOldPlugin")

    from(tasks.jar)
    into(targetDirFile)
}

tasks.build {
    finalizedBy("deployPlugin")
}