package com.example.Models;

/**
 * Created by HSEQ on 29/03/2017.
 */
public class Departamento {
    public int idDepartamento;
    public String nombreDepa;
    public int idCiu;

    public Departamento(int idDepartamento, String nombreDepa, int idCiu) {
        this.idDepartamento = idDepartamento;
        this.nombreDepa = nombreDepa;
        this.idCiu = idCiu;
    }
    public Departamento(){

    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepa() {
        return nombreDepa;
    }

    public void setNombreDepa(String nombreDepa) {
        this.nombreDepa = nombreDepa;
    }

    public int getIdCiu() {
        return idCiu;
    }

    public void setIdCiu(int idCiu) {
        this.idCiu = idCiu;
    }
}
