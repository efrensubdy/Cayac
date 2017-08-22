package com.example.Models;

import java.io.File;
import java.sql.Date;

/**
 * Created by HSEQ on 17/08/2017.
 */
public class Matriz {
    public String nombre;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public File file;
    public int idRequisito;
    public int idFinalista;
    public String tipo;
    public String contenido;
    public String estado;
    public int contratista;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContratista() {
        return contratista;
    }

    public void setContratista(int contratista) {
        this.contratista = contratista;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
