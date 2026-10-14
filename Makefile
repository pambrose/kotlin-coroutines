default: versions

clean:
	./gradlew clean

compile: build

build:
	./gradlew build -xtest

versions:
	./gradlew dependencyUpdates

upgrade-wrapper:
	./gradlew wrapper --gradle-version=9.8.1 --distribution-type=bin
	./gradlew wrapper --gradle-version=9.8.1 --distribution-type=bin