package com.example.Beans;

import com.example.Models.NoConformidad;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 24/10/2017.
 * Interface para administrar las no conformidades
 */
public interface  AdministradorDeNoConformidades {
    /**
     * Método para Registrar la noConformidad
     * @param noConformidad objeto con la información de la non conformidad
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void agregarNoConformidad(NoConformidad noConformidad)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae las no conformidades pertenecientes al contratista
     * @param idContratista identificador del contratista al que pertenecen las noConformidades
     * @return Listado de noConformidades que pertenecen al contratistas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<NoConformidad>traerNoConformidadesPorContratistas(int idContratista)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae las Noconformidades con la suditoria correspondiente
     * @param idContratista identificador del contratista al que pertenece la auditoria y la noConformidad
     * @param idAuditoria identificador de la uditoria a la cual esta ligado el contratista
     * @return Lista de no Conformidades y la auditoria correspondiente
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<NoConformidad>traerNoConformidadesPorContratistasyAuditoria(int idContratista,int idAuditoria)throws SQLException,ClassNotFoundException;
}
