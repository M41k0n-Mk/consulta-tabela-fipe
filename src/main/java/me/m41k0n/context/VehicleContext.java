package me.m41k0n.context;

import me.m41k0n.api.VehicleAPI;

public class VehicleContext {
    private final VehicleAPI strategy;

    public VehicleContext(VehicleAPI strategy) {
        this.strategy = strategy;
    }

    public String getBrandList() {
        return strategy.getBrandList();
    }

    public String getModel(String brandCode) {
        return strategy.getModel(brandCode);
    }

    public String getYear(String brandCode, String modelCode) {
        return strategy.getYear(brandCode, modelCode);
    }

    public String getTableFipeData(String brandCode, String modelCode, String yearCode) {
        return strategy.getTableFipeData(brandCode, modelCode, yearCode);
    }
}
