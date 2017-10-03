package com.example.Beans;

import com.example.Models.Indicador;

import java.sql.SQLException;

/**
 * Created by HSEQ on 03/10/2017.
 */
public interface AdministradorDeIndicadores {
    public void insertarIndicador(Indicador indicador)throws SQLException,ClassNotFoundException;
}
