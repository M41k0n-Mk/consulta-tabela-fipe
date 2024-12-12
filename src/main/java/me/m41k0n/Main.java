package me.m41k0n;

import com.fasterxml.jackson.core.type.TypeReference;
import me.m41k0n.api.GenericVehicleAPI;
import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;
import me.m41k0n.enums.VehicleType;
import me.m41k0n.model.Info;
import me.m41k0n.model.Model;
import me.m41k0n.model.Vehicle;
import me.m41k0n.model.Year;
import me.m41k0n.service.ModelMapper;
import me.m41k0n.utils.InputSanitizer;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        while (true) {
            System.out.println("Escolha o tipo do seu veículo(carros, caminhões ou motos) ou digite sair para sair da aplicação:");
            var leitura = new Scanner(System.in);
            var vehicleType = leitura.nextLine();

            if (vehicleType.equals("sair"))
                break;

            try {
                VehicleAPI strategy = new GenericVehicleAPI(VehicleType.fromString(InputSanitizer.sanitize(vehicleType)));
                var context = new VehicleContext(strategy);

                List<Vehicle> vehiclesBrandList = modelMapper.jsonToModel(context.getBrandList(), new TypeReference<>() {
                });
                vehiclesBrandList.stream().sorted(Comparator.comparing(Vehicle::code)).forEach(System.out::println);

                System.out.println("Escolha o código da marca do seu veículo:");
                var vehicleBrandCode = leitura.nextLine();

                Model vehicleModel = modelMapper.jsonToModel(context.getModel(vehicleBrandCode), new TypeReference<>() {
                });
                vehicleModel.models().stream().sorted(Comparator.comparing(Info::code)).forEach(System.out::println);

                System.out.println("Digite um trecho do nome do veículo a ser buscado");
                var vehicleName = leitura.nextLine();

                List<Info> filteredModels = vehicleModel.models().stream()
                        .filter(m -> m.name().toLowerCase().contains(vehicleName.toLowerCase()))
                        .toList();

                System.out.println("Modelos filtrados");
                filteredModels.forEach(System.out::println);

                System.out.println("Escolha o código do modelo do seu veículo:");
                var vehicleModelCode = leitura.nextLine();

                List<Year> vehicleYearList = modelMapper.jsonToModel(context.getYear(vehicleBrandCode, vehicleModelCode), new TypeReference<>() {
                });

                vehicleYearList.stream()
                        .map(Year::code)
                        .map(code -> modelMapper.jsonToModel(context.getTableFipeData(vehicleBrandCode, vehicleModelCode, code),
                                new TypeReference<>() {
                                })).forEach(System.out::println);
            } catch (RuntimeException e) {
                System.out.println("A aplicação teve um erro inesperado " + e + " Tente buscar o tipo do seu veículo novamente");
            }
        }
    }
}