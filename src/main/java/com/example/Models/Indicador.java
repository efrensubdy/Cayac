package com.example.Models;

/**
 * Created by HSEQ on 03/10/2017.
 */
public class Indicador {
public int id;
public String nombreContra;
public String mes;
public String responsable;
public String departamento;
public String actividad;
public Float severidad;
public Float frecuencia;
public Float mortalidad;
public Float prevalencia;
public Float incidencia;
public Float ausentismo;
public int idContratista;
public int idContratante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreContra() {
        return nombreContra;
    }

    public void setNombreContra(String nombreContra) {
        this.nombreContra = nombreContra;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Float getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Float severidad) {
        this.severidad = severidad;
    }

    public Float getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Float frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Float getMortalidad() {
        return mortalidad;
    }

    public void setMortalidad(Float mortalidad) {
        this.mortalidad = mortalidad;
    }

    public Float getPrevalencia() {
        return prevalencia;
    }

    public void setPrevalencia(Float prevalencia) {
        this.prevalencia = prevalencia;
    }

    public Float getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Float incidencia) {
        this.incidencia = incidencia;
    }

    public Float getAusentismo() {
        return ausentismo;
    }

    public void setAusentismo(Float ausentismo) {
        this.ausentismo = ausentismo;
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
