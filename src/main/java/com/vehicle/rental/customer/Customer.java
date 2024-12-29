package com.vehicle.rental.customer;

import com.vehicle.rental.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String customerId;
    private final String name;
    private final List<Vehicle> rentalHistory;
    private Vehicle currentRental;

    public Customer(String customerId, String name) {
        if (customerId == null || customerId.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer details");
        }
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Vehicle getCurrentRental() {
        return currentRental;
    }

    public void setCurrentRental(Vehicle currentRental) {
        this.currentRental = currentRental;
    }

    public boolean isEligibleForRental() {
        return currentRental == null;
    }

    public void addRentalHistory(Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }
}
