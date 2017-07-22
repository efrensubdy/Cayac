/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import java.util.List;

/**
 *
 * @author HSEQ la clase contratista sera la encargada del manejor de los
 * datos del contratista
 */
public class Contratista {
    public int id;
    public String nombreEmpresa;
    public String direccion;
    public String nit;
    public String codigoCIIU;
    public String nombreDeGerenteGeneral;
    public String email;
    public String arl;
    public String telefono;
    public int duracionContrato;

    public Date fechaDeCreacion;
    public Date fechaDeActualizacion;
    public int idFinalista;
    public String departamento;
    public String password;
    public int contratante;
    public int idCategoria;
    public int cumplidos;

    public int getCumplidos() {
        return cumplidos;
    }

    public void setCumplidos(int cumplidos) {
        this.cumplidos = cumplidos;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String categoria;
    public String personContacto;
    public String cargoPersonaContacto;
    public String telefonoPersonaContacto;
    public String emailContacto;
    public int idContrato;

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdFinalista() {
        return idFinalista;
    }

    public void setIdFinalista(int idFinalista) {
        this.idFinalista = idFinalista;
    }
    public String getPersonContacto() {
        return personContacto;
    }

    public void setPersonContacto(String personContacto) {
        this.personContacto = personContacto;
    }

    public String getCargoPersonaContacto() {
        return cargoPersonaContacto;
    }

    public void setCargoPersonaContacto(String cargoPersonaContacto) {
        this.cargoPersonaContacto = cargoPersonaContacto;
    }

    public String getTelefonoPersonaContacto() {
        return telefonoPersonaContacto;
    }

    public void setTelefonoPersonaContacto(String telefonoPersonaContacto) {
        this.telefonoPersonaContacto = telefonoPersonaContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getContratante() {
        return contratante;
    }

    public void setContratante(int contratante) {
        this.contratante = contratante;
    }


    public Contratista(@JsonProperty("nombreEmpresa") String nombreEmpresa,@JsonProperty("nit") String nit,@JsonProperty("codigoCIIU") String codigoCIIU,@JsonProperty("nombreDeGerenteGeneral") String nombreDeGerenteGeneral,@JsonProperty("email") String email,@JsonProperty("arl") String arl,@JsonProperty("direccion") String direccion,@JsonProperty("telefono") String telefono,@JsonProperty("duracionContrato") int duracionContrato,@JsonProperty("departamento") String departamento, @JsonProperty("password") String password,  @JsonProperty("contratante")  int contratante,@JsonProperty( "personContacto")String personContacto,@JsonProperty("cargoPersonaContacto")String cargoPersonaContacto,@JsonProperty( "telefonoPersonaContacto")String  telefonoPersonaContacto,@JsonProperty("emailContacto")String emailContacto) {
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.codigoCIIU = codigoCIIU;
        this.nombreDeGerenteGeneral = nombreDeGerenteGeneral;
        this.email = email;
        this.arl = arl;
        this.direccion = direccion;
        this.telefono = telefono;
        this.duracionContrato = duracionContrato;
        this.departamento = departamento;
        this.password = password;
        this.contratante = contratante;
        this.personContacto=personContacto;
        this.cargoPersonaContacto=cargoPersonaContacto;
        this.telefonoPersonaContacto=telefonoPersonaContacto;
        this.emailContacto=emailContacto;
    }

    public Contratista(){

    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCodigoCIIU() {
        return codigoCIIU;
    }

    public void setCodigoCIIU(String codigoCIIU) {
        this.codigoCIIU = codigoCIIU;
    }

    
   
    public String getNombreDeGerenteGeneral() {
        return nombreDeGerenteGeneral;
    }

    public void setNombreDeGerenteGeneral(String nombreDeGerenteGeneral) {
        this.nombreDeGerenteGeneral = nombreDeGerenteGeneral;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(int duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Date getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }

    public void setFechaDeActualizacion(Date fechaDeActualizacion) {
        this.fechaDeActualizacion = fechaDeActualizacion;
    }
}
