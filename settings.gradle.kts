rootProject.name = "jmeter-playground"

// What is the point of defining a Gradle project in the root of this repository? After all, each of the subprojects
// are independently runnable... What does it mean to "run the root project"?
//
// Answer:
//
// Defining a Gradle project in the root of the repository is basically to appease Intellij. Intellij has a
// a desire to impose structure on any project you open. This is a good feature of Intellij because you can `git clone`
// a project, open it in Intellij, and immediately have code completion and intelligent project navigation. Intellij can
// do this for projects that use a "well-known project structure" like a Maven project with a 'pom.xml' file in the root
// directory or a Gradle project with a 'settings.gradle' or 'settings.gradle.kts' file in the root directory.
//
// Unfortunately, Intellij does not automatically recognize "orphaned" projects. In other words, if you opened this
// project in Intellij and there was no 'settings.gradle.kts' file in the root directory then Intellij would just give
// up. It would not know to go into each of the subproject directories and recognize them as standalone Gradle
// projects. You would not get the out-of-the-box code completion and project navigation that you are used to with
// Intellij. Instead, you would have to go to the Intellij "Project Structure" settings and add the subprojects
// one-by-one as "Intellij Modules". This is a poor user experience.
//
// To avoid this poor user experience, we can define a root Gradle project and include each of the subprojects via
// Gradle "included builds". See https://docs.gradle.org/current/userguide/composite_builds.html. Now, when someone
// clones this repo and opens it in Intellij, all the subprojects are automatically identified by Intellij and indexed.
// You get code completion and project navigation out-of-the-box. Pretty slick!
includeBuild("custom-sampler")
includeBuild("with-dependencies")
