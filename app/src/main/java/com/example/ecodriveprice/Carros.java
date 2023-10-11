package com.example.ecodriveprice;


import androidx.annotation.NonNull;

public class Carros {

    private String  nomeCarro;
    private double cidadeA;
    private double cidadeG;
    private double estradaA;
    private double estradaG;



    public Carros(String nomeCarro, double cidadeA, double cidadeG, double estradaA, double estradaG) {
        this.nomeCarro = nomeCarro;
        this.cidadeA = cidadeA;
        this.cidadeG = cidadeG;
        this.estradaA = estradaA;
        this.estradaG = estradaG;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public double getCidadeA() {
        return cidadeA;
    }

    public void setCidadeA(double cidadeA) {
        this.cidadeA = cidadeA;
    }

    public double getCidadeG() {
        return cidadeG;
    }

    public void setCidadeG(double cidadeG) {
        this.cidadeG = cidadeG;
    }

    public double getEstradaA() {
        return estradaA;
    }

    public void setEstradaA(double estradaA) {
        this.estradaA = estradaA;
    }

    public double getEstradaG() {
        return estradaG;
    }

    public void setEstradaG(double estradaG) {
        this.estradaG = estradaG;
    }

    @NonNull
    @Override
    public String toString() {
        return nomeCarro;
    }
}
