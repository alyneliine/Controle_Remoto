package com.cilidro.gas;

public class CilindroGas {

  private int idCilindro;
  private String localizacao;
  private double capacidadeMaxima;
  private double capacidadeAtual;
  private double custoKg;
  private double custoAbastecimento;
  private String statusAbastecimento;

  public CilindroGas() {
		
	}

  public CilindroGas(int idCilindro, String localizacao, double capacidadeMaxima, double custoKg) {
    this.idCilindro = idCilindro;
    this.localizacao = localizacao;
    this.capacidadeMaxima = capacidadeMaxima;
    this.custoKg = custoKg;
    this.capacidadeAtual = capacidadeMaxima;
    this.statusAbastecimento = "Cheio";
  }

  public void abastecerCilindro(){
    double cargaMaxima = this.capacidadeMaxima - this.capacidadeAtual;
    if(this.capacidadeAtual >= (this.capacidadeMaxima / 2)){
      setCustoAbastecimento( cargaMaxima * (custoKg - 0.05));
      double custoUltimoAbastecimento = getCustoAbastecimento();
    }else{
      setCustoAbastecimento( cargaMaxima * custoKg);
    double custoUltimoAbastecimento = getCustoAbastecimento();
    }
    setCapacidadeAtual(this.capacidadeMaxima);
    definirStatusAbastecimento();
  }

  private void definirStatusAbastecimento(){
    double porcentagem = this.capacidadeAtual / this.capacidadeMaxima * 100;

    if(porcentagem >= 90){
      setStatusAbastecimento("Cheio");
    }
    else if(porcentagem >= 70 && porcentagem < 90 ){
      setStatusAbastecimento("Alto");
    }
    else if(porcentagem >= 30 && porcentagem < 70 ){
      setStatusAbastecimento("Médio");
    }
    else if (porcentagem > 0 && porcentagem < 30){
      setStatusAbastecimento("Baixo");
    }
    else if (porcentagem == 0){
      setStatusAbastecimento("Vazio");
    }
  }

  public boolean registrarConsumo(double qtdeKg){

    if(qtdeKg > this.capacidadeAtual){
      return false;
    }
    setCapacidadeAtual(this.capacidadeAtual - qtdeKg);
    definirStatusAbastecimento();
    return true;
  }

  public void esvaziarCilindro(){
    this.capacidadeAtual = 0;
    definirStatusAbastecimento();
  }


  public int getIdCilindro() {
    return idCilindro;
  }
  public String getLocalizacao() {
    return localizacao;
  }
  public double getCapacidadeMaxima() {
    return capacidadeMaxima;
  }
  public double getCapacidadeAtual() {
    return capacidadeAtual;
  }
  public double getCustoKg() {
    return custoKg;
  }
  public double getCustoAbastecimento() {
    return custoAbastecimento;
  }
  public String getStatusAbastecimento() {
    return statusAbastecimento;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public void setCapacidadeAtual(double capacidadeAtual) {
    this.capacidadeAtual = capacidadeAtual;
  }
  public void setCustoKg(double custoKg) {
    this.custoKg = custoKg;
  }
  public void setCustoAbastecimento(double custoAbastecimento) {
    this.custoAbastecimento = custoAbastecimento;
  }
  public void setStatusAbastecimento(String statusAbastecimento) {
    this.statusAbastecimento = statusAbastecimento;
  }
}
