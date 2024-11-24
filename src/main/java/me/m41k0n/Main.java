package me.m41k0n;

import me.m41k0n.api.GenericVehicleAPI;
import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;
import me.m41k0n.enums.VehicleType;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha o tipo do seu veículo(carros, caminhões ou motos) ou digite sair para sair da aplicação:");
            Scanner leitura = new Scanner(System.in);
            String vehicleType = leitura.nextLine();

            if (vehicleType.equals("sair"))
                break;

            VehicleAPI strategy = new GenericVehicleAPI(VehicleType.fromString(InputSanitizer.sanitize(vehicleType)));
            VehicleContext context = new VehicleContext(strategy);
            try {
                System.out.println(context.getData());
            } catch (CustomInterruptedException | CustomIOException e) {
                System.out.println("A aplicação teve um erro inesperado" + e + "Tente buscar o tipo do seu veículo novamente");
            }
        }
    }
}