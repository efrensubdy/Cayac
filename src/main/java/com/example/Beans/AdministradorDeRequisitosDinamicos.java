package com.example.Beans;

import com.example.Models.Requisito;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 10/07/2017.
 * Interface que define todos los metodos que permiten administrar los requisitos Dinamicos
 */
public interface AdministradorDeRequisitosDinamicos {
    public List<Requisito> llenarDinamicosPreviosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> llenarDinamicosPreviosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<Requisito>llenarDinamicosEjecucionSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> llenarDinamicosEjecucionExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<Requisito>llenarDinamicosFinalizacionSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> llenarDinamicosFinalizacionExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoPrevioSugerido)throws SQLException,ClassNotFoundException;
    public void insertarPrevioExtra(RequisitoExtra nuevoPrevioExtra)throws SQLException,ClassNotFoundException;
    public void insertarEjecucionSugerido(RequisitoObligatorio nuevoEjecucionSugerido)throws SQLException,ClassNotFoundException;
    public void insertarEjecucionExtra(RequisitoExtra nuevoEjecucionExtra)throws SQLException,ClassNotFoundException;
    public void insertarFinalizacionSugerido(RequisitoObligatorio nuevoFinalizacionSugerido)throws SQLException,ClassNotFoundException;
    public void insertarFinalizacionExtra(RequisitoExtra nuevoFinalizacionExtra)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>previosDinamicosDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>ejecucionDinamicosDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>finalizacionDinamicosDefinitivosSugeridos(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>previosDinamicosDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>ejecucionDinamicosDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>finalizacionDinamicosDefinitivosExtras(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>estadoPreviosSugeridosDinamicos(int idFinalista, int idCategoria,int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>estadoEjecucionSugeridosDinamicos(int idFinalista, int idCategoria,int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio>estadoFinalizacionSugeridosDinamicos(int idFinalista, int idCategoria,int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoPreviosExtrasDinamicos(int idFinalista, int idCategoria,int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoEjecucionExtrasDinamicos(int idFinalista, int idCategoria,int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoFinalizacionExtrasDinamicos(int idFinalista, int idCategoria,int idContratante)throws SQLException,ClassNotFoundException;


}
