package com.example.Beans;

import com.example.Models.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 30/03/2017.
 * Interface que define todos los metodos que permiten administrar las los Contratantes
 */
public interface AdministradorDeContratante {
    /**
     * Método para registrar Contratantes en la base de datos
     * @param contratante objeto con la información del contratante que se va insertar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
     public void registrarContratante(Contratante contratante) throws SQLException, ClassNotFoundException;

    /**
     * Método que trae todos los contratantes de la base de datos
     * @return Lista con todos los contratantes de la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratante>obtenerContratantes() throws SQLException, ClassNotFoundException;

    /**
     * Método que trae el contratista pertenciente al contratnte y al contrato
     * @param idContratante identificador de contratante al que pertenece el contrista
     * @param idContrato al que pertenece el contratista
     * @return lista Con el contratista ligado al contrato
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>contratistaPorContratante(int idContratante, int idContrato) throws SQLException, ClassNotFoundException;

    /**
     * Método para traer los contratistas del Contratante busc ado
     * @param idContratante identificador del contratante para traer los Contratistas
     * @return listado con todos los contratistas pertenecientes al contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>contratistaPorContratante(int idContratante) throws SQLException, ClassNotFoundException;

    /**
     * Método que trae los contratistas que pertenezcan a la categoria
     * @param idContrato identificador del contrato al que pertence el contratista
     * @param idCategoria identificador de la categoria dentro del software
     * @return Lista con los contratistas que pertenecen a la categoria y al contrato correpondiente
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>contratistaPorCategoria( int idContrato,int idCategoria) throws SQLException, ClassNotFoundException;

    /**
     * Método que trae todos los requisitos cumplidos por el contratista
     * @param idContratista identificador del contratista que le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertence el contratista
     * @param idContratante identificador del contratante al cual pertenece el contratista
     * @return Listado con los requisitos cumplidos por el contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio> requisitosCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;

    /**
     * Método que trae todos los requisitos no cumplidos por el contratista
     * @param idContratista identificador del contratista que le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertence el contratista
     * @param idContratante identificador del contratante al cual pertenece el contratista
     * @return  Listado con los requisitos  no cumplidos por el contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio> requisitosNoCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;

    /**
     * Método que trae todos los requisitos Extras cumplidos por el contratista
     * @param idContratista identificador del contratista que le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertence el contratista
     * @param idContratante identificador del contratante al cual pertenece el contratista
     * @return Listado con los requisitos extras cumplidos por el contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra> requisitosExtrasCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;

    /**
     *  Método que trae todos los requisitos Extras no cumplidos por el contratista
     * @param idContratista identificador del contratista que le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertence el contratista
     * @param idContratante identificador del contratante al cual pertenece el contratista
     * @return Listado con los requisitos extras no cumplidos por el contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra> requisitosExtrasNoCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;

    /**
     * Método para registrar un servicio para selección
     * @param servicioAContratar objeto con la información del servicio a contratar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void registrarServicioAContratar(ServicioAContratar servicioAContratar)throws SQLException,ClassNotFoundException;

    /**
     * Método pra traer todos los servicios por contratante
     * @param idContratante identificador de contratante al cual pertenecen los servicios
     * @return todos los servicios pertenecientes al contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ServicioAContratar>obtenerTodosLosServicios(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     *  Método pra traer todos los servicios por contratante , además del Contratista
     * @param idContratante identificador de contratante al cual pertenecen los servicios
     * @return todos los servicios pertenecientes al contratante con el contratista asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ServicioAContratar>obtenerTodosLosServiciosConContratista(int idContratante)throws SQLException,ClassNotFoundException;

}
