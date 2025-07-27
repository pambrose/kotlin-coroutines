plugins {
  java
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.versions)
}

group = "org.athenian"
version = "1.0-SNAPSHOT"

repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.kotlinx.coroutines.jdk8)
  implementation(libs.kotlinx.coroutines.slf4j)
  implementation(libs.kotlinx.coroutines.debug)
}

kotlin {
  jvmToolchain(17)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  compilerOptions {
    freeCompilerArgs.addAll(
      "-opt-in=kotlin.time.ExperimentalTime",
      "-opt-in=kotlinx.coroutines.FlowPreview",
      "-opt-in=kotlinx.coroutines.DelicateCoroutinesApi",
      "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
      "-opt-in=kotlinx.coroutines.InternalCoroutinesApi"
    )
  }
}