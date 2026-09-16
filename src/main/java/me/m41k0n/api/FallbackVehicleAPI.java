package me.m41k0n.api;

public class FallbackVehicleAPI implements VehicleAPI {
    private final VehicleAPI primary;
    private final VehicleAPI secondary;

    public FallbackVehicleAPI(VehicleAPI primary, VehicleAPI secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    @Override
    public String getBrandList() {
        try {
            return primary.getBrandList();
        } catch (RuntimeException e) {
            return secondary.getBrandList();
        }
    }

    @Override
    public String getModel(String brandCode) {
        try {
            return primary.getModel(brandCode);
        } catch (RuntimeException e) {
            return secondary.getModel(brandCode);
        }
    }

    @Override
    public String getYear(String brandCode, String modelCode) {
        try {
            return primary.getYear(brandCode, modelCode);
        } catch (RuntimeException e) {
            return secondary.getYear(brandCode, modelCode);
        }
    }

    @Override
    public String getTableFipeData(String brandCode, String modelCode, String yearCode) {
        try {
            return primary.getTableFipeData(brandCode, modelCode, yearCode);
        } catch (RuntimeException e) {
            return secondary.getTableFipeData(brandCode, modelCode, yearCode);
        }
    }
}
