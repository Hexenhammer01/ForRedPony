plugins {
    kotlin("jvm") version "2.0.10"
}

group = "com.rail"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.rest-assured:rest-assured:5.3.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.10")
    testImplementation("io.rest-assured:json-path:5.3.0")
    testImplementation("io.rest-assured:kotlin-extensions:5.3.0")
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}