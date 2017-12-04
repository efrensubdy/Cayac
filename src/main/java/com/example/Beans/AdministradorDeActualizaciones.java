package com.example.Beans;

import com.example.Models.Contratista;

import java.sql.SQLException;

public interface AdministradorDeActualizaciones {
    public void actualizacionInformacionContratista(Contratista contratista)throws SQLException,ClassNotFoundException;

}
