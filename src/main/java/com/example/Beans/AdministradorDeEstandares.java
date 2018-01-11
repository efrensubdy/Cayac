package com.example.Beans;

import com.example.Models.EstandarMinimo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 18/10/2017.
 * Interface para definir la gestión de estandares
 */
public interface AdministradorDeEstandares {
    /**
     * Método para registrar el estandar Mínimo en la base de datos
     * @param estandarMinimo objeto con la información del estandar
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertarEstandar(EstandarMinimo estandarMinimo)throws ClassNotFoundException,SQLException;

    /**
     * Método consultar los Estandares Minimos por contratista
     * @param idContratista identificador del contratista que pertenecen los estandares
     * @param idContratante identificador del contratante que pertenece el contratista
     * @return Listado con todos los estndares Minimos pertenecientes al contratista
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<EstandarMinimo>consultarEstandarMinimoPorContratista(int idContratista,int idContratante)throws ClassNotFoundException,SQLException;

    /**
     * Método para Consular los estandares Minimos por mes y año
     * @param mes numero del mes para hacer la consulta
     * @param year numero de año para hacer la consulta
     * @return Listado de estandares Minimos del mes y el año
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<EstandarMinimo>consultarEstandarMinimoByMonthAndYear(int mes,int year)throws ClassNotFoundException,SQLException;

}
