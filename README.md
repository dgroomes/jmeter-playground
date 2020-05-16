# jmeter-playground

Learning and exploring Apache JMeter <https://github.com/apache/jmeter> <https://jmeter.apache.org/index.html>.

---

This project creates a custom JMeter "Sampler" to exercise some custom Java code. Why is this useful? JMeter is a 
featureful load testing tool and is equipped with out-of-the-box controls to load test HTTP servers and databases via 
JDBC connections. But it doesn't have to stop there! With a custom sampler, you can instrument JMeter to load test any 
arbitrary thing that you can invoke using Java code. Want to load test a sorting algorithm you wrote in Java! You can do
that! 

### Instructions

1. Use Java 11
1. Install JMeter <https://jmeter.apache.org/download_jmeter.cgi>
1. Build the project into a `.jar` file `./gradlew jar`
1. Move the `.jar` into your JMeter installation's `lib/ext/` directory
  * E.g. `cp build/libs/jmeter-playground.jar ~/repos/opensource/jmeter/lib/ext/`
1. Open the JMeter GUI and you should see our custom Sampler named `EchoSampler`!
  * Create a simple JMeter "Test Plan" with these steps:
    1. Right-click "Test Plan" in the left-hand menu
    1. On the menu that appears, navigate through and select "Add" > "Threads (Users)" > "Thread Group"
    1. Right-click the "Thread Group" element that appears in the tree on the left
    1. On the menu that appears, navigate through and select "Add" > "Sampler" > "Java Request"
    1. On the "Java Request" screen that appears, click the dropdown menu
    1. You should see our custom sampler, "dgroomes.EchoServer" 

![JMeter screenshot](jmeter-screenshot.png "JMeter Screenshot")

### Notes

Run the test plan using JMeter's CLI mode with `jmeter -n -t echo-sampler-test-plan.jmx -l log.jtl -e -o test-report`.
JMeter recommends using CLI mode to execute test plans and GUI to define and edit test plans.

Open the test report in the browser to view the results of the test run! For example, on macOS the `open` command will
open a `.html` in your default browser. Use `open test-report/index.html`.

Before executing another run after the first run, you will have to delete the old `log.jtl` and `test-report/` 
directory. Do so with `rm log.jtl; rm -rf test-report`

### Distributing code with dependencies

The original example is contrived because it does not include dependencies. Most code that you want to load test will 
have some dependencies. The process to distribute those dependencies so that they are available to JMeter just takes a 
bit more effort and fortunately Gradle comes to save the day.

I'll illustrate this with a custom JMeter sampler that depends on the YAML Jackson extension component <https://github.com/FasterXML/jackson-dataformats-text/tree/master/yaml>.
What makes this example even more interesting is that JMeter already includes the core Jackson libraries but does not
include the Jackson YAML extension component library.

We use the `java-library-distribution` Gradle plugin and run the `installDist` task. Next, we configure JMeter to point
to the distribution files (i.e. the project's `.jar` and library `.jar` files). There are a couple options for 
configuring JMeter's classpath. See <https://jmeter.apache.org/usermanual/get-started.html#classpath>. We will leverage 
the `user.properties` file which provides some configuration hooks to customize JMeter's classpath to point to our 
distribution directories. JMeter, by convention, will read from a `user.properties` file if it exists in the current
directory.

Instructions:

1. `./gradlew installDist`
1. `./run-serializer-test.sh`
