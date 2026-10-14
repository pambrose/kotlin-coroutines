# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Common Commands

### Build and Compilation

- `./gradlew build -xtest` - Build the project without running tests
- `./gradlew clean` - Clean build artifacts
- `make build` - Alternative build command via Makefile

### Dependency Management

- `./gradlew dependencyUpdates` - Check for dependency updates (also `make versioncheck`)
- `./gradlew wrapper --gradle-version=8.14.2 --distribution-type=bin` - Update Gradle wrapper

### Running Examples

All examples should be run with the `-Dkotlinx.coroutines.debug` JVM option to enable coroutine debugging and see custom
coroutine names. Each Kotlin file in the `src/main/kotlin/org/athenian/` directory contains a `main()` function that can
be executed directly.

## Project Architecture

### Overview

This is a Kotlin learning project focused on demonstrating various Kotlin coroutines concepts and patterns. It contains
practical examples organized by topic rather than a production application structure.

### Key Dependencies

- Kotlin 2.2.0 with JVM toolchain 17
- kotlinx-coroutines-core 1.10.2 (plus related coroutines libraries)
- Uses experimental coroutines APIs via compiler opt-ins

### Code Organization

#### Core Utilities (`src/main/kotlin/org/athenian/`)

- `Utils.kt` - Common utilities including thread name logging and delay functions
- `Jobs.kt` - Job status extension and cancellation examples

#### Example Categories

- `async/` - Async/await patterns and timing examples
- `blocking/` - runBlocking demonstrations
- `cancel/` - Cancellation handling patterns
- `channel/` - Channel types (Rendezvous, Buffered, Conflated)
- `deferred/` - Deferred value patterns and chaining
- `examples/` - Complex real-world scenarios (SharedFlow usage, etc.)
- `flow/` - Flow API demonstrations (hot vs cold streams)
- `globalscope/` - GlobalScope usage patterns
- `scan/` - Fold and scan operations
- `scope/` - Coroutine scope management
- `select/` - Select expressions for multiple coroutines
- `sharedflow/` - SharedFlow patterns

### Build Configuration

- Uses Gradle with Kotlin DSL
- Enables multiple experimental coroutines APIs via `freeCompilerArgs`
- Configured for parallel builds and caching
- Version information stored in `gradle.properties`

### Development Notes

- All examples are self-contained with `main()` functions
- Examples use the `log()` utility for thread-aware debugging output
- Common pattern: `runBlocking` wrapper with nested `launch`/`async` calls
- Focus on demonstrating specific coroutines concepts rather than application architecture