package com.example.Models;

import java.sql.Date;

/**
 * Created by HSEQ on 26/05/2017.
 */
public class FechaLimite {
    public int id;
    public Date fechaInicio;
    public Date fechaFin;
    public String tiempoRestante;
    public  int idContratista;
    public int idContrato;
    public boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }

    public int idCategoria;
    public boolean flag;
    public int idContratante;

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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

    public FechaLimite(){


    }

    public FechaLimite( int idContratista,Date fechaFin) {
        this.idContratista = idContratista;
        this.fechaFin = fechaFin;
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

    public String getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(String tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }
}
