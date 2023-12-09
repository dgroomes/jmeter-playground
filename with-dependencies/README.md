# with-dependencies

This subproject creates a custom JMeter "Sampler" using custom Java code and additional Java library dependencies.


## Overview

This project creates a custom JMeter "Sampler" to exercise some custom Java code which requires additional Java library
dependencies. Why is this useful? Building and distributing a project with dependencies always requires some configuration
boilerplate and loading those dependencies into `jmeter` requires even more configuration. So, this subproject serves as
a working example for doing exactly that. 

Specifically, this project defines a custom JMeter sampler that depends on the [YAML Jackson extension component](https://github.com/FasterXML/jackson-dataformats-text/tree/master/yaml).
What makes this example even more interesting is that JMeter already includes the core Jackson libraries but does not
include the Jackson YAML extension component library.

To build the project and create its so-called "distributable" files we use the `java-library-distribution` Gradle plugin
and run the `installDist` task. Next, we configure JMeter to point to the distribution files (i.e. the project's `.jar`
and library `.jar` files). There are a couple [options for configuring JMeter's classpath](https://jmeter.apache.org/usermanual/get-started.html#classpath).
We will leverage the `user.properties` file which provides some configuration hooks to customize JMeter's classpath to
point to the project's distribution directories. JMeter, by convention, will read from a `user.properties` file if it
exists in the current directory.


## Instructions

1. Use Java 17
2. Compile the project source code and build the distribution files:
   * ```shell
     ./gradlew installDist
     ```
3. Run the JMeter load test:
   * ```shell
     ./run-serializer-test.sh
     ```

