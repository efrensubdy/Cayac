package com.example.Models;

/**
 * Created by User on 02/04/2017.
 */
public class Usuario {
    public String email;
    public String password;
    public int id;
    public int idContratante;
    public int idContratista;
    public int idFinalista;
    public int categoria;
    public int nivelDeRiezgo;
    public int idContrato;
    public boolean estado;
    public String estadoDatabase;
    public String rol;
    public int idAdministrador;
    public boolean isFinalista;

    public boolean isFinalista() {
        return isFinalista;
    }

    public void setFinalista(boolean finalista) {
        isFinalista = finalista;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstadoDatabase() {
        return estadoDatabase;
    }

    public void setEstadoDatabase(String estadoDatabase) {
        this.estadoDatabase = estadoDatabase;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getNivelDeRiezgo() {
        return nivelDeRiezgo;
    }

    public void setNivelDeRiezgo(int nivelDeRiezgo) {
        this.nivelDeRiezgo = nivelDeRiezgo;
    }

    public Usuario(String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }
    public Usuario() {


    }

    public int getIdFinalista() {
        return idFinalista;
    }

    public void setIdFinalista(int idFinalista) {
        this.idFinalista = idFinalista;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }

    public int getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(int idContratista) {
        this.idContratista = idContratista;
    }
}
