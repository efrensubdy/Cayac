package com.example.Models;

import java.io.File;
import java.sql.Date;
import java.util.List;

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
    public String contenido;
    public Date fechaCreacion;
    public Date fechaActualizada;
    public String tipo;
    public String estado;
    public String tipo2;
    public String tipo3;
    public File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getTipo3() {
        return tipo3;
    }

    public void setTipo3(String tipo3) {
        this.tipo3 = tipo3;
    }

    public Date getFecheDeInicioActividades() {
        return fecheDeInicioActividades;
    }

    public void setFecheDeInicioActividades(Date fecheDeInicioActividades) {
        this.fecheDeInicioActividades = fecheDeInicioActividades;
    }

    public int getIdFinalista() {
        return idFinalista;
    }

    public void setIdFinalista(int idFinalista) {
        this.idFinalista = idFinalista;
    }

    public String nombredeDocumento;
    public List<File>archivos;
    public Date fecheDeInicioActividades;
    public int idFinalista;
    public List<File> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<File> archivos) {
        this.archivos = archivos;
    }
    public void addArchivos(File f){
        archivos.add(f);
    }
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizada() {
        return fechaActualizada;
    }

    public void setFechaActualizada(Date fechaActualizada) {
        this.fechaActualizada = fechaActualizada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombredeDocumento() {
        return nombredeDocumento;
    }

    public void setNombredeDocumento(String nombredeDocumento) {
        this.nombredeDocumento = nombredeDocumento;
    }

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
