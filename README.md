# An introductory tutorial on Gradle 5 and JUnit 5

This tutorial fits into a series of spy-themed tutorials introducing some common tools that software developers working in the Java ecosystem tend to use. They are written for second year undergraduate students, but as I'm aware that many students already have prior programming experience, I tend to make them slightly quirky and spy-story themed to help them be lighthearted.

This tutorial introduces 

- Gradle - a build system that can comple your code and run tests against it, and 
- JUnit - an automated testing framework

... plus some cult tv references to the 1960s spy shows *Dangerman* and *The Prisoner* to support the contrived and convoluted stories that are going to take place in our tutorials...

## Welcome to the Village

John Drake has recently resigned from the British secret service, for reasons unknown. The following morning, he awakens in The Village to discover he is "Number Six".  All villagers have a number, and nobody knows who are the villagers and who are the warders.

In this tutorial, we're going to use the tests to introduce our characters.

* Villagers are mostly retired secret service staff from around the world, sent to the retirement home of the Village where they can live out their days safely and comfortably. They will happily tell you their number, never their name, and if you ask them where they come from they "can't remember".

* The Village is the town where they live. It is like a holiday camp that nobody can ever leave.

* Wardens are Villagers who have a special role - watching over the other villagers to make sure that no secrets are leaked. Nobody knows who is a Warden or who is a Villager.

## How to complete this tutorial

1. **Clone the tutorial.** The tutorial is a git repository, so you can obtain the code using git with 

     ```sh
     git clone https://github.com/wbillingsley/tutorial-welcometothevillage.git
     ```

   Once you have done so, you should have a directory `tutorial-welcometothevillage` containing all the files from this repository.

2. **Explore the code.** The tutorial is also a gradle project. I recommend opening the folder it is in either in Visual Studio Code or in IntelliJ IDEA.

   Notice how there is a directory tree `src/main/java` containing the Java code implementing classes for our different characters.
   Notice how there is another directory tree `src/test/java` containing some more Java code - the tests we will run.
   And at the top level of the project, there are files `build.gradle` and `settings.gradle` defining the project.

3. **Run the tests.** As the project definition has been written for you, there are several tasks that can be run immediately. First, run the tests.

   * Open a terminal in the `tutorial-welcometothevillage` directory

   * Run `gradle test`

   * When it has finished, open the file `build/reports/tests/test/index.html` in a web browser to see what the results of the tests were. (Not all of them will have passed.)

4. **Open the tests.** Open the project in an IDE - either Visual Studio Code or IntelliJ IDEA. Open `src/test/java/TutorialTest.java` in your editor. 
   The instructions and the spy story take place in this file. 