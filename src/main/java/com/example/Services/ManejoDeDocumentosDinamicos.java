package com.example.Services;

import com.example.Beans.AdministradorDeDocumentosDinamicos;
import com.example.DB.DocumentosDinamicosDB;
import com.example.Models.DocumentoPrevio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 12/07/2017.
 */
@Service
public class ManejoDeDocumentosDinamicos implements AdministradorDeDocumentosDinamicos {
    @Autowired
    public DocumentosDinamicosDB documentosDinamicosDB;
    @Override
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosDB.insertarDocumentoPrevioSugerido(documentoPrevio);
    }

    @Override
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosDB.insertarDocumentoPrevioExtra(documentoPrevio);
    }

    @Override
    public void insertarDocumentoEjecucionSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosDB.insertarDocumentoEjecucionSugerido(documentoPrevio);
    }

    @Override
    public void insertarDocumentoEjecucionExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosDB.insertarDocumentoEjecucionExtra(documentoPrevio);
    }

    @Override
    public void insertarDocumentoFinalizacionSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosDB.insertarDocumentoFinalizacionSugerido(documentoPrevio);
    }

    @Override
    public void insertarDocumentoFinalizacionExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosDB.insertarDocumentoFinalizacionExtra(documentoPrevio);
    }
}
