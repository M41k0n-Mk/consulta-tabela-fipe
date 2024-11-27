package me.m41k0n.api;

import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

public interface VehicleAPI {
    String getType() throws CustomInterruptedException, CustomIOException;

    String getModel(String modelId) throws CustomInterruptedException, CustomIOException;

    String getYear(String modelId, String vehicleYear) throws CustomInterruptedException, CustomIOException;
}
