package com.example.Beans;

import com.example.Models.Aprobacion;
import com.example.Models.Contratista;
import com.example.Models.Indicador;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 03/10/2017.
 * Interace para Gestionar los indicadores
 */
public interface AdministradorDeIndicadores {
    /**
     * Método para registrar el inidicador en la base de datos
     * @param indicador objeto con la información del indicador que se desea registrar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarIndicador(Indicador indicador)throws SQLException,ClassNotFoundException;

    /**
     * Método para registrar la aprobación del indicador
     * @param aprobacion objeto con la información de la aprobación
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarAprobacionDeIndicador(Aprobacion aprobacion)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer los indicadores por contratista
     * @param idContratista identificador del contratista al que pertenecen los indicadores
     * @param idContratante identificador del contratnte al que pertenece el contratista
     * @return Listado con todos los indicadores del contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Indicador> indicadoresPorContratista(int idContratista, int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método para los indicadores por contraitsta por mes y año
     * @param idContratista identificador del contratista a quien pertenecen los requisitos
     * @param mes nombre del mes del que se requiere del indicdor
     * @param year numero del año del que se quiere el indicador
     * @return Listado con el indicador del mes y el año correspondiente
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Indicador> indicadoresPorContratistaMes(int idContratista, String mes,int year)throws SQLException,ClassNotFoundException;

    /**
     * Método que realizar el reporte del calculo por mes de los indicadores
     * @param idContratante contratante que realiza el reporte
     * @param mes en el que se requiere el reporte
     * @param year año en el que se requiere el reporte
     * @return Listado con el resultado del reporte
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Indicador> reportesPorMes(int idContratante, String mes,int year)throws SQLException,ClassNotFoundException;

    /**
     * Método que realiza el reporte de indicadores por año
     * @param idContratante contratante que realiza el reporte
     * @param year año en el que se requiere el reporte
     * @return Listado con el resultado del reporte
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Indicador> reportesPorYear(int idContratante, int year)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae los contratistas que no han registrado los indicadores
     * @param idContatante identificador del contratante que requiere el reporte
     * @param mes nombre del mes
     * @param year numero del año
     * @return listado con contratistas que no han registrado indicadores
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista> sinRegistroDeIndicador(int idContatante, String mes,int year) throws SQLException,ClassNotFoundException;

    /**
     * Método para identificar la aprobación de un indicador
     * @param idContratista identificador del contratista que quiere saber si tiene la aprobacion
     * @param idContratante identificador del contratante al cual pertenece el contratista
     * @param mes nombre del mes que se quiere saber si tiene aprobacion
     * @param year numero del año que se quiere saber si tiene la aprobacion
     * @return true/false si tiene aprobacion o no
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean tieneAprobacionElIndicador(int idContratista,int idContratante,String mes,int year) throws SQLException,ClassNotFoundException;

}
