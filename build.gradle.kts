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

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")

    // Mockito (необязательно, но пригодится для ResultsProcessor)
    testImplementation("org.mockito:mockito-core:5.12.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.test {
    useJUnitPlatform() // ВАЖНО! Подключает JUnit 5
}