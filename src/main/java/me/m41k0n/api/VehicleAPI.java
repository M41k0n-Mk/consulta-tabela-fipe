package me.m41k0n.api;

import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

public interface VehicleAPI {
    String getData() throws CustomInterruptedException, CustomIOException;
}
