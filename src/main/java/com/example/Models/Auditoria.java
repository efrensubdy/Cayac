package com.example.Models;

import java.io.File;
import java.util.List;

/**
 * Created by HSEQ on 23/10/2017.
 */
public class Auditoria {
    public int id;
    public int idContratista;
    public int idContratante;
    public List<File> archivos;
    public String auditoria;
    public String mes;
    public int year;
    public String nombreEmpresa;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String tipo;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File file;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }

    public List<File> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<File> archivos) {
        this.archivos = archivos;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }
}
