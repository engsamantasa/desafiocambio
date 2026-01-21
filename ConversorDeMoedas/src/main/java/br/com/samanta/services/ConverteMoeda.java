package br.com.samanta.services;

import br.com.samanta.models.Moeda;
import com.google.gson.Gson;

public class ConverteMoeda {

    // Substitua pela sua chave REAL
    private final String API_KEY = "74c85a272c2f373d6b0bd4e8";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private ConsumoApi consumo = new ConsumoApi();
    private Gson gson = new Gson();

    // Este metodo faz TUDO: busca a taxa e já devolve o valor convertido
    public double converter(String moedaOrigem, String moedaDestino, double valorParaConverter) {

        // 1. Montagem da URL (Aqui acontece o "Filtro" que você perguntou)
        // Exemplo: .../pair/USD/BRL
        String enderecoFinal = BASE_URL + moedaOrigem + "/" + moedaDestino;

        // 2. Busca o JSON na internet (Usando a classe que criamos antes)
        String json = consumo.obterDados(enderecoFinal);

        // 3. Transformação (Deserialização): JSON -> Record Moeda
        // O Gson lê o texto e preenche o objeto automaticamente
        Moeda moeda = gson.fromJson(json, Moeda.class);

        // 4. Cálculo da Conversão
        return valorParaConverter * moeda.conversion_rate();
    }
}
