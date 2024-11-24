import me.m41k0n.service.APIConsume;
import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;
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
    public void shouldMakeRequestAndReturnDataSuccessfully() throws IOException, InterruptedException, CustomInterruptedException, CustomIOException {
        String expectedResponse = "response body";
        when(mockHttpResponse.body()).thenReturn(expectedResponse);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(mockHttpResponse);

        String actualResponse = apiConsume.getData("http://teste.com");

        assertEquals(expectedResponse, actualResponse);
        verify(mockHttpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void ItShouldThrowCustomIOExceptionWhenSendMethodThrowsIOException() throws IOException, InterruptedException {
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenThrow(new IOException());

        CustomIOException e = assertThrows(CustomIOException.class, () -> apiConsume.getData("http://teste.com"));
        assertEquals("A requisição HTTP falhou", e.getMessage());
    }

    @Test
    public void ItShouldThrowCustomInterruptedExceptionWhenSendMethodThrowsInterruptedException() throws IOException, InterruptedException {
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenThrow(new InterruptedException());

        CustomInterruptedException e = assertThrows(CustomInterruptedException.class, () -> apiConsume.getData("http://teste.com"));
        assertEquals("A thread foi interrompida durante a request HTTP", e.getMessage());
    }
}