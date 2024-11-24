package me.m41k0n;

import me.m41k0n.exception.CustomIOException;
import me.m41k0n.exception.CustomInterruptedException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsume {
    private final HttpClient client;

    public APIConsume(HttpClient client) {
        this.client = client;
    }

    public String getData(String url) throws CustomIOException, CustomInterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new CustomIOException("A requisição HTTP falhou", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CustomInterruptedException("A thread foi interrompida durante a request HTTP", e);
        }

        return response.body();
    }
}
