package me.m41k0n.api;

public interface VehicleAPI {
    String getBrandList();

    String getModel(String brandCode);

    String getYear(String brandCode, String modelCode);

    String getTableFipeData(String brandCode, String modelCode, String yearCode);
}