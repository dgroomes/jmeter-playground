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

val slf4jVersion = "1.7.36" // Make sure to use the version that is bundled with JMeter! https://github.com/apache/jmeter/blob/9f803e313abfef04516bd7b4c1e50f85b619f4f3/src/bom-thirdparty/build.gradle.kts#L139
val jacksonVersion = "2.15.2" // Make sure to use the version that is bundled with JMeter! https://github.com/apache/jmeter/blob/9f803e313abfef04516bd7b4c1e50f85b619f4f3/src/bom-thirdparty/build.gradle.kts#L45
val jmeterVersion =
    "5.6.1" // releases: https://jmeter.apache.org/changes_history.html AND https://github.com/apache/jmeter/releases

dependencies {
    /*
    Specify the JMeter dependencies as `compileOnly`. These dependencies *do not* need to be included in the
    distribution because they are already included in JMeter itself. So, they are needed only as compile-time
    dependencies. Among the dependencies included in JMeter are SLF4J and the core Jackson modules.
    */
    compileOnly(group = "org.apache.jmeter", name = "ApacheJMeter_java", version = jmeterVersion)
    /*
    Among the dependencies included in JMeter are SLF4J and the core Jackson modules. These dependencies are not visible
    in the Gradle build unless we explicitly declare a dependency on them. So, we must declare them as dependencies. Again,
    we only use "compileOnly" and not "implementation" because we only need them to compile against. They are already bundled
    inside of the JMeter distribution itself. With this knowledge, we can code our JMeter plugin to use the specific version
    of Jackson bundled in JMeter and avoid a "dependency hell" situation where we might be trying to use a newer version
    of Jackson which breaks JMeter at runtime.

    To see the versions of dependencies that are bundled in JMeter, refer to the gradle.properties file in the JMeter project, like this https://github.com/apache/jmeter/blob/rel/v5.4.1/gradle.properties#L95
    */
    compileOnly("org.slf4j:slf4j-api:$slf4jVersion")
    compileOnly("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")

    /*
    Here is a library that is *not* included in JMeter. So, we specify it as a "implementation" dependency and therefore
    it will get included in the distribution.
    */
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion") {
        /*
        Some of the Jackson modules are already included in JMeter, so we should exclude them so they do not get
        included in the distribution. It would be redundant to include them twice.
        */
        exclude(group = "com.fasterxml.jackson.core")
    }
}

configurations.all {
    exclude(
        group = "org.apache.jmeter",
        module = "bom"
    ) // Exclude the JMeter "bom" dependency (Bill of Materials) because it doesn't actually exist. See https://bz.apache.org/bugzilla/show_bug.cgi?id=64465 and https://discuss.gradle.org/t/opt-out-of-gradle-module-metadata-for-a-specific-dependency/37051/2
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
