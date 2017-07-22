package com.example.Models;

import java.util.Date;

/**
 * Created by HSEQ on 29/03/2017.
 */
public class Contratante {
    public int id;
    public String nombreEmpresa;
    public String telefono;
    public String email;
    public String password;
    public String departamento;
    public Date fechaCreacion;
    public Date fechaDeActualizacion;
    public String direccion;
    public String representanteLegal;
    public int codigoCIIU;

    public int getCodigoCIIU() {
        return codigoCIIU;
    }

    public void setCodigoCIIU(int codigoCIIU) {
        this.codigoCIIU = codigoCIIU;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Contratante(String nombreEmpresa, String telefono, String email, String password, String departamento, Date fechaCreacion, Date fechaDeActualizacion,String direccion ,String representanteLegal, int codigoCIIU) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.departamento = departamento;
        this.fechaCreacion = fechaCreacion;
        this.fechaDeActualizacion = fechaDeActualizacion;
        this.direccion=direccion;
        this.representanteLegal=representanteLegal;
        this.codigoCIIU=codigoCIIU;

    }
//public Contratante(@JsonProperty("nombreEmpresa") String nombreEmpresa,@JsonProperty("telefono")  String telefono,@JsonProperty("email") String email,@JsonProperty("password") String password,@JsonProperty("departamento")String departamento) {
       // this.nombreEmpresa = nombreEmpresa;
        //this.telefono = telefono;
        //this.email = email;
        //this.password = password;
        //this.departamento = departamento;
    //}

    public Contratante(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }

    public void setFechaDeActualizacion(Date fechaDeActualizacion) {
        this.fechaDeActualizacion = fechaDeActualizacion;
    }
}
