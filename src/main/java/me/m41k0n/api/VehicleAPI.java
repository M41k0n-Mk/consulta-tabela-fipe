package me.m41k0n.api;

import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

public interface VehicleAPI {
    String getBrandList() throws CustomInterruptedException, CustomIOException;

    String getModel(String brandCode) throws CustomInterruptedException, CustomIOException;

    String getYear(String brandCode, String modelCode) throws CustomInterruptedException, CustomIOException;

    String getTableFipeData(String brandCode, String modelCode, String yearCode) throws CustomInterruptedException, CustomIOException;
}
