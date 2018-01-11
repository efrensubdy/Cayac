package com.example.Beans;

import com.example.Models.Accidente;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 11/10/2017.
 * Interfaz para Gestionar los Accidentes
 *
 */
public interface AdministradorDeAccidentes {
    /**
     * Método que inserta un  Accidente en la base datos
     * @param accidente información del accidente
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarAccidente (Accidente accidente)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae los accidentes por contratista
     * @param idContratista que se va traer los accidentes
     * @param idContratante que se va traer los accidentes
     * @return lista con todos los accidentes correspondientes al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accidente>traerAccidentesPorContratista(int idContratista,int idContratante) throws SQLException,ClassNotFoundException;
}
