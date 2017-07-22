package com.example.Beans;

import com.example.Models.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 04/04/2017.
 */
public interface AdministradorDeUsuarios {
    public boolean loginContratante(String email, String password) throws SQLException, ClassNotFoundException;
    public boolean loginContratista(String email, String password) throws SQLException, ClassNotFoundException;
    public int getIdContratante(String email, String password) throws SQLException, ClassNotFoundException;
    public int getIdContratista(String email, String password) throws SQLException, ClassNotFoundException;
    public Usuario getUsuario(String email, String password) throws SQLException, ClassNotFoundException;
    public Usuario getUsuario2(String email, String password) throws SQLException, ClassNotFoundException;
    public List<Requisito>getRequisitosSugeridos(int idContratante, int idCategoria)throws SQLException, ClassNotFoundException;
    public List<RequisitoExtra>getRequisitosExtras(int idContratante,int idCategoria)throws SQLException, ClassNotFoundException;
    public  List<RequisitoObligatorio>getObligatorios(int idContratante,int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>getExtras(int idContrato,int idCategoria)throws SQLException,ClassNotFoundException;
    public void actualizarContraseñaContratante(int idContratante,String newPassword)throws SQLException, ClassNotFoundException;
    public void actualizarContraseñaContratista(int idContratista,String newPassword)throws SQLException, ClassNotFoundException;
    public void agregarObligatorio(RequisitoObligatorio obligatorio)throws SQLException, ClassNotFoundException;
    public void agregrarExtra(RequisitoExtra extra)throws  SQLException,ClassNotFoundException;
    public void EliminarObligatorio(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void EliminarExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
}
