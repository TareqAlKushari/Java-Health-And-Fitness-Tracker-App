package com.mycompany.health_and_fitness_tracker;

import java.util.ArrayList;

// A class to represent a user
class User {
  String name; // The user's name
  ArrayList<Metric> metrics; // The user's metrics

  // A constructor to create a new user with initial values
  public User(String name, double height, double weight) {
    this.name = name;
    this.metrics = new ArrayList<Metric>();
    this.metrics.add(new Weight(weight)); // Add a new weight metric with the initial value
    this.metrics.add(new BMI(weight / (height * height), height)); // Add a new BMI metric with the initial value and height
    this.metrics.add(new Calorie()); // Add a new calorie metric with zero value
    this.metrics.add(new Step()); // Add a new step metric with zero value
  }

  // A method to start a new day with zero calories and steps
  public void newDay() {
    metrics.get(2).addValue(0); // Add zero calories for the new day
    metrics.get(3).addValue(0); // Add zero steps for the new day
  }

  // A method to print the user's health and fitness data
  public void printData() {
    System.out.println("Name: " + name); // Print the name

    for (Metric m : metrics) { // Loop through the metrics list
      m.printHistory(); // Print each metric's history
      System.out.println(m.name + ": " + m.getCurrentValue()); // Print each metric's current value
    }

    System.out.println("Health and fitness insights: "); // Print the insights header

    double avgCalories = 0; // Initialize a variable for the average calorie intake
    for (double c : metrics.get(2).values) { // Loop through the calorie values list
      avgCalories += c; // Add each calorie to the sum
    }
    avgCalories /= metrics.get(2).values.size(); // Divide the sum by the number of days

    System.out.println("- Your average daily calorie intake is " + (avgCalories) + " kcal."); // Print the average calorie intake

    double avgSteps = 0; // Initialize a variable for the average step count
    for (double s : metrics.get(3).values) { // Loop through the step values list
      avgSteps += s; // Add each step to the sum
    }
    avgSteps /= metrics.get(3).values.size(); // Divide the sum by the number of days

    System.out.println("- Your average daily step count is " + (avgSteps) + " steps."); // Print the average step count

    double weightChange = metrics.get(0).getCurrentValue() - metrics.get(0).values.get(0); // Calculate the weight change from the first to the last day

    if (weightChange > 0) { // If the weight change is positive
      System.out.println("- You have gained " + (weightChange) + " kg since you started using this app."); // Print the weight gain
    } else if (weightChange < 0) { // If the weight change is negative
      System.out.println("- You have lost " + (-weightChange) + " kg since you started using this app."); // Print the weight loss
    } else { // If the weight change is zero
      System.out.println("- Your weight has not changed since you started using this app."); // Print no change
    }

    if (metrics.get(1).getCurrentValue() < 18.5) { // If the BMI is underweight
      System.out.println("- Your BMI is " + (metrics.get(1).getCurrentValue()) + ", which is considered underweight. You may want to increase your calorie intake and consult a doctor."); // Print the underweight message
    } else if (metrics.get(1).getCurrentValue() >= 18.5 && metrics.get(1).getCurrentValue() < 25) { // If the BMI is normal
      System.out.println("- Your BMI is " + (metrics.get(1).getCurrentValue()) + ", which is considered normal. You are doing well!"); // Print the normal message
    } else if (metrics.get(1).getCurrentValue() >= 25 && metrics.get(1).getCurrentValue() < 30) { // If the BMI is overweight
      System.out.println("- Your BMI is " + (metrics.get(1).getCurrentValue()) + ", which is considered overweight. You may want to reduce your calorie intake and increase your physical activity."); // Print the overweight message
    } else { // If the BMI is obese
      System.out.println("- Your BMI is " + (metrics.get(1).getCurrentValue()) + ", which is considered obese. You may want to consult a doctor and follow a healthy diet and exercise plan."); // Print the obese message
    }
  }
}

