plugins {
    kotlin("jvm") version "2.2.21"
    application
    id("buildlogic.common")
}

application.mainClass.set("com.sk89q.worldedit.internal.util.DocumentationPrinter")
tasks.named<JavaExec>("run") {
    workingDir = rootProject.projectDir
}

repositories {
    mavenLocal()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/groups/public/") }
    maven { url = uri("https://repo.codemc.org/repository/maven-public/") }
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    maven {
        name = "EngineHub"
        url = uri("https://maven.enginehub.org/repo/")
    }
}

dependencies {
    "compileOnly"("org.spigotmc:spigot:1.21.10-R0.1-SNAPSHOT") {
        exclude("junit", "junit")
    }
    "compileOnly"("org.spigotmc:spigot-api:1.21.10-R0.1-SNAPSHOT")
    "implementation"(project(":worldedit-libs:core:ap"))
    "implementation"(project(":worldedit-core"))
    "implementation"(kotlin("stdlib-jdk8"))
    "implementation"(kotlin("reflect"))
    "implementation"(libs.guava)
}
