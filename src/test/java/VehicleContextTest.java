import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import me.m41k0n.api.VehicleAPI;
import me.m41k0n.context.VehicleContext;

@ExtendWith(MockitoExtension.class)
public class VehicleContextTest {
    @Mock
    private VehicleAPI strategy;

    @Test
    public void itShouldDelegateAllCallsToTheConfiguredStrategy() {
        when(strategy.getBrandList()).thenReturn("marcas");
        when(strategy.getModel("1")).thenReturn("modelos");
        when(strategy.getYear("1", "2")).thenReturn("anos");
        when(strategy.getTableFipeData("1", "2", "3")).thenReturn("dados-fipe");

        VehicleContext context = new VehicleContext(strategy);

        assertEquals("marcas", context.getBrandList());
        assertEquals("modelos", context.getModel("1"));
        assertEquals("anos", context.getYear("1", "2"));
        assertEquals("dados-fipe", context.getTableFipeData("1", "2", "3"));
    }
}
