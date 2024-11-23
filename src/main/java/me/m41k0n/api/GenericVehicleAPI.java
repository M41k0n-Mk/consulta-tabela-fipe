package me.m41k0n.api;

import me.m41k0n.APIConsume;
import me.m41k0n.enums.VehicleType;

import java.net.http.HttpClient;

public class GenericVehicleAPI implements VehicleAPI {
    private final VehicleType vehicleType;

    public GenericVehicleAPI(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getData() {
        HttpClient httpClient = HttpClient.newHttpClient();
        APIConsume apiConsume = new APIConsume(httpClient);
        String baseUrl = "https://parallelum.com.br/fipe/api/v1/";
        String url = baseUrl + vehicleType.getType() + "/marcas";
        return apiConsume.getData(url);
    }
}
