package com.example.Beans;

import com.example.Models.Accidente;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 11/10/2017.
 */
public interface AdministradorDeAccidentes {
    public void insertarAccidente (Accidente accidente)throws SQLException,ClassNotFoundException;
    public List<Accidente>traerAccidentesPorContratista(int idContratista,int idContratante) throws SQLException,ClassNotFoundException;
}
