package me.m41k0n.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelMapper {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T jsonToModel(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Houve um problema inesperado no mapeamento json para model", e);
        }
    }
}