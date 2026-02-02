plugins {
    id("java-library")
    id("maven-publish")
}

group = "de.itsjxsper"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    // Velocity API
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")

    // JSpecify annotations
    compileOnly("org.jspecify:jspecify:1.0.0")

    // Adventure for Components
    api("net.kyori:adventure-api:4.17.0")
    api("net.kyori:adventure-text-minimessage:4.17.0")

    api("de.itsjxsper:aegyron-common:0.0.2")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}

val generateTemplates by tasks.registering(Copy::class) {
    val props = mapOf("version" to project.version)
    inputs.properties(props)

    from("src/main/templates")
    into(layout.buildDirectory.dir("generated/sources/templates"))
    expand(props)
}

sourceSets {
    main {
        java.srcDir(generateTemplates)
    }
}

tasks.javadoc {
    options.encoding = "UTF-8"
    (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Aegyron Velocity API")
                description.set(
                        "Public API for Aegyron Velocity Plugin - allows developers to integrate with Aegyron Core"
                )
                url.set("https://github.com/itsjxsper/aegyron")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("itsjxsper")
                        name.set("ItsJxsper")
                    }
                }
            }
        }
    }
}
