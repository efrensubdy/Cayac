package com.example.Beans;

import com.example.Models.Causa;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 25/10/2017.
 */
public interface AdministradorDeCausas {
    public void insertarCausa(Causa causa)throws SQLException,ClassNotFoundException;
    public List<Causa> traerCausasPorContratista(int idContratista, int idNoConformidad)throws SQLException,ClassNotFoundException;
}
