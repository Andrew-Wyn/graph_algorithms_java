[![Build Status](https://travis-ci.com/Andrew-Wyn/graph_algorithms_java.svg?branch=master)](https://travis-ci.com/Andrew-Wyn/graph_algorithms_java)



<h1> Build with GRADLE </h1>

<img src="https://github.com/gradle/gradle/blob/master/gradle.png" width="350px" alt="Gradle Logo" />

Gradle is a build tool with a focus on build automation and support for multi-language development. If you are building, testing, publishing, and deploying software on any platform, Gradle offers a flexible model that can support the entire development lifecycle from compiling and packaging code to publishing web sites. Gradle has been designed to support build automation across multiple languages and platforms including Java, Scala, Android, C/C++, and Groovy, and is closely integrated with development tools and continuous integration servers including Eclipse, IntelliJ, and Jenkins.

For more information about Gradle, please visit: https://gradle.org

This project adheres to the [Gradle Code of Conduct](https://gradle.org/conduct/). By participating, you are expected to uphold this code.

## Downloading (Gradle)

You can download released versions and nightly build artifacts from: https://gradle.org/downloads

### Installing from source

To create an install from the source tree you can run either of the following:

    ./gradlew install -Pgradle_installPath=/usr/local/gradle-source-build

This will create a minimal installation; just what's needed to run Gradle (i.e. no docs).

You can then build a Gradle based project with this installation:

    /usr/local/gradle-source-build/bin/gradle «some task»

To create a full installation (includes docs):

    ./gradlew installAll -Pgradle_installPath=/usr/local/gradle-source-build
