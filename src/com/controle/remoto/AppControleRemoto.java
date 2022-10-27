package com.controle.remoto;

import java.util.Scanner;

public class AppControleRemoto {

  static ControleRemoto controleRemoto = new ControleRemoto();
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    int opcao;

    do {
      System.out.println("\n*** Seletor de Opções ***");
      System.out.println();
      System.out.println("1 - Cadastrar Controle Remoto");
      System.out.println("2 - Ligar Condicionador de Ar");
      System.out.println("3 - Aumentar Temperatura");
      System.out.println("4 - Ajustar Velocidade");
      System.out.println("5 - Diminuir Temperatura");
      System.out.println("6 - Desligar Condicionador de Ar");
      System.out.println("7 - Mostar Temperatura Atual");
      System.out.println("0 - Finalizar");

      System.out.print("\nOpção: ");
      opcao = scan.nextInt();

      switch (opcao) {
        case 1:
          casdastrarControleRemoto();
          break;
        case 2:
          ligarCondicionamento();
          break;
        case 3:
          aumentarTemparatura();
          break;
        case 4:
          ajustarVelocidade();
          break;
        case 5:
          diminuirTemperatura();
          break;
        case 6:
          desligarTemperatura();
          break;
        case 7:
          mostrarTemperaturaAtual();
          break;
        case 0:
          System.out.println("\n--- PROGRAMA FINALIZADO");
          break;
        default:
          System.out.println("\nOpção incorreta");

      }

    } while (opcao != 0);

  }

  private static void mostrarTemperaturaAtual() {

    if (controleRemoto.getLigado() == true) {
      int temperatura = controleRemoto.getTemperaturaAtual();
      System.out.println("Equipamento ligado e a temperatura é: " + temperatura);

    } else {
      System.out.println("Equipamento desligado");
    }
  }

  public static void desligarTemperatura() {
    controleRemoto.ligarDesligar();
  }

  public static void diminuirTemperatura() {
    int temperatura;

    do {
      System.out.println();
      System.out.println("****** Diminuir temperatura ******");
      temperatura = controleRemoto.getTemperaturaAtual();
      if (temperatura <= controleRemoto.getTemperaturaMinima()) {
        System.out.println("Condicionador de ar já está na temperatura mínima.");
        break;
      }else{
        controleRemoto.diminuirTemperatura();
        System.out.println("A temperatura atual é: " + temperatura + "°C");

      }

    } while (true);

  }

  public static void casdastrarControleRemoto() {

    System.out.println();
    System.out.println("****** Cadastrar Controle Remoto ******");

    int idControle;

    do {
      System.out.print("Informe o ID do controle: ");
      idControle = scan.nextInt();
      if (idControle <= 0) {
        System.out.println("O ID do controle deve ser um número positivo");
        continue;
      }
      break;

    } while (true);

    String modelo;

    do {
      System.out.print("Informe o modelo do controle remoto: ");
      modelo = scan.next();
      if (modelo.isEmpty()) {
        System.out.println("O modelo do controle deve conter dados");
        continue;
      }
      break;

    } while (true);

    int temperaturaMaxima = 0;

    do {
      System.out.print("Informe a temperatura máxima do controle: ");
      temperaturaMaxima = scan.nextInt();
      if (temperaturaMaxima <= 0) {
        System.out.println("A temperatura máxima deve ser um número positivo");
        continue;
      }
      break;

    } while (true);

    int temperaturaMinima = 0;

    do {
      System.out.print("Informe a temperatura mínima: ");
      temperaturaMinima = scan.nextInt();
      if (temperaturaMinima <= 0) {
        System.out.println("A temperatura mínima deve ser um número positivo");
        continue;
      }
      break;

    } while (true);

    controleRemoto = new ControleRemoto(idControle, modelo, temperaturaMinima, temperaturaMaxima);
    mostrarDados();

  }

  private static void mostrarDados() {
    System.out.println();
    System.out.println("****** Controle Remoto cadastrado ******");
    System.out.println("O ID do controle é : " + controleRemoto.getIdControle());
    System.out.println("O modelo do controle é : " + controleRemoto.getModelo());
    System.out.println("A temperatura máxima é: " + controleRemoto.getTemperaturaMaxima());
    System.out.println("A temperatura mínima é : " + controleRemoto.getTemperaturaMinima());
    System.out.println("A temperatura Atual : " + controleRemoto.getTemperaturaAtual());
    System.out.println("A velocidade é : " + controleRemoto.getVelocidade());
    System.out.println("O controle está : " + (controleRemoto.getLigado() == true ? "Ligado":"Desligado"));
    System.out.println();
  }

  public static void ligarCondicionamento() {
    controleRemoto.ligarDesligar();

  }

  public static void aumentarTemparatura() {

    int temperaturaMaxima;

    do {
      System.out.println();
      System.out.println("****** Aumentar temperatura ******");
      temperaturaMaxima = controleRemoto.getTemperaturaAtual();
      if (temperaturaMaxima >= controleRemoto.getTemperaturaMaxima()) {
        System.out.println("Condicionador de ar já está na temperatura máxima.");
        break;
      }
      controleRemoto.aumentarTemparatura();
      System.out.println("A temperatura atual é: " + temperaturaMaxima + "°C");

    } while (true);

  }

  public static void ajustarVelocidade() {

    System.out.println();
    System.out.println("****** Ajustar Velocidade ******");

    for (int i = 0; i < 5; i++) {
      controleRemoto.ajustarVelocidade();
      int velocidade = controleRemoto.getVelocidade();
      System.out.println("A velocidade atual é: " + velocidade);
    }

  }

}
