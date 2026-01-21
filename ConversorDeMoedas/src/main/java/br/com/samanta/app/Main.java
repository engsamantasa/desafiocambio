package br.com.samanta.app;

import br.com.samanta.ui.Menu;

public class Main {
    public static void main(String[] args) {
        // A Main agora só tem uma função: Iniciar o Menu
        Menu menuPrincipal = new Menu();
        menuPrincipal.exibirMenu();
    }
}