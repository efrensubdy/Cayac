package com.example.Services;

import com.example.Beans.AdministradorDeDocumentosDinamicos;
import com.example.DB.DocumentosDinamicosPreviosDB;
import com.example.Models.DocumentoPrevio;
import com.example.Models.Matriz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 16/08/2017.
 */
@Service
public class ManejoDeDocumentosPrevios implements AdministradorDeDocumentosDinamicos {
    @Autowired
    private DocumentosDinamicosPreviosDB documentosDinamicosPreviosDB;
    @Override
    public void insertarPrevioDinamicoNormal(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosPreviosDB.insertarDinamicoPrevioNormal(documentoPrevio);
    }

    @Override
    public void insertarPrevioDinamicoExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosPreviosDB.insertarPrevioExtraDinamico(documentoPrevio);
    }

    @Override
    public void insertarMatrizPeligros(Matriz matrizDePeligros) throws SQLException, ClassNotFoundException, IOException {
        documentosDinamicosPreviosDB.insertarMatrizDePeligros(matrizDePeligros);
    }

    @Override
    public List<DocumentoPrevio> historicoDeDocumentosPrevios(int idRequisito, int idFinalista) throws SQLException, ClassNotFoundException {
        return documentosDinamicosPreviosDB.traerHistorialDeDocumentos(idRequisito, idFinalista);
    }

    @Override
    public List<DocumentoPrevio> historicoDeDocumentosPreviosExtras(int idRequisito, int idFinalista) throws SQLException, ClassNotFoundException {
        return documentosDinamicosPreviosDB.traerHistorialDeDocumentosExtras(idRequisito, idFinalista);
    }
}
