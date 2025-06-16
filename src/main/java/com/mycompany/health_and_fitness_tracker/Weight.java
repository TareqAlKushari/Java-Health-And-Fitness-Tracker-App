package com.mycompany.health_and_fitness_tracker;


// A subclass to represent weight as a metric
class Weight extends Metric {
    // A constructor to create a new weight with an initial value
    public Weight(double value) {
      super("Weight", value); // Call the superclass constructor with the name and value
    }

    // A method to calculate the current weight
    @Override
    public double getCurrentValue() {
      return values.get(values.size() - 1); // Return the last value in the list
    }

    public void addWeight(double weight) {
        values.set(values.size() - 1, weight); // Update the list with the new total
    }
}
