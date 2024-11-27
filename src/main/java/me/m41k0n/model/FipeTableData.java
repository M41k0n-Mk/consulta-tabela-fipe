package me.m41k0n.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record FipeTableData(@JsonAlias("TipoVeiculo") Integer vehicleType,
                            @JsonAlias("Valor") String value,
                            @JsonAlias("Marca") String brand,
                            @JsonAlias("Modelo") String model,
                            @JsonAlias("AnoModelo") Integer modelYear,
                            @JsonAlias("Combustivel") String fuel,
                            @JsonAlias("CodigoFipe") String fipeCode,
                            @JsonAlias("MesReferencia") String referenceMonth,
                            @JsonAlias("SiglaCombustivel") String fuelAcronym) {
}