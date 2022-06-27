import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
		maven { setUrl("https://maven.vaadin.com/vaadin-addons") }
	}
}

plugins {
	id("com.vaadin") version "23.0.11"

	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"

	kotlin("plugin.jpa") version "1.4.32"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.allopen") version "1.4.32"
}

group = ""
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { setUrl("https://maven.vaadin.com/vaadin-addons")}
}

dependencyManagement {
	imports {
		mavenBom("com.vaadin:vaadin-bom:23.0.11")
	}
}

dependencies {
	implementation("com.vaadin:vaadin-spring-boot-starter:23.1.0")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.0")
	implementation("org.springframework.boot:spring-boot-starter-validation:2.7.0")
	implementation("org.springframework.boot:spring-boot-starter-web:2.7.0")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.9")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.9")

	runtimeOnly("com.h2database:h2:2.1.212")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools:2.7.0")

	implementation("org.vaadin.artur.exampledata:exampledata:3.4.0")
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
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
