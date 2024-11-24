package me.m41k0n;

import com.fasterxml.jackson.core.type.TypeReference;
import me.m41k0n.api.GenericVehicleAPI;
import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;
import me.m41k0n.enums.VehicleType;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;
import me.m41k0n.exception.CustomJsonProcessingException;
import me.m41k0n.model.Vehicle;
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

                List<Vehicle> vehicles = modelMapper.jsonToModel(context.getData(), new TypeReference<>() {});
                System.out.println(vehicles);
            } catch (CustomInterruptedException | CustomIOException | CustomJsonProcessingException
                     | IllegalArgumentException e) {
                System.out.println("A aplicação teve um erro inesperado " + e + " Tente buscar o tipo do seu veículo novamente");
            }
        }
    }
}