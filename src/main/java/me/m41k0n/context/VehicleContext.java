package me.m41k0n.context;

import me.m41k0n.api.VehicleAPI;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

public class VehicleContext {
    private final VehicleAPI strategy;

    public VehicleContext(VehicleAPI strategy) {
        this.strategy = strategy;
    }

    public String getBrandList() throws CustomInterruptedException, CustomIOException {
        return strategy.getBrandList();
    }

    public String getModel(String brandCode) throws CustomInterruptedException, CustomIOException {
        return strategy.getModel(brandCode);
    }

    public String getYear(String brandCode, String modelCode) throws CustomInterruptedException, CustomIOException {
        return strategy.getYear(brandCode, modelCode);
    }

    public String getTableFipeData(String brandCode, String modelCode, String yearCode) throws CustomInterruptedException, CustomIOException {
        return strategy.getTableFipeData(brandCode, modelCode, yearCode);
    }
}
