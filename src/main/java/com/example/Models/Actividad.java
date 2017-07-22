package com.example.Models;

import java.sql.Date;

/**
 * Created by HSEQ on 12/07/2017.
 */
public class Actividad {
public int id;
public int idRequisito;
public int idFinalista;
public Date fechaEjecucion;
public Date fechaEjecutada;
public String nombre;
public String responsable;
public String estado;
public String contenido;
public String tipo;
public boolean motrar;

    public String getComparacion() {
        return comparacion;
    }

    public void setComparacion(String comparacion) {
        this.comparacion = comparacion;
    }

    public String comparacion;

    public boolean isMotrar() {
        return motrar;
    }

    public void setMotrar(boolean motrar) {
        this.motrar = motrar;
    }

    public Actividad(){


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(int idRequisito) {
        this.idRequisito = idRequisito;
    }

    public int getIdFinalista() {
        return idFinalista;
    }

    public void setIdFinalista(int idFinalista) {
        this.idFinalista = idFinalista;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Date getFechaEjecutada() {
        return fechaEjecutada;
    }

    public void setFechaEjecutada(Date fechaEjecutada) {
        this.fechaEjecutada = fechaEjecutada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
