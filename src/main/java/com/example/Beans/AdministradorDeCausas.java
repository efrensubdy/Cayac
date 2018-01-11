package com.example.Beans;

import com.example.Models.Causa;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 25/10/2017.
 * Interfaz para la Gestión de las causas
 */
public interface AdministradorDeCausas {
    /**
     * Método que inserta la nueva causa en la base de datos
     * @param causa objeto con la causa que se va agregar a la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarCausa(Causa causa)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae todas las cuasas pertenecientes al contratista
     * @param idContratista del contratista al que pertenecen las causas
     * @param idNoConformidad a la cual pertenecen las causas
     * @return Listas  con todas las causas pertenecientes al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Causa> traerCausasPorContratista(int idContratista, int idNoConformidad)throws SQLException,ClassNotFoundException;
}
