package com.controle.remoto;

public class ControleRemoto {

  private int idControle;
  private String modelo;
  private int temperaturaMinima;
  private int temperaturaMaxima;
  private int temperaturaAtual;
  private int velocidade;
  private boolean ligado;

  public ControleRemoto() {
  }

  public ControleRemoto(int idControle, String modelo, int temperaturaMinima, int temperaturaMaxima) {
    this.idControle = idControle;
    this.modelo = modelo;
    this.temperaturaMinima = temperaturaMinima;
    this.temperaturaMaxima = temperaturaMaxima;
    this.temperaturaAtual = 0;
    this.velocidade = 1;
    this.ligado = false;
  }

  public boolean ligarDesligar() {

    if (this.ligado == false) {
      this.temperaturaAtual = (this.temperaturaMinima + this.temperaturaMaxima) / 2;
      this.velocidade = 1;
      this.ligado = true;
      return true;
    }
    this.temperaturaAtual = 0;
    this.ligado = false;
    return false;
  }

  public boolean diminuirTemperatura() {

    if (this.temperaturaAtual > temperaturaMinima) {
      temperaturaAtual--;
      return true;
    }
    return false;
  }

  public boolean aumentarTemparatura() {
    if (this.temperaturaAtual < this.temperaturaMaxima) {
      temperaturaAtual++;
      return true;
    }
    return false;

  }

  public void ajustarVelocidade() {
    this.velocidade++;
    if(this.velocidade > 3){
      this.velocidade = 1;
    }
  }

  public int getIdControle() {
    return idControle;
  }

  public String getModelo() {
    return modelo;
  }

  public int getTemperaturaMinima() {
    return temperaturaMinima;
  }

  public int getTemperaturaMaxima() {
    return temperaturaMaxima;
  }

  public int getTemperaturaAtual() {
    return temperaturaAtual;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public boolean getLigado() {
    return ligado;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setTemperaturaMinima(int temperaturaMinima) {
    this.temperaturaMinima = temperaturaMinima;
  }

  public void setTemperaturaMaxima(int temperaturaMaxima) {
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public void setTemperaturaAtual(int temperaturaAtual) {
    this.temperaturaAtual = temperaturaAtual;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

  public void setLigado(boolean ligado) {
    this.ligado = ligado;
  }

}
