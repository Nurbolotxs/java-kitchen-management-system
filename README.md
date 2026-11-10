# Java Kitchen Management System

A university Java OOP assignment that models a kitchen, chefs, and meal preparation.

## Features

- Models meals with types and completion status (`Meal`, `MealType`)
- Assigns meals to chefs based on their specialties
- Limits a kitchen to three chefs
- Tracks finished meals and calculates chef wages
- Validates selected constructor arguments
- Includes 10 JUnit 5 test methods across `KitchenTest` and `ChefTest`

## Technologies

Java, object-oriented programming, JUnit 5.

## Project structure

The original Java package layout is retained under `src/kitchen/`, including the accompanying tests. Compiled `.class` files are excluded.

## Running

Compile the source files with a Java JDK. The test classes require JUnit Jupiter 5 on the classpath. This repository does not currently include a Maven or Gradle build configuration.

## Notes

This is an educational assignment rather than a production-ready backend service. In particular, repeated cooking of the same meal is not prevented, and the finished-meals list is returned as mutable state.
