package com.example.Services;

import com.example.Beans.AdministradorDeDocumentosEjecucion;
import com.example.DB.DocumentosEjecucionDB;
import com.example.Models.DocumentoEjecucion;
import com.example.Models.DocumentoFinalizacion;
import com.example.Models.DocumentoPrevio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 05/07/2017.
 */
@Service
public class ManejoDeDocumentosDeEjecucion implements AdministradorDeDocumentosEjecucion {

    @Autowired
    public DocumentosEjecucionDB documentosEjecucionDB;
    @Override
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosEjecucionDB.insertarDocumentoPrevioSugerido(documentoPrevio);
    }

    @Override
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException,IOException {
        documentosEjecucionDB.insertarDocumentoPrevioExtra(documentoPrevio);
    }

}
