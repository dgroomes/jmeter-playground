plugins {
    java
}

repositories {
    mavenCentral()
}

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
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
