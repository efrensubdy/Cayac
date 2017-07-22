package com.example.Models;

/**
 * Created by HSEQ on 10/04/2017.
 */
public class Requisito {
    public String requisito;
    public int numero;

    public Requisito(String requisito, int numero) {
        this.requisito = requisito;
        this.numero = numero;
    }
    public Requisito(){}

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
