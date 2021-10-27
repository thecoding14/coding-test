Notes for the reviewer:

# Dependencies
Java 11
Gradle 3.5 - Included within project

# Martian Robots
This is a CLI implementation of problem.


# Running the project 

## Build and run using gradle
Build the project using the following command from the project folder
```
./gradlew build
```

To run the project from command line :

```
cd build/libs
java -jar coding-test-0.0.1-SNAPSHOT.jar
```


## Using an IDE
Please run RobotApplication.java.

# Improvements Required:

1. Some code refactor is required to improve the validation of commands. It can be done using predicates instead of 'if' blocks.
2. Having a pool of Position objects would be cool similar to String pool.
3. Testing the command-line support is not straightforward without using a third party library. I would have loved to have the end to end test for commandline but had to leave it at InstructionExecutor.
4. Error messages are mostly covered but some rounding the edges is still left to do (like invalid commands return null at the moment)
5. Robot.moveForward() method doesn't look very clean, can be refactored further.


