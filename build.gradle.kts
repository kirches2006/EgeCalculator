plugins {
    java
}

group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:5.3.39")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}