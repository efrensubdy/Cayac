package com.example.Beans;

import com.example.Models.DocumentoPrevio;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 05/07/2017.
 * Interface que define todos los metodos que permiten administrar los Documentos de Ejecución
 */
public interface AdministradorDeDocumentosEjecucion {
    /**
     * Inserta los Documentos de los requistos aplicados
     * @param documentoPrevio objeto con la información
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException;
    /**
     * Inserta los Documentos de los requistos aplicados
     * @param documentoPrevio objeto con la información
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio)throws SQLException,ClassNotFoundException, IOException;

}
