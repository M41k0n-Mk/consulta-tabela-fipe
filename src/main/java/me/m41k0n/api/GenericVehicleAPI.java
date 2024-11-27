package me.m41k0n.api;

import me.m41k0n.enums.VehicleType;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;
import me.m41k0n.service.APIConsume;

import java.net.http.HttpClient;

public class GenericVehicleAPI implements VehicleAPI {
    private final VehicleType vehicleType;

    HttpClient httpClient = HttpClient.newHttpClient();
    APIConsume apiConsume = new APIConsume(httpClient);
    String baseUrl = "https://parallelum.com.br/fipe/api/v1/";

    public GenericVehicleAPI(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getBrandList() throws CustomInterruptedException, CustomIOException {
        String url = baseUrl + vehicleType.getType() + "/marcas";
        return apiConsume.getData(url);
    }

    @Override
    public String getModel(String brandCode) throws CustomInterruptedException, CustomIOException {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + brandCode + "/modelos";
        return apiConsume.getData(url);
    }

    @Override
    public String getYear(String brandCode, String modelCode) throws CustomInterruptedException, CustomIOException {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + brandCode + "/modelos/" + modelCode + "/anos";
        return apiConsume.getData(url);
    }

    @Override
    public String getTableFipeData(String brandCode, String modelCode, String yearCode) throws CustomInterruptedException, CustomIOException {
        String url = baseUrl + vehicleType.getType() + "/marcas/" + brandCode + "/modelos/" + modelCode + "/anos/" + yearCode;
        return apiConsume.getData(url);
    }
}
