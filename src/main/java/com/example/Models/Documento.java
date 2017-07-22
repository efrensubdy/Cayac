package com.example.Models;

import java.io.File;
import java.io.Serializable;

/**
 * Created by User on 15/05/2017.
 */
public class Documento implements Serializable {
    public int idContratista;
    public File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }

    public String contenido;
    public int id;
    public int idRequisitoSugerido;
    public String tipo;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String estado;
    public String getContenido() {
        return contenido;
    }

    public Documento(int idContratista, File file, int idRequisitoSugerido) {
        this.idContratista = idContratista;
        this.file = file;
        this.idRequisitoSugerido = idRequisitoSugerido;
    }

    public Documento(){


    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRequisitoSugerido() {
        return idRequisitoSugerido;
    }

    public void setIdRequisitoSugerido(int idRequisitoSugerido) {
        this.idRequisitoSugerido = idRequisitoSugerido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

