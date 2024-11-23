package me.m41k0n.api;

import me.m41k0n.APIConsume;

public class GenericVehicleAPI implements VehicleAPI {
    private final String vehicleType;

    public GenericVehicleAPI(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getData() {
        APIConsume apiConsume = new APIConsume();
        String baseUrl = "https://parallelum.com.br/fipe/api/v1/";
        String url = baseUrl + vehicleType + "/marcas";
        return apiConsume.getData(url);
    }
}
