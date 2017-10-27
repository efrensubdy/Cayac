package com.example.Models;

import java.io.File;
import java.sql.Date;

/**
 * Created by HSEQ on 26/10/2017.
 */
public class Accion {
    public int id;
    public File registro;
    public int  idContratista;
    public int idCausa;
    public Date date;
    public String registro2;
    public boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getRegistro() {
        return registro;
    }

    public void setRegistro(File registro) {
        this.registro = registro;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }

    public int getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(int idCausa) {
        this.idCausa = idCausa;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegistro2() {
        return registro2;
    }

    public void setRegistro2(String registro2) {
        this.registro2 = registro2;
    }
}
