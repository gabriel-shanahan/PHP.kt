plugins {
    kotlin("jvm") version "1.3.61"

    `java-library`

    id("org.jmailen.kotlinter") version "2.1.3"
    id("io.gitlab.arturbosch.detekt").version("1.2.2")
    id("org.sonarqube") version "2.8"
    id("org.jetbrains.dokka") version "0.10.0"
}

repositories {
    mavenCentral()
    jcenter()
}

group = "cz.php.kt"
version = "0.0.1a"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // Adds detekt wrapper around ktlint
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.0.1")
}

tasks {
    test {
        // Always run detekt (and through the klint wrapper, klint) when running tests
        finalizedBy(detekt)

        testLogging {
            // Make sure output from
            // standard out or error is shown
            // in Gradle output.
            showStandardStreams = true
        }
    }

    dokka {
        outputFormat = "html"
        outputDirectory = "$buildDir/javadoc"
        configuration {
            includeNonPublic = true
        }
    }
}

detekt {
    toolVersion = "1.2.2"
    parallel = true // Builds the AST in parallel. Rules are always executed in parallel.
}
