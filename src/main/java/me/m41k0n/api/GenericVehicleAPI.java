package me.m41k0n.api;

import me.m41k0n.APIConsume;
import me.m41k0n.enums.VehicleType;

public class GenericVehicleAPI implements VehicleAPI {
    private final VehicleType vehicleType;

    public GenericVehicleAPI(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getData() {
        APIConsume apiConsume = new APIConsume();
        String baseUrl = "https://parallelum.com.br/fipe/api/v1/";
        String url = baseUrl + vehicleType.getType() + "/marcas";
        return apiConsume.getData(url);
    }
}
