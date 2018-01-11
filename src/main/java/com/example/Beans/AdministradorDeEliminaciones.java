package com.example.Beans;

import java.sql.SQLException;

/**
 * Created by HSEQ on 01/08/2017.
 * Interface que define todos los metodos que permiten administrar las Eliminaciones
 */
public interface AdministradorDeEliminaciones {
    /**
     * Método para eliminar los requisitos del contratista
     * @param idRequisito identificador del requisito que se desea eliminar
     * @param idContratante identificdor del contratante que desea eliminar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarPrevioSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    /**
     * Método para eliminar los requisitos del contratista
     * @param idRequisito identificador del requisito que se desea eliminar
     * @param idContratante identificdor del contratante que desea eliminar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarPrevioExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método para Eliminar nmensajes  de Contratistas
     * @param idMessages identificdor del mensaje que se va a eliminar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarMessagesContratistas(int idMessages)throws SQLException,ClassNotFoundException;
    /**
     * Método para Eliminar nmensajes del contrantante
     * @param idMessages identificdor del mensaje que se va a eliminar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarMessagesContratante(int idMessages)throws SQLException,ClassNotFoundException;

}
