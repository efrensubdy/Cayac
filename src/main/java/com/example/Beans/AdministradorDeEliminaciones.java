package com.example.Beans;

import java.sql.SQLException;

/**
 * Created by HSEQ on 01/08/2017.
 * Interface que define todos los metodos que permiten administrar las Eliminaciones
 */
public interface AdministradorDeEliminaciones {
    public void eliminarPrevioSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarPrevioExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;

}
