import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.type.TypeReference;

import me.m41k0n.model.Vehicle;
import me.m41k0n.service.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class ModelMapperTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void itShouldMapJsonToModelSuccessfully() {
        String json = "[{\"codigo\":1,\"nome\":\"Acura\"}]";

        List<Vehicle> vehicles = modelMapper.jsonToModel(json, new TypeReference<>() {
        });

        assertEquals(1, vehicles.size());
        assertEquals(1, vehicles.get(0).code());
        assertEquals("Acura", vehicles.get(0).name());
    }

    @Test
    public void itShouldThrowRuntimeExceptionWhenJsonIsInvalid() {
        String invalidJson = "{invalid-json}";

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> modelMapper.jsonToModel(invalidJson, new TypeReference<List<Vehicle>>() {
                }));

        assertEquals("Houve um problema inesperado no mapeamento json para model", exception.getMessage());
    }
}
