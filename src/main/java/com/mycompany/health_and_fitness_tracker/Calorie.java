package com.mycompany.health_and_fitness_tracker;

// A subclass to represent calorie intake as a metric
class Calorie extends Metric {
  // A constructor to create a new calorie intake with an initial value of zero
  public Calorie() {
    super("Calorie intake", 0); // Call the superclass constructor with the name and zero value
  }

  // A method to calculate the current calorie intake
  public double getCurrentValue() {
    return values.get(values.size() - 1); // Return the last value in the list
  }

  // A method to add a new calorie intake to the total
  public void addCalories(double calories) {
    double total = getCurrentValue(); // Get the current total
    total += calories; // Add the new calories to the total
    values.set(values.size() - 1, total); // Update the list with the new total
  }
}