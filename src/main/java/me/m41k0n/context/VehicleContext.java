package me.m41k0n.context;

import me.m41k0n.api.VehicleAPI;

public class VehicleContext {

    private final VehicleAPI strategy;

    public VehicleContext(VehicleAPI strategy) {
        this.strategy = strategy;
    }

    public String getData() {
        return strategy.getData();
    }
}
