import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import me.m41k0n.api.GenericVehicleAPI;
import me.m41k0n.enums.VehicleType;
import me.m41k0n.service.APIConsume;

@ExtendWith(MockitoExtension.class)
public class GenericVehicleAPITest {
    @Mock
    private APIConsume apiConsume;

    @Test
    public void itShouldBuildBrandListUrlAndReturnData() {
        when(apiConsume.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas")).thenReturn("marcas");

        GenericVehicleAPI api = new GenericVehicleAPI(VehicleType.CARS, apiConsume);

        assertEquals("marcas", api.getBrandList());
    }

    @Test
    public void itShouldUrlEncodeCodesWhenBuildingUrl() {
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        when(apiConsume.getData(urlCaptor.capture())).thenReturn("modelos");

        GenericVehicleAPI api = new GenericVehicleAPI(VehicleType.CARS, apiConsume);
        api.getModel("1 2");

        assertEquals("https://parallelum.com.br/fipe/api/v1/carros/marcas/1+2/modelos", urlCaptor.getValue());
    }

    @Test
    public void itShouldBuildTableFipeDataUrlWithAllCodes() {
        when(apiConsume.getData("https://parallelum.com.br/fipe/api/v1/motos/marcas/1/modelos/2/anos/3"))
                .thenReturn("dados-fipe");

        GenericVehicleAPI api = new GenericVehicleAPI(VehicleType.MOTORCYCLES, apiConsume);

        assertEquals("dados-fipe", api.getTableFipeData("1", "2", "3"));
        verify(apiConsume).getData("https://parallelum.com.br/fipe/api/v1/motos/marcas/1/modelos/2/anos/3");
    }
}
