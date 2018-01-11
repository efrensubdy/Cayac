package com.example.Beans;

import com.example.Models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 07/06/2017.
 * Interface que define todos los metodos que permiten administrar los Finalistas
 */
public interface AdministradorDeFinalistas {
    /**
     * Método para registrar al finalista en la base de datos
     * @param finalista objeto con la información para volver al candidato finalista
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void InsertarFinalista(Finalista finalista)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método para registrar el cambio entre un candidato y un finalista contratista
     * @param finalista objeto con la información del candidato que se volverá finalista
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarFinalistaSeleccion(Finalista finalista)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método para registrar Contratista directamente sin tener que pasar por la selección
     * @param con objeto Contratista que se agregará para posteriormente ser Finalista
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void InsertarManual(Contratista con)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método para registrar un requisito por parte del contratante
     * @param nuevoPrevioSugerido objeto con la información para registrar el requisito
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoPrevioSugerido)throws SQLException,ClassNotFoundException;

    /**
     * Método para registrar un requisito Extra en la base de datos
     * @param nuevoPrevioExtra objeto con la información para registrar el requisito
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarPrevioExtra(RequisitoExtra nuevoPrevioExtra)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae los posibles candidatos a Contratista
     * @param idContratante identificador dle contratante al que pertenecen los candidatos
     * @param idContrato identificador del contrato que se le va a agregar al contrato
     * @return Listado con los posibles candidatos a contratistas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista> posiblesFinalistas(int idContratante,int idContrato)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer a los contratistas
     * @param idContratante identificador del contratante al que pertenecen los contratistas
     * @param idContrato identificador del Contrato al que pertenece el contratista
     * @return Listado con los contratistas ligados al contrato
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>finalistas(int idContratante,int idContrato)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer los Contratistas de selección
     * @param idContratante identificador del contratante al que pertenecen los contratistas
     * @return Listado con todos los finalistas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>finalistasSeleccion(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer los requisitos de los contratantes
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria
     * @return Listado de requisitos pertenecientes al contratante y a la categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Requisito>llenarPreviosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer los requisitos de los contratantes
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria
     * @return Listado de requisitos pertenecientes al contratante y a la categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra> llenarPreviosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;

    /**
     *  Método para traer los requisitos Definitivos al contratante para el contrtista
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria
     * @return Listado de requisitos aplicados para el contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>previosDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;

    /**
     *  Método para traer los requisitos definitivos al contratante para el contratista
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria
     * @return Listado de requisitos aplicados para el contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>previosDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;

    /**
     * Metodo para definir el estado de los requisitos para el Contratista
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria
     * @param idFinalista identificador del contratista
     * @return listado con el estado de requistos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>estadoPreviosSugeridos(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;
    /**
     * Metodo para definir el estado de los requisitos para el Contratista
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria
     * @param idFinalista identificador del contratista
     * @return listado con el estado de requistos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>estadoPreviosExtras(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;


}
