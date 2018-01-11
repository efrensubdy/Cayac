/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Beans;

import com.example.Models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HSEQ
 * Interface que define todos los metodos que permiten administrar los contratistas
 */
public interface AdministradorDeContratistas {
    /**
     * Método para registrar al contratista de selección
     * @param con información del candidato
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void registrarContratista(Contratista con) throws SQLException, ClassNotFoundException, IOException;

    /**
     *Método  para obtener la Fecha Limite
     * @param idContrato identificador del contratrato al que se le impuso la fecha Limite
     * @param idCategoria identificador de la categoria a la que se le impuso la fecha
     * @return objeto con la fecha limite para la categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public FechaLimite getFechaPorContratista(int idContrato,int idCategoria)throws SQLException,ClassNotFoundException;

    /**
     * Obtiene todas las Fechas Limites del contratante indicado
     * @param idContratante identificador del contratante al cual pertenecen las fechas
     * @return Lista con todas las Fechas Limites pertenecientes al contratante indicado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<FechaLimite>fechasContratante(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método que obtiene todos los contratistas dentro del software
     * @return Lista con todos los contratistas del software
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista> obtenerContratistas() throws SQLException, ClassNotFoundException;

    /**
     * Método que guarda un documento de Selección dentro el repositorio y lo registra en la base de datos
     * @param imagen objeto con la información que se va agregar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void registrarImagen(Imagenes imagen)throws SQLException, ClassNotFoundException, IOException;

    /**
     * Método que guarda un documento de Selección dentro el repositorio y lo registra en la base de datos
     * @param documento documento objeto con la información que se va agregar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void registrarDocumento(Documento documento)throws SQLException, ClassNotFoundException, IOException;

    /**
     * Método que registra la fecha Limite dentro de la base de Datos
     * @param fechaLimite objeto con la información limite para la Categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void registrarFechaLimite(FechaLimite fechaLimite)throws SQLException,ClassNotFoundException;

    /**
     * Método para extraer la extensión del archivo que se guarda en el repositorio
     * @param idContratista  identificador del contratista al que pertence el archivo
     * @param idRequisitoSugerido identificador del requisito al que pertenece el documento
     * @return String con el tipo de documento
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public String extraertipo(int idContratista, int idRequisitoSugerido)throws  SQLException, ClassNotFoundException;

    /**
     * Método que trae el estado de los requisitos establecidos por el contratante para la categoria indicada
     * @param idContratante identificador del contratante al que pertenecen los requisitos
     * @param idCategoria identificador de la categoria a la que pertenecen los requisitos
     * @param idContratista identificador del contratista al que pertenecen los requisitos
     * @return Listado con los requisitos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>estadoDeRequisitos(int idContratante,int idCategoria,int idContratista)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae el estado de los requisitos establecidos por el contratante para la categoria indicada
     * @param idContratante identificador del contratante al que pertenecen los requisitos
     * @param idCategoria identificador de la categoria a la que pertenecen los requisitos
     * @param idContratista identificador del contratista al que pertenecen los requisitos
     * @return Listado con los requisitos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>estadoExtras(int idContratante,int idCategoria,int idContratista)throws  SQLException,ClassNotFoundException;

    /**
     * Método que obtiene todas las actividades economicas
     * @return  Lista con todas las actividades economicas de la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ActividadEconomica>obtenerActividadesEconomicas()throws SQLException,ClassNotFoundException;

}
