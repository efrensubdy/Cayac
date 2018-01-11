package com.example.Beans;

import com.example.Models.Diagnostico;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface que define los métodos para gestionar los diagnosticos
 */
public interface AdministradorDeDignostico {
    /**
     * Método  para registrar diagnosticos en la base de datos
     * @param diagnostico objeto con la información del diagnosticos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarDiagnostico(Diagnostico diagnostico)throws SQLException,ClassNotFoundException;

    /**
     * Método que devuelve los diagnosticos a la gerencia
     * @return Listado con los diagnosticos para la gerencia
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Diagnostico>traerDiagnosticosParGerencia()throws SQLException,ClassNotFoundException;
}
