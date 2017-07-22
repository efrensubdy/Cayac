package com.example.Beans;

import com.example.Models.DocumentoEjecucion;
import com.example.Models.DocumentoFinalizacion;
import com.example.Models.DocumentoPrevio;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 05/07/2017.
 */
public interface AdministradorDeDocumentosEjecucion {
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio)throws SQLException,ClassNotFoundException, IOException;
    public void insertarDocumentoEjecucionSugerido(DocumentoEjecucion documentoEjecucion)throws SQLException,ClassNotFoundException , IOException;
    public void insertarDocumentoEjecucionExtra(DocumentoEjecucion documentoEjecucion)throws SQLException,ClassNotFoundException , IOException;
    public void insertarDocumentoFinalizacionSugerido(DocumentoFinalizacion documentoFinalizacion)throws SQLException,ClassNotFoundException , IOException;
    public void insertarDocumentoFinalizacionExtra(DocumentoFinalizacion documentoFinalizacion)throws SQLException,ClassNotFoundException , IOException;
}
