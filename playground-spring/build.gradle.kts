import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

group = "com.effective"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

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

    testImplementation("org.springframework.boot:spring-boot-starter-test")

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
