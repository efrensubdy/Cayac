package com.example.Beans;

import com.example.Models.Accion;
import com.example.Models.Cierre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 26/10/2017.
 * Interfaz para gestionar Acciones
 */
public interface AdministradorDeAcciones {
    /**
     * Método de Registrar Acciones
     * @param accion con la información que se va agregar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void registrarAccion(Accion accion)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método para Actualizar Soportes
     * @param accion que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void registrarOActualizarSoporte(Accion accion)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método para registrar cierre
     * @param cierre que se va registrar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void registrarCierre(Cierre cierre)throws SQLException,ClassNotFoundException;

    /**
     * Método para averiguar si la actividad se encuentra cerrada
     * @param idNoConformidad de la noconformidad que se quiere averiguar
     * @param idContratista que quiere cerrar
     * @return un true / false dependiendo del resultado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean actividadIsClose(int idNoConformidad,int idContratista) throws SQLException, ClassNotFoundException;

    /**
     * Método que trae todas las acciones por contratista
     * @param idContratista del contratista perteneciente a las acciones
     * @param idCausa de la causa perteneciente a las acciones
     * @return Listas ccon todas las acciones pertenecientes a la causa
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accion>traerAccionesPorContratista(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae todas las acciones por contratista que tengan registro de documentos
     * @param idContratista ligado a las acciones que se quieren traer
     * @param idCausa ligafo a la causa a la cual pertenecen las acciones
     * @return Lista con todas las acciones que tengan registro
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accion>traerAccionesPorContratistaConRegistro(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae todas las acciones por contratista que no  tengan registro de documentos
     * @param idContratista ligado a las acciones que se quieren traer
     * @param idCausa ligafo a la causa a la cual pertenecen las acciones
     * @return Lista con todas las acciones que no tengan registro
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accion>traerAccionesPorContratistaSinRegistro(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;

    /**
     * Trae todas las noConformiddes cerradas
     * @param idContratista al cual pertenecen las no conformidades
     * @return Lista con las noConformidades cerradas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Cierre>traerNoConforCerradas(int idContratista)throws SQLException,ClassNotFoundException;

    /**
     * Trae todas las noConformiddes cerradas
     * @param idContratista al cual pertenecen las no conformidades
     * @param idAuditaria al cual pertenecen las noConformidades cerradas
     * @return Lista con las noConformidades cerradas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Cierre>traerNoConforCerradas(int idContratista,int idAuditaria)throws SQLException,ClassNotFoundException;
}
