# Poker
Scala Bootcamp task

In order to compile the project, JDK of version 8+ installation is required.
Also, environmental variables JAVA_HOME and PATH must be updated with corresponding installation folder

To compile the project, clone this repository and navigate to src folder of the project. Then execute javac com/company/Poker.java to compile the project
Program execution can be triggered using such command: java com/company/Poker.java

Omaha command line switch is implemented, executing java com/company/Poker.java --omaha  - will switch to omaha holdem rules

Below exceptions are handled:

1) Check if board card amount is equal to 5
2) Check if hand amount is equal to 2 or 4 depending on rules
3) Check if card is specified correctly
4) Check if all ranks are specified correctly
5) Check if all suits are specified correctly
6) Check if there is any duplicate cards

There is no validation on max card amount, but it should be handled either via suit/rank validation or duplicate card validation
