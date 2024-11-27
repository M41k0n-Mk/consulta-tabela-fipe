package me.m41k0n;

import com.fasterxml.jackson.core.type.TypeReference;
import me.m41k0n.api.GenericVehicleAPI;
import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;
import me.m41k0n.enums.VehicleType;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;
import me.m41k0n.exception.CustomJsonProcessingException;
import me.m41k0n.model.FipeTableData;
import me.m41k0n.model.Model;
import me.m41k0n.model.Vehicle;
import me.m41k0n.model.Year;
import me.m41k0n.service.ModelMapper;
import me.m41k0n.utils.InputSanitizer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        while (true) {
            System.out.println("Escolha o tipo do seu veículo(carros, caminhões ou motos) ou digite sair para sair da aplicação:");
            Scanner leitura = new Scanner(System.in);
            String vehicleType = leitura.nextLine();

            if (vehicleType.equals("sair"))
                break;

            try {
                VehicleAPI strategy = new GenericVehicleAPI(VehicleType.fromString(InputSanitizer.sanitize(vehicleType)));
                VehicleContext context = new VehicleContext(strategy);

                List<Vehicle> vehiclesBrandList = modelMapper.jsonToModel(context.getBrandList(), new TypeReference<>() {
                });
                System.out.println(vehiclesBrandList);

                System.out.println("Escolha o código da marca do seu veículo:");
                String vehicleBrandCode = leitura.nextLine();

                Model vehicleModel = modelMapper.jsonToModel(context.getModel(vehicleBrandCode), new TypeReference<>() {
                });
                System.out.println(vehicleModel);

                System.out.println("Escolha o código do modelo do seu veículo:");
                String vehicleModelCode = leitura.nextLine();

                List<Year> vehicleYearList = modelMapper.jsonToModel(context.getYear(vehicleBrandCode, vehicleModelCode), new TypeReference<>() {
                });
                System.out.println(vehicleYearList);

                System.out.println("Escolha o código ano do modelo do seu veículo:");
                String vehicleYearCode = leitura.nextLine();

                FipeTableData fipeTableData = modelMapper.jsonToModel(context.getTableFipeData(vehicleBrandCode, vehicleModelCode, vehicleYearCode), new TypeReference<>() {
                });
                System.out.println(fipeTableData);
            } catch (CustomInterruptedException | CustomIOException | CustomJsonProcessingException
                     | IllegalArgumentException e) {
                System.out.println("A aplicação teve um erro inesperado " + e + " Tente buscar o tipo do seu veículo novamente");
            }
        }
    }
}