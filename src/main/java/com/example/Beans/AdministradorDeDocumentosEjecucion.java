package com.example.Beans;

import com.example.Models.DocumentoEjecucion;
import com.example.Models.DocumentoFinalizacion;
import com.example.Models.DocumentoPrevio;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 05/07/2017.
 * Interface que define todos los metodos que permiten administrar los Documentos de Ejecución
 */
public interface AdministradorDeDocumentosEjecucion {
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio)throws SQLException,ClassNotFoundException, IOException;

}
