package me.m41k0n.api;

import me.m41k0n.enums.VehicleType;
import me.m41k0n.service.APIConsume;

import java.net.http.HttpClient;

public class GenericVehicleAPI implements VehicleAPI {
    private final VehicleType vehicleType;

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final APIConsume apiConsume = new APIConsume(httpClient);
    private final String baseUrl = "https://parallelum.com.br/fipe/api/v1/";

    public GenericVehicleAPI(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getBrandList() {
        String url = baseUrl + vehicleType.getType() + "/marcas";
        return apiConsume.getData(url);
    }

    @Override
    public String getModel(String brandCode) {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + brandCode + "/modelos";
        return apiConsume.getData(url);
    }

    @Override
    public String getYear(String brandCode, String modelCode) {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + brandCode + "/modelos/" + modelCode + "/anos";
        return apiConsume.getData(url);
    }

    @Override
    public String getTableFipeData(String brandCode, String modelCode, String yearCode) {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + brandCode + "/modelos/" + modelCode + "/anos/" + yearCode;
        return apiConsume.getData(url);
    }
}
