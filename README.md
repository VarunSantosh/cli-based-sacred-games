# Welcome to my simple RPG Game

* It's called SACRED GAMES.
* The game is not that tough and you can win it with luck or with your smartness.

## Goal
The goal was to write a command line based role playing game.

## General comments
* I didn't really have much time to do this, so there are still many things to be improved.
* Test coverage is not sufficient, but since major part of the application is printing in console didn't get time to write integration test.

## Running
### IDE
just run `main` method in `priv.rdo.rpg.Main` class

JAR
------------------
```
java -jar cli-sacred-games-1.0.0.jar
```

## Building

Project is based on Maven and can be built using the following command
```
mvn clean package
```

## Unit Test Report
```
mvn surefire-report:report
```
