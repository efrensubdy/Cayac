package com.example.Models;

/**
 * Created by HSEQ on 24/10/2017.
 */
public class NoConformidad {
    public int id;
    public int idAuditoria;
    public int year;
    public int idContratista;
    public String noConformidad;
    public String mes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }

    public String getNoConformidad() {
        return noConformidad;
    }

    public void setNoConformidad(String noConformidad) {
        this.noConformidad = noConformidad;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
