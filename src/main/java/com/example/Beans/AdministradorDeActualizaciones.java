package com.example.Beans;

import com.example.Models.Accidente;
import com.example.Models.Contratista;
import com.example.Models.EstandarMinimo;
import com.example.Models.Indicador;

import java.sql.SQLException;

public interface AdministradorDeActualizaciones {
    public void actualizacionInformacionContratista(Contratista contratista)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionIndicadorContratista(Indicador indicador)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionAccidenteContratista(Accidente accidente)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionEstandarContratista(EstandarMinimo estandarMinimo)throws SQLException,ClassNotFoundException;
}
