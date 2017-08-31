package com.example.Beans;

import com.example.Models.DinamicoCumplido;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 30/08/2017.
 */
public interface AdministradorDeCumplimientoDinamico {
    public List<DinamicoCumplido>cumplidosDinamicosPrevios(int idCategoria,int idContratante,int idFinalista) throws SQLException,ClassNotFoundException;
    public List<DinamicoCumplido>cumplidosDinamicosPreviosMatriz(int idCategoria,int idContratante,int idFinalista) throws SQLException,ClassNotFoundException;
    public List<DinamicoCumplido>noCumplidosDinamicosPrevios(int idCategoria,int idContratante,int idFinalista) throws SQLException,ClassNotFoundException;
}
