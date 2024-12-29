package com.vehicle.rental.transaction;

import com.vehicle.rental.vehicle.Vehicle;
import com.vehicle.rental.customer.Customer;

public class RentalTransaction {
    private final String transactionId;
    private final Vehicle vehicle;
    private final Customer customer;
    private final int rentalDays;
    private final double cost;

    public RentalTransaction(String transactionId, Vehicle vehicle, Customer customer, int rentalDays) {
        if (transactionId == null || transactionId.isEmpty() || vehicle == null || customer == null || rentalDays <= 0) {
            throw new IllegalArgumentException("Invalid Transaction details");
        }
        this.transactionId = transactionId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDays = rentalDays;
        this.cost = vehicle.calculateRentalCost(rentalDays);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getCost() {
        return cost;
    }
}
