package me.m41k0n.api;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

import me.m41k0n.enums.VehicleType;
import me.m41k0n.service.APIConsume;

public class GenericVehicleAPI implements VehicleAPI {
    private final VehicleType vehicleType;
    private final APIConsume apiConsume;
    private final String baseUrl = "https://parallelum.com.br/fipe/api/v1/";

    public GenericVehicleAPI(VehicleType vehicleType) {
        this(vehicleType, new APIConsume(HttpClient.newHttpClient()));
    }

    public GenericVehicleAPI(VehicleType vehicleType, APIConsume apiConsume) {
        this.vehicleType = vehicleType;
        this.apiConsume = apiConsume;
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    @Override
    public String getBrandList() {
        String url = baseUrl + vehicleType.getType() + "/marcas";
        return apiConsume.getData(url);
    }

    @Override
    public String getModel(String brandCode) {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + encode(brandCode) + "/modelos";
        return apiConsume.getData(url);
    }

    @Override
    public String getYear(String brandCode, String modelCode) {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + encode(brandCode) + "/modelos/" + encode(modelCode) + "/anos";
        return apiConsume.getData(url);
    }

    @Override
    public String getTableFipeData(String brandCode, String modelCode, String yearCode) {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + encode(brandCode) + "/modelos/" + encode(modelCode) + "/anos/" + encode(yearCode);
        return apiConsume.getData(url);
    }
}
