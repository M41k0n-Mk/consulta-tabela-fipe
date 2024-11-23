package me.m41k0n;

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

    public String getData(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
