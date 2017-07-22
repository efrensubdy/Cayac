package com.example.Models;

import java.sql.Date;

/**
 * Created by HSEQ on 13/06/2017.
 */
public class Contrato {
    public int idContrato;
    public String nombreContrato;
    public Date fechaInicio;
    public Date fechaFin;
    public int idContratante;
    public  String tipoContrato;

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Contrato(){

    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getNombreContrato() {
        return nombreContrato;
    }

    public void setNombreContrato(String nombreContrato) {
        this.nombreContrato = nombreContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }
}
