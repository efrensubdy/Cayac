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
    public void InsertarFinalista(Finalista finalista)throws SQLException,ClassNotFoundException,IOException;
    public void InsertarManual(Contratista con)throws SQLException,ClassNotFoundException,IOException;
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoPrevioSugerido)throws SQLException,ClassNotFoundException;
    public void insertarPrevioExtra(RequisitoExtra nuevoPrevioExtra)throws SQLException,ClassNotFoundException;
    public void insertarEjecucionSugerido(RequisitoObligatorio nuevoEjecucionSugerido)throws SQLException,ClassNotFoundException;
    public void insertarEjecucionExtra(RequisitoExtra nuevoEjecucionExtra)throws SQLException,ClassNotFoundException;
    public void insertarFinalizacionSugerido(RequisitoObligatorio nuevoFinalizacionSugerido)throws SQLException,ClassNotFoundException;
    public void insertarFinalizacionExtra(RequisitoExtra nuevoFinalizacionExtra)throws SQLException,ClassNotFoundException;
   public List<Contratista> posiblesFinalistas(int idContratante,int idContrato)throws SQLException,ClassNotFoundException;
    public List<Contratista>finalistas(int idContratante,int idContrato)throws SQLException,ClassNotFoundException;
    public List<Requisito>llenarPreviosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> llenarPreviosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<Requisito>llenarEjecucionSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> llenarEjecucionExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<Requisito>llenarFinalizacionSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> llenarFinalizacionExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>previosDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>ejecucionDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>finalizacionDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>previosDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>ejecucionDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>finalizacionDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>estadoPreviosSugeridos(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>estadoEjecucionSugeridos(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>estadoFinalizacionSugeridos(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoPreviosExtras(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoEjecucionExtras(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoFinalizacionExtras(int idContratante, int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException;


}
