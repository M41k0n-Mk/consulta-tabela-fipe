package me.m41k0n;

import me.m41k0n.api.GenericVehicleAPI;
import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;
import me.m41k0n.enums.VehicleType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Escolha o tipo do seu veículo(carros, caminhões ou motos):");
        Scanner leitura = new Scanner(System.in);
        String vehicleType = leitura.nextLine();

        VehicleAPI strategy = new GenericVehicleAPI(VehicleType.fromString(vehicleType));
        VehicleContext context = new VehicleContext(strategy);
        System.out.println(context.getData());
    }
}