package com.mycompany.health_and_fitness_tracker;

// A subclass to represent step count as a metric
class Step extends Metric {
  // A constructor to create a new step count with an initial value of zero
  public Step() {
    super("Step count", 0); // Call the superclass constructor with the name and zero value
  }

  // A method to calculate the current step count
  public double getCurrentValue() {
    return values.get(values.size() - 1); // Return the last value in the list
  }

  // A method to add a new step count to the total
  public void addSteps(double steps) {
    double total = getCurrentValue(); // Get the current total
    total += steps; // Add the new steps to the total
    values.set(values.size() - 1, total); // Update the list with the new total
  }
}