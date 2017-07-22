package com.example.Models;

import java.sql.Date;

/**
 * Created by HSEQ on 07/06/2017.
 */
public class Finalista {
    public int idFinalista;
    public int idContratista;
    public int idContrato;

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Finalista(){


    }
    public Finalista(int idFinalista, int idContratista) {
        this.idFinalista = idFinalista;
        this.idContratista = idContratista;
    }

    public int getIdFinalista() {
        return idFinalista;
    }

    public void setIdFinalista(int idFinalista) {
        this.idFinalista = idFinalista;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }
}
