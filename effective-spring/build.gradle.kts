import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"

    // String
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    // https://github.com/palantir/gradle-docker - a Gradle plugin for orchestrating docker builds and pushes
    id("com.palantir.docker") version "0.25.0"
}

group = "com.effective"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val testcontainersVersion = "1.15.3"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // MongoDB
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // CSV streaming
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.12.1")

    // GraphQL
    //      Main graphql java lib
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:11.1.0")
    //      Generates GraphQLSchema from *.graphqls class: https://www.graphql-java-kickstart.com/tools/
    implementation("com.graphql-java-kickstart:graphql-java-tools:11.0.1")
    //      Runs graphql playground webapp
    runtimeOnly("com.graphql-java-kickstart:graphiql-spring-boot-starter:11.1.0")
    //

    // Docker client
    implementation("com.github.docker-java:docker-java:3.2.8")
    implementation("com.github.docker-java:docker-java-transport-httpclient5:3.2.8")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Cache
    implementation("org.springframework.boot:spring-boot-starter-cache")

    // Documentation
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    // Spring test
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //Test containers
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")
}


dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${testcontainersVersion}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
