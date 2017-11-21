package com.example.Beans;

import com.example.Models.Diagnostico;

import java.sql.SQLException;

public interface AdministradorDeDignostico {

    public void insertarDiagnostico(Diagnostico diagnostico)throws SQLException,ClassNotFoundException;
}
