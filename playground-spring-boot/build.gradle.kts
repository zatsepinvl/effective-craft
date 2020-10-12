import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*buildscript {
    dependencies {
        classpath("gradle.plugin.com.palantir.gradle.docker:gradle-docker:0.25.0")
    }
}*/

plugins {
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.palantir.docker") version "0.25.0"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}

//keep values in lowercase - required for docker image name
group = "com.effective.playground"
version = "0.0.1-dev"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    //Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    //Security
    implementation("org.springframework.boot:spring-boot-starter-security")
    //Actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    //Hystrix
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix")
    //Cache
    implementation("org.springframework.boot:spring-boot-starter-cache")
    //Documentation
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    //Keycloak
    implementation("org.keycloak:keycloak-spring-boot-starter")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
    imports {
        mavenBom("org.keycloak.bom:keycloak-adapter-bom:4.8.3.Final")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR1")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.create<Copy>("unpack") {
    group = "build"
    val bootJarTask = tasks.bootJar.get()
    dependsOn(bootJarTask)
    from(zipTree(bootJarTask.outputs.files.singleFile))
    into("build/dependency")
}

docker {
    val bootJarTask = tasks.bootJar.get()
    name = "${project.name}-${project.version}"
    copySpec.from(tasks["unpack"].outputs).into("dependency")
    buildArgs(mapOf("DEPENDENCY" to "dependency"))
}

