package com.example.Beans;

import com.example.Models.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 04/04/2017.
 * Interface que define todos los metodos que permiten administrar los usuarios
 */
public interface AdministradorDeUsuarios {
    /**
     * Método para comprobar si el usuario se encuentra en la base de datos
     * @param email ingresado para entrar al software
     * @param password ingresado para entrar el software
     * @return true/false si esta o no en el software
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean loginContratante(String email, String password) throws SQLException, ClassNotFoundException;
    /**
     * Método para comprobar si el usuario se encuentra en la base de datos
     * @param email ingresado para entrar al software
     * @param password ingresado para entrar el software
     * @return true/false si esta o no en el software
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean loginContratista(String email, String password) throws SQLException, ClassNotFoundException;

    /**
     * Método que trae el identificador del contratante
     * @param email ingresado para entrar al software
     * @param password ingresado para entrar al software
     * @return identificador del Contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getIdContratante(String email, String password) throws SQLException, ClassNotFoundException;
    /**
     * Método que trae el identificador del contratistas
     * @param email ingresado para entrar al software
     * @param password ingresado para entrar al software
     * @return identificador del Contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getIdContratista(String email, String password) throws SQLException, ClassNotFoundException;
    /**
     * Método que trae el identificador del contratistas
     * @param email ingresado para entrar al software
     * @param password ingresado para entrar al software
     * @return usuario Contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Usuario getUsuario(String email, String password) throws SQLException, ClassNotFoundException;
    /**
     * Método que trae el identificador del contratistas
     * @param email ingresado para entrar al software
     * @param password ingresado para entrar al software
     * @return usuario Contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Usuario getUsuario2(String email, String password) throws SQLException, ClassNotFoundException;

    /**
     * Método que trae los requisitos de selección
     * @param idContratante identificador de contratante
     * @param idCategoria identificadro de categoria
     * @return  Listado de Requisitos para el contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Requisito>getRequisitosSugeridos(int idContratante, int idCategoria)throws SQLException, ClassNotFoundException;

    /**
     * Método que trae los requisitos de selección
     * @param idContratante identificador de contratante
     * @param idCategoria identificadro de categoria
     * @return  Listado de Requisitos para el contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>getRequisitosExtras(int idContratante,int idCategoria)throws SQLException, ClassNotFoundException;

    /**
     * Metodo que obtiene los requisitos por contratista
     * @param idContratante
     * @param idCategoria
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  List<RequisitoObligatorio>getObligatorios(int idContratante,int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>getExtras(int idContrato,int idCategoria)throws SQLException,ClassNotFoundException;
    public void actualizarContraseñaContratante(int idContratante,String newPassword)throws SQLException, ClassNotFoundException;
    public void actualizarContraseñaContratista(int idContratista,String newPassword)throws SQLException, ClassNotFoundException;
    public void agregarObligatorio(RequisitoObligatorio obligatorio)throws SQLException, ClassNotFoundException;
    public void agregrarExtra(RequisitoExtra extra)throws  SQLException,ClassNotFoundException;
    public void EliminarObligatorio(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void EliminarExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
}
