package com.example.Beans;

import java.sql.SQLException;

/**
 * Created by HSEQ on 01/08/2017.
 */
public interface AdministradorDeEliminaciones {
    public void eliminarPrevioSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarPrevioExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarEjecucionSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarEjecucionExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarFinalizacionSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarFinalizacionExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarDinamicoPrevioSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarDinamicoPrevioExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarDinamicoEjecucionSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarDinamicoEjecucionExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarDinamicoFinalizacionSugerido(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;
    public void eliminarDinamicoFinalizacionExtra(int idRequisito,int idContratante)throws SQLException,ClassNotFoundException;




}
