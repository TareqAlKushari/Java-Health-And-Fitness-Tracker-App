package com.mycompany.health_and_fitness_tracker;

import java.util.Scanner;

public class Health_and_fitness_tracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a scanner for user input

        System.out.println("Welcome to HealthTracker, an app for users to track their diet, physical activities, and health metrics.");

        System.out.println("Please enter your name: "); // Ask for the user's name
        String name = sc.nextLine(); // Read the user's name

        System.out.println("Please enter your height in meters: "); // Ask for the user's height
        double height = 0; // Initialize a variable for the height
        try {
            height = sc.nextDouble(); // Read the user's height
            if (height <= 0) { // If the height is not positive
                throw new Exception("Height must be positive."); // Throw an exception with a message
            }
        } catch (Exception e) { // Catch any exception
            System.out.println("Invalid input: " + e.getMessage()); // Print the error message
            return; // Exit the program
        }

        System.out.println("Please enter your current weight in kilograms: "); // Ask for the user's weight
        double weight = 0; // Initialize a variable for the weight
        try {
            weight = sc.nextDouble(); // Read the user's weight
            if (weight <= 0) { // If the weight is not positive
                throw new Exception("Weight must be positive."); // Throw an exception with a message
            }
        } catch (Exception e) { // Catch any exception
            System.out.println("Invalid input: " + e.getMessage()); // Print the error message
            return; // Exit the program
        }

        User user = new User(name, height, weight); // Create a new user object with the given values

        boolean exit = false; // A flag to indicate whether to exit the app or not

        while (!exit) { // Loop until exit is true
            System.out.println("What would you like to do?"); // Ask for the user's choice
            System.out.println("1. Record your food intake.");
            System.out.println("2. Record your physical activity.");
            System.out.println("3. Add a new weight measurement.");
            System.out.println("4. Start a new day.");
            System.out.println("5. View your health and fitness data.");
            System.out.println("6. Exit the app.");

            int choice = 0; // Initialize a variable for the choice
            try {
                choice = sc.nextInt(); // Read the user's choice
                if (choice < 1 || choice > 6) { // If the choice is not between 1 and 6
                    throw new Exception("Choice must be between 1 and 6."); // Throw an exception with a message
                }
            } catch (Exception e) { // Catch any exception
                System.out.println("Invalid input: " + e.getMessage()); // Print the error message
                sc.nextLine(); // Clear the input buffer
                continue; // Skip to the next iteration of the loop
            }

            switch (choice) { // Switch on the choice
                case 1: // If choice is 1
                    System.out.println("How many calories did you consume?"); // Ask for the calorie intake
                    int calories = 0; // Initialize a variable for the calories
                    try {
                        calories = sc.nextInt(); // Read the calorie intake
                        if (calories < 0) { // If the calories are negative
                            throw new Exception("Calories must be non-negative."); // Throw an exception with a message
                        }
                    } catch (Exception e) { // Catch any exception
                        System.out.println("Invalid input: " + e.getMessage()); // Print the error message
                        sc.nextLine(); // Clear the input buffer
                        break; // Break out of the switch statement
                    }
                    ((Calorie)user.metrics.get(2)).addCalories(calories); // Add the calories to the user's history using polymorphism and casting
                    System.out.println("Your calorie intake has been recorded."); // Confirm the action
                    break;
                case 2: // If choice is 2
                    System.out.println("How many steps did you take?"); // Ask for the calorie intake
                    int step = 0; // Initialize a variable for the steps
                    try {
                        step = sc.nextInt(); // Read the step take
                        if (step < 0) { // If the steps are negative
                            throw new Exception("Steps must be non-negative."); // Throw an exception with a message
                        }
                    } catch (Exception e) { // Catch any exception
                        System.out.println("Invalid input: " + e.getMessage()); // Print the error message
                        sc.nextLine(); // Clear the input buffer
                        break; // Break out of the switch statement
                    }
                    ((Step)user.metrics.get(3)).addSteps(step); // Add the step to the user's history using polymorphism and casting
                    System.out.println("Your steps take has been recorded."); // Confirm the action
                    break;
                case 3: // If choice is 3
                    System.out.println("What is your new weight?"); // Ask for the calorie intake
                    int newWeight = 0; // Initialize a variable for the new weight
                    try {
                        newWeight = sc.nextInt(); // Read the new weight intake
                        if (newWeight < 0) { // If the new weights are negative
                            throw new Exception("Weight must be non-negative."); // Throw an exception with a message
                        }
                    } catch (Exception e) { // Catch any exception
                        System.out.println("Invalid input: " + e.getMessage()); // Print the error message
                        sc.nextLine(); // Clear the input buffer
                        break; // Break out of the switch statement
                    }
                    ((Weight)user.metrics.get(0)).addWeight(newWeight); // Add the new weight to the user's history using polymorphism and casting
                    System.out.println("Your new weight has been recorded."); // Confirm the action
                    break;
                case 4: // If choice is 4
                    user.newDay();
                    System.out.println("Start a new day with zero calories and steps.");
                    break;
                case 5: // If choice is 5
                    System.out.println("Your health and fitness data are: ");
                    user.printData();
                    break;
                case 6: // If choice is 6
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input: ");
            }
        }
    }
}
