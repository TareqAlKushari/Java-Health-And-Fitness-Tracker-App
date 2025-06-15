package com.mycompany.health_and_fitness_tracker;

import java.util.ArrayList;

// An abstract class to represent a metric
abstract class Metric {
  String name; // The name of the metric
  ArrayList<Double> values; // The values of the metric

  // A constructor to create a new metric with an initial value
  public Metric(String name, double value) {
    this.name = name;
    this.values = new ArrayList<Double>();
    this.values.add(value); // Add the initial value to the list
  }

  // An abstract method to calculate the current value of the metric
  public abstract double getCurrentValue();

  // A method to add a new value to the list
  public void addValue(double value) {
    values.add(value); // Add the value to the list
  }

  // A method to print the history of the metric
  public void printHistory() {
    System.out.println(name + " history: "); // Print the name of the metric
    for (double v : values) { // Loop through the values list
      System.out.print((v) + " "); // Print each value with a space
    }
    System.out.println(); // Print a new line
  }
}


