package br.com.samanta.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        // 1. Cria o Cliente (o navegador)
        HttpClient client = HttpClient.newHttpClient();

        // 2. Cria a Requisição (o envelope com o endereço)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;
        try {
            // 3. Envia a requisição e guarda a resposta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // Se der erro (sem internet, endereço errado), lança uma exceção
            throw new RuntimeException("Não consegui obter o endereço. Erro: " + e.getMessage());
        }

        // 4. Retorna apenas o "corpo" da resposta (o texto JSON)
        return response.body();
    }
}