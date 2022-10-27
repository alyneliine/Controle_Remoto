package com.cilidro.gas;

import java.util.Scanner;

public class CilindroApp {
    static CilindroGas cilindroGas = new CilindroGas();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n*** Seletor de Opções ***");
            System.out.println();
            System.out.println("1 - Cadastrar Cilindro");
            System.out.println("2 - Registrar Consumo");
            System.out.println("3 - Abastecer Cilindro");
            System.out.println("4 - Esvaziar Cilindro");
            System.out.println("0 - Finalizar");

            System.out.print("\nOpção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    casdastrarCilindro();
                    break;
                case 2:
                    registrarConsumo();
                    break;
                case 3:
                    abastecerCilindro();
                    break;
                case 4:
                    esvaziarCilindro();
                    break;
                case 0:
                    System.out.println("\n--- PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("\nOpção incorreta");

            }

        } while (opcao != 0);

    }
    public static void casdastrarCilindro() {

        System.out.println();
        System.out.println("****** Cadastrar Cilindro ******");

        int idCilindro;

        do {
            System.out.print("Informe o ID do medidor: ");
            idCilindro = scan.nextInt();
            if (idCilindro <= 0) {
                System.out.println("O ID do ciliendro deve ser um número positivo");
                continue;
            }
            break;

        } while (true);

        String localizacao;

        do {
            System.out.print("Informe a localização do cilindro: ");
            localizacao = scan.next();
            if (localizacao.isEmpty()) {
                System.out.println("A localização do cilindro deve conter dados");
                continue;
            }
            break;

        } while (true);

        double capacidadeMaxima = 0;

        do {
            System.out.print("Informe a capacidade máxima do cilindro: ");
            capacidadeMaxima = scan.nextInt();
            if (capacidadeMaxima <= 0) {
                System.out.println("O capacidade máxima do cilindro deve ser um número positivo");
                continue;
            }
            break;

        } while (true);

        double custoKg = 0;

        do {
            System.out.print("Informe o custokg do cilindro: ");
            custoKg = scan.nextInt();
            if (custoKg <= 0) {
                System.out.println("O custokg do cilindro deve ser um número positivo");
                continue;
            }
            break;

        } while (true);

        cilindroGas = new CilindroGas(idCilindro, localizacao, capacidadeMaxima, custoKg);
        mostrarDados();
    }

    private static void mostrarDados() {
        System.out.println();
        System.out.println("****** Cilindro cadastrado ******");
        System.out.println("O ID do cilindro é : " + cilindroGas.getIdCilindro());
        System.out.println("A localização é : " + cilindroGas.getLocalizacao());
        System.out.println("A capacidade máxima é: " + cilindroGas.getCapacidadeMaxima());
        System.out.println("A capacidade Atual é : " + cilindroGas.getCapacidadeAtual());
        System.out.println("O custo do Kg : " + cilindroGas.getCustoKg());
        System.out.println("O custo do abastecimento : " + cilindroGas.getCustoAbastecimento());
        System.out.println("O status do abastecimento é : " + cilindroGas.getStatusAbastecimento());
        System.out.println();
    }

    public static void registrarConsumo() {

        System.out.println();
        System.out.println("****** Registrar Consumo ******");

        double consumo;

        for (int i = 0; i < 3; i++) {
        System.out.println("Informe o valor do consumo");
        consumo = scan.nextDouble();
        if(consumo < cilindroGas.getCapacidadeAtual()){
            cilindroGas.setCapacidadeAtual(cilindroGas.getCapacidadeAtual() - consumo);
            mostrarDados();
        } else{
            System.out.println();
            System.out.println("Consumo maior que a capacidade atual do cilindro");
            i--;
        }  
        }

    }

    public static void abastecerCilindro(){
        System.out.println();
        System.out.println("****** Abastecer Cilindro ******");
        System.out.println();
        cilindroGas.abastecerCilindro();
        mostrarDados();
        
    }

    public static void esvaziarCilindro(){
        System.out.println();
        System.out.println("****** Esvaziar Cilindro ******");
        System.out.println();
        cilindroGas.esvaziarCilindro();
        mostrarDados();

    }

}
