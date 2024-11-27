import me.m41k0n.enums.VehicleType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class VehicleTypeTest {
    @Test
    public void testIfReturnVehicleTypeWithSuccess() {
        assertEquals(VehicleType.CARS, VehicleType.fromString("carros"));
        assertEquals(VehicleType.MOTORCYCLES, VehicleType.fromString("motos"));
        assertEquals(VehicleType.TRUCKS, VehicleType.fromString("caminhoes"));
    }

    @Test
    public void testIfThrowsExceptionWhenVehicleTypeNotExists() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> VehicleType.fromString("bicicletas"));

        assertEquals("Tipo de veículo inválido: bicicletas", exception.getMessage());
    }
}
