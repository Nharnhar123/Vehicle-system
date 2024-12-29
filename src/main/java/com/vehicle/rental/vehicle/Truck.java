package com.vehicle.rental.vehicle;

public class Truck extends Vehicle {
    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.5; // 50% extra charge
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
