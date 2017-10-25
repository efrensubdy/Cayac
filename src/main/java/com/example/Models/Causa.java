package com.example.Models;

/**
 * Created by HSEQ on 25/10/2017.
 */
public class Causa {
    public int id;
    public int idNoConformidad;
    public int idContratista;
    public String causa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNoConformidad() {
        return idNoConformidad;
    }

    public void setIdNoConformidad(int idNoConformidad) {
        this.idNoConformidad = idNoConformidad;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
}
