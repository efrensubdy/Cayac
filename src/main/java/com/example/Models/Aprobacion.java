package com.example.Models;

/**
 * Created by HSEQ on 13/09/2017.
 */
public class Aprobacion {
    public int id;
    public int idContratista;
    public int idContratante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }

    public int getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }
}
