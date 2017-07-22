package com.example.Models;

/**
 * Created by HSEQ on 29/03/2017.
 */
public class Certificacion {
    public int id;
    public String numero ;
    public int numeroContratista;

    public Certificacion(int id, String numero, int numeroContratista) {
        this.id = id;
        this.numero = numero;
        this.numeroContratista = numeroContratista;
    }
    public Certificacion(){


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNumeroContratista() {
        return numeroContratista;
    }

    public void setNumeroContratista(int numeroContratista) {
        this.numeroContratista = numeroContratista;
    }
}
