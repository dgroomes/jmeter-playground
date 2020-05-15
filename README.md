# jmeter-playground

Learning and exploring Apache JMeter <https://github.com/apache/jmeter> <https://jmeter.apache.org/index.html>.

---

This project creates a custom JMeter "Sampler" to exercise some custom Java code. Why is this useful? JMeter is a 
featureful load testing tool and is equipped with out-of-the-box controls to load test HTTP servers and databases via 
JDBC connections. But it doesn't have to stop there! With a custom sampler, you can instrument JMeter to load test any 
arbitrary thing that you can invoke using Java code. Want to load test a sorting algorithm you wrote in Java! You can do
that! 

### Instructions

1. Use Java 14
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