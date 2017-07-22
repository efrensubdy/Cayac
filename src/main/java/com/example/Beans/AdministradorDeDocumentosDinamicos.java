package com.example.Beans;

import com.example.Models.DocumentoPrevio;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 12/07/2017.
 */
public interface AdministradorDeDocumentosDinamicos {
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoEjecucionSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoEjecucionExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoFinalizacionSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoFinalizacionExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
}
