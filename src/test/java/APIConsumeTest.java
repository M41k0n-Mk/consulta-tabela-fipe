import me.m41k0n.APIConsume;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class APIConsumeTest {
    @Mock
    private HttpClient mockHttpClient;

    @Mock
    private HttpResponse<String> mockHttpResponse;

    @InjectMocks
    private APIConsume apiConsume;

    @Test
    public void shouldMakeRequestAndReturnDataSuccessfully() throws IOException, InterruptedException {
        String expectedResponse = "response body";
        when(mockHttpResponse.body()).thenReturn(expectedResponse);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(mockHttpResponse);

        String actualResponse = apiConsume.getData("http://teste.com");

        assertEquals(expectedResponse, actualResponse);
        verify(mockHttpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void ItShouldThrowRuntimeExceptionWhenSendMethodThrowsIOException() throws IOException, InterruptedException {
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenThrow(new IOException());

        assertThrows(RuntimeException.class, () -> apiConsume.getData("http://teste.com"));
    }

    @Test
    public void ItShouldThrowRuntimeExceptionWhenSendMethodThrowsInterruptedException() throws IOException, InterruptedException {
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenThrow(new InterruptedException());

        assertThrows(RuntimeException.class, () -> apiConsume.getData("http://teste.com"));
    }
}