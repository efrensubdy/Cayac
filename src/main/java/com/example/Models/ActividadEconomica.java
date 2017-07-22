package com.example.Models;

/**
 * Created by HSEQ on 29/03/2017.
 */
public class ActividadEconomica {
    public int codigoCUU;
    public String descripcion;
    public int nivelDeRiesgo;

    public ActividadEconomica(int codigoCUU, String descripcion, int nivelDeRiesgo) {
        this.codigoCUU = codigoCUU;
        this.descripcion = descripcion;
        this.nivelDeRiesgo = nivelDeRiesgo;
    }
    public ActividadEconomica(){

    }

    public int getCodigoCUU() {
        return codigoCUU;
    }

    public void setCodigoCUU(int codigoCUU) {
        this.codigoCUU = codigoCUU;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivelDeRiesgo() {
        return nivelDeRiesgo;
    }

    public void setNivelDeRiesgo(int nivelDeRiesgo) {
        this.nivelDeRiesgo = nivelDeRiesgo;
    }
}
