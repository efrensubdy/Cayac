package com.example.Beans;

import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 06/07/2017.
 * Interface que define todos los metodos que permiten administrar el cumpimiento
 */
public interface AdministradorDeCumplimiento {
    /**
     * Método que trae los requisitos que tengan un documento
     * @param idFinalista identificador del contratista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @param idContratante  identificador del contratante que aplico los requisitos
     * @return Listado con todos los requisitos que tienen un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio> requisitosCumplidosPreviosSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae los requisitos que no tengan un documento
     * @param idFinalista identificador del contratista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @param idContratante identificador del contratante que aplico los requisitos
     * @return Listado con todos los requisitos que no tienen un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio> requisitosNoCumplidosSugeridosPrevios(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae los requisitos que tengan un documento
     * @param idFinalista identificador del contratista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @param idContratante  identificador del contratante que aplico los requisitos
     * @return Listado con todos los requisitos que tienen un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasPreviosCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    /**
     * Método que trae los requisitos que no tengan un documento
     * @param idFinalista identificador del contratista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @param idContratante identificador del contratante que aplico los requisitos
     * @return Listado con todos los requisitos que no tienen un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasPreviosNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;

}
