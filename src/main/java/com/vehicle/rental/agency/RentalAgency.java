package com.vehicle.rental.agency;

import com.vehicle.rental.vehicle.Vehicle;
import com.vehicle.rental.customer.Customer;
import com.vehicle.rental.transaction.RentalTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentalAgency {
    private final List<Vehicle> fleet;
    private final List<RentalTransaction> transactions;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public void processRental(String customerId, String vehicleId, int days, Customer customer) {
        Vehicle selectedVehicle = fleet.stream()
                .filter(v -> v.getVehicleId().equals(vehicleId) && v.isAvailableForRental())
                .findFirst().orElse(null);

        if (selectedVehicle != null && customer.isEligibleForRental()) {
            selectedVehicle.setAvailable(false);
            customer.setCurrentRental(selectedVehicle);
            customer.addRentalHistory(selectedVehicle);
            RentalTransaction transaction = new RentalTransaction(UUID.randomUUID().toString(), selectedVehicle, customer, days);
            transactions.add(transaction);
        } else {
            throw new IllegalStateException("Rental cannot be processed.");
        }
    }

    public void returnRental(Customer customer) {
        Vehicle rentedVehicle = customer.getCurrentRental();
        if (rentedVehicle != null) {
            rentedVehicle.setAvailable(true);
            customer.setCurrentRental(null);
        }
    }

    public void generateReport() {
        for (RentalTransaction transaction : transactions) {
            System.out.printf("Transaction ID: %s | Customer: %s | Vehicle: %s | Days: %d | Cost: %.2f%n",
                    transaction.getTransactionId(), transaction.getCustomer().getName(),
                    transaction.getVehicle().getModel(), transaction.getRentalDays(),
                    transaction.getCost());
        }
    }
}
