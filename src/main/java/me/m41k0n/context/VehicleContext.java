package me.m41k0n.context;

import me.m41k0n.api.VehicleAPI;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

public class VehicleContext {
    private final VehicleAPI strategy;

    public VehicleContext(VehicleAPI strategy) {
        this.strategy = strategy;
    }

    public String getData() throws CustomInterruptedException, CustomIOException {
        return strategy.getData();
    }
}
