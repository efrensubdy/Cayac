package com.example.Beans;

import com.example.Models.Contratista;
import com.example.Models.Indicador;

import java.sql.SQLException;

public interface AdministradorDeActualizaciones {
    public void actualizacionInformacionContratista(Contratista contratista)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionIndicadorContratista(Indicador indicador)throws SQLException,ClassNotFoundException;
}
