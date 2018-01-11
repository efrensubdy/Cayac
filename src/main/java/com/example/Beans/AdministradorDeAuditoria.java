package com.example.Beans;

import com.example.Models.Auditoria;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 23/10/2017.
 * Método que gestionar las Auditorias
 */
public interface AdministradorDeAuditoria {

    /**
     * Método para insertar una auditoria en la base de datos
     * @param auditoria objeto el cual se va agregar en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
     public void insertarAuditoria(Auditoria auditoria)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método que trae las auditorias del Contratante
      * @param idContratante del contratante al pertenecen las auditorias
     * @return Lista con las auditorias pertenecientes al contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Auditoria>traerAuditoriasDeContratante(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer las auditorias del Contratistas
     * @param idContratista al cual pertenece una auditoria
     * @param mes del la auditoria
     * @param year año de la auditoria
     * @return Lista Con las auditorias del contratista del mes y del año
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Auditoria>traerAuditoriasDeContratista(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException;
}
