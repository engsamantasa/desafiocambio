package br.com.samanta.ui;

import br.com.samanta.services.ConverteMoeda;
import java.util.Scanner;

public class Menu {

    private Scanner leitura = new Scanner(System.in);
    private ConverteMoeda conversor = new ConverteMoeda();

    public void exibirMenu() {
        int opcao = 0;

        System.out.println("*************************************************");
        System.out.println("Bem-vindo(a) ao Conversor de Moedas da Samanta!");
        System.out.println("*************************************************");

        while (opcao != 7) {
            System.out.println("\nEscolha uma opção de conversão:");
            System.out.println("1) Dólar (USD) => Real Brasileiro (BRL)");
            System.out.println("2) Real Brasileiro (BRL) => Dólar (USD)");
            System.out.println("3) Dólar (USD) => Euro (EUR)");
            System.out.println("4) Euro (EUR) => Dólar (USD)");
            System.out.println("5) Dólar (USD) => Peso Argentino (ARS)");
            System.out.println("6) Peso Argentino (ARS) => Dólar (USD)");
            System.out.println("7) Sair");
            System.out.print("Sua escolha: ");

            try {
                opcao = leitura.nextInt();

                if (opcao == 7) {
                    System.out.println("Finalizando o programa... Até mais!");
                    break;
                }

                if (opcao < 1 || opcao > 7) {
                    System.out.println("Opção inválida! Tente novamente.");
                    continue; // Volta para o início do laço
                }

                // Lógica de conversão
                converterMoedaPelaOpcao(opcao);

            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite apenas números.");
                leitura.nextLine(); // Limpa o buffer do scanner para não travar
            }
        }
    }

    private void converterMoedaPelaOpcao(int opcao) {
        System.out.print("Digite o valor que deseja converter: ");
        double valor = leitura.nextDouble();

        String origem = "";
        String destino = "";

        switch (opcao) {
            case 1: origem = "USD"; destino = "BRL"; break;
            case 2: origem = "BRL"; destino = "USD"; break;
            case 3: origem = "USD"; destino = "EUR"; break;
            case 4: origem = "EUR"; destino = "USD"; break;
            case 5: origem = "USD"; destino = "ARS"; break;
            case 6: origem = "ARS"; destino = "USD"; break;
        }

        double resultado = conversor.converter(origem, destino, valor);

        System.out.printf("O valor de %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]\n",
                valor, origem, resultado, destino);
    }
}