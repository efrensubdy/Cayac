package com.example.Beans;

import com.example.Models.DocumentoPrevio;
import com.example.Models.Matriz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 16/08/2017.
 */
public interface AdministradorDeDocumentosDinamicos {
public void insertarPrevioDinamicoNormal(DocumentoPrevio documentoPrevio)throws SQLException,ClassNotFoundException,IOException;
public void insertarPrevioDinamicoExtra(DocumentoPrevio documentoPrevio)throws SQLException,ClassNotFoundException,IOException;
public void insertarMatrizPeligros(Matriz matrizDePeligros)throws SQLException,ClassNotFoundException,IOException;
public List<DocumentoPrevio>historicoDeDocumentosPrevios(int idRequisito, int idFinalista)throws SQLException,ClassNotFoundException;
    public List<DocumentoPrevio>historicoDeDocumentosPreviosExtras(int idRequisito, int idFinalista)throws SQLException,ClassNotFoundException;


}
