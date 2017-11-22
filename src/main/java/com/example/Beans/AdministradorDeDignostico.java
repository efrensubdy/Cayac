package com.example.Beans;

import com.example.Models.Diagnostico;

import java.sql.SQLException;
import java.util.List;

public interface AdministradorDeDignostico {

    public void insertarDiagnostico(Diagnostico diagnostico)throws SQLException,ClassNotFoundException;
    public List<Diagnostico>traerDiagnosticosParGerencia()throws SQLException,ClassNotFoundException;
}
