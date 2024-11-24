package me.m41k0n.enums;

public enum VehicleType {
    CARS("carros"),
    MOTORCYCLES("motos"),
    TRUCKS("caminhoes");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static VehicleType fromString(String type) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.getType().equalsIgnoreCase(type)) {
                return vehicleType;
            }
        }
        throw new IllegalArgumentException("Tipo de veículo inválido: " + type);
    }
}
