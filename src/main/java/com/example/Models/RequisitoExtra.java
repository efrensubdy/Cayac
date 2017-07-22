package com.example.Models;

/**
 * Created by HSEQ on 24/04/2017.
 */
public class RequisitoExtra {
    public int id;
    public  int idContratista;
    public int idRequisito;
    public String descripcion;
    public boolean estado;
    public String tipo;
    public int idContrato;
    public int idCategoria;
    public int idFinalista;
    public int idContratante;

    public int getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }

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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RequisitoExtra(int id, int idContratista, int idRequisito) {
        this.id = id;
        this.idContratista = idContratista;
        this.idRequisito = idRequisito;
    }
    public RequisitoExtra(){

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

    public int getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(int idRequisito) {
        this.idRequisito = idRequisito;
    }
}


