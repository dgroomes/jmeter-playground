plugins {
    java
    /*
     Apply the java-library-distribution plugin to add support for distributing the source .jar and library .jar files
     so they can be used by JMeter. See the plugin docs at https://docs.gradle.org/current/userguide/java_library_distribution_plugin.html
     */
    `java-library-distribution`
}

repositories {
    mavenCentral()
}

val jacksonVersion = "2.11.0"
val jmeterVersion = "5.1.1"
val slf4jVersion = "1.7.30"

dependencies {
    /*
    Specify the JMeter dependencies as `compileOnly`. These dependencies *do not* need to be included in the
    distribution because they are already included in JMeter itself. So, they are needed only as compile-time
    dependencies. SLF4J is also included in JMeter.
     */
    compileOnly(group = "org.apache.jmeter", name = "ApacheJMeter_java", version = jmeterVersion)
    compileOnly(platform("org.apache.jmeter:ApacheJMeter_parent:$jmeterVersion"))
    compileOnly(group = "org.slf4j", name = "slf4j-api", version = slf4jVersion)

    /*
    Here is a library that is *not* included in JMeter. So, we specify it as a "implementation" dependency and therefore
    it will get included in the distribution.
     */
    implementation(group = "com.fasterxml.jackson.dataformat", name = "jackson-dataformat-yaml", version = jacksonVersion) {
        /*
        Some of the Jackson modules are already included in JMeter, so we should exclude them so they do not get
        included in the distribution. It would be redundant to include them twice.
         */
        exclude(group = "com.fasterxml.jackson.core")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
