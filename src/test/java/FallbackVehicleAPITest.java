import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import me.m41k0n.api.FallbackVehicleAPI;
import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;

@ExtendWith(MockitoExtension.class)
public class FallbackVehicleAPITest {
    @Mock
    private VehicleAPI primary;

    @Mock
    private VehicleAPI secondary;

    @Test
    public void itShouldUsePrimaryResultWhenPrimarySucceeds() {
        when(primary.getBrandList()).thenReturn("dados-da-api-principal");

        VehicleAPI fallbackApi = new FallbackVehicleAPI(primary, secondary);
        VehicleContext context = new VehicleContext(fallbackApi);

        String result = context.getBrandList();

        assertEquals("dados-da-api-principal", result);
        verify(primary, times(1)).getBrandList();
        verify(secondary, never()).getBrandList();
    }

    @Test
    public void itShouldFallBackToSecondaryWhenPrimaryFails() {
        when(primary.getBrandList()).thenThrow(new RuntimeException("API principal fora do ar"));
        when(secondary.getBrandList()).thenReturn("dados-da-api-secundaria");

        VehicleAPI fallbackApi = new FallbackVehicleAPI(primary, secondary);
        VehicleContext context = new VehicleContext(fallbackApi);

        String result = context.getBrandList();

        assertEquals("dados-da-api-secundaria", result);
        verify(primary, times(1)).getBrandList();
        verify(secondary, times(1)).getBrandList();
    }
}
