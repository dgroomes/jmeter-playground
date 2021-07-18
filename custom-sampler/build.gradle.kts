plugins {
    java
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.30" // Make sure to use the version that is bundled with JMeter!
val jmeterVersion =
    "5.4.1" // releases: https://jmeter.apache.org/changes_history.html AND https://github.com/apache/jmeter/releases

dependencies {
    /*
    Specify the JMeter dependencies as `compileOnly`. These dependencies *do not* need to be included in the
    distribution because they are already bundled in JMeter itself. So, they are needed only as compile-time
    dependencies. SLF4J is also bundled in JMeter.

    To see the versions of dependencies that are bundled in JMeter, refer to the gradle.properties file in the JMeter project, like this https://github.com/apache/jmeter/blob/rel/v5.4.1/gradle.properties#L122
    */
    compileOnly("org.apache.jmeter:ApacheJMeter_java:$jmeterVersion")
    compileOnly("org.slf4j:slf4j-api:$slf4jVersion")
}

configurations.all {
    exclude(
        group = "org.apache.jmeter",
        module = "bom"
    ) // Exclude the JMeter "bom" dependency (Bill of Materials) because it doesn't actually exist. See https://bz.apache.org/bugzilla/show_bug.cgi?id=64465 and https://discuss.gradle.org/t/opt-out-of-gradle-module-metadata-for-a-specific-dependency/37051/2
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
