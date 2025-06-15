package com.mycompany.health_and_fitness_tracker;

// A subclass to represent body mass index as a metric
class BMI extends Metric {
  double height; // The height of the user in meters

  // A constructor to create a new BMI with an initial value and height
  public BMI(double value, double height) {
    super("BMI", value); // Call the superclass constructor with the name and value
    this.height = height; // Set the height attribute
  }

  // A method to calculate the current BMI
  public double getCurrentValue() {
    double weight = values.get(values.size() - 1); // Get the latest weight from the list
    return weight / (height * height); // Return the BMI formula
  }
}
