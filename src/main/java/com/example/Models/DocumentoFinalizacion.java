package com.example.Models;

import java.io.File;

/**
 * Created by HSEQ on 05/07/2017.
 */
public class DocumentoFinalizacion {
    public File file;

    public int getIdFinalista() {
        return idFinalista;
    }

    public void setIdFinalista(int idFinalista) {
        this.idFinalista = idFinalista;
    }

    public int getIdRequiPrevio() {
        return idRequiPrevio;
    }

    public void setIdRequiPrevio(int idRequiPrevio) {
        this.idRequiPrevio = idRequiPrevio;
    }
    public int idContratista;

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }

    public int idFinalista;
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    public String contenido;
    public int id;
    public int idRequiPrevio;
    public String tipo;
    public String estado;
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContenido() {
        return contenido;
    }

    public DocumentoFinalizacion(int idFinalista, File file, int idRequiPrevio,int idContratista) {
        this.idFinalista=idFinalista;
        this.file = file;
        this.idRequiPrevio = idRequiPrevio;
        this.idContratista=idContratista;
    }

    public DocumentoFinalizacion(){


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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
