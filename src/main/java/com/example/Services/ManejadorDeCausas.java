package com.example.Services;

import com.example.Beans.AdministradorDeCausas;
import com.example.DB.CausaDB;
import com.example.Models.Causa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 25/10/2017.
 */
@Service
public class ManejadorDeCausas implements AdministradorDeCausas {
    @Autowired
    public CausaDB causaDB;
    @Override
    public void insertarCausa(Causa causa) throws SQLException, ClassNotFoundException {
        causaDB.insertarCausa(causa);
    }

    @Override
    public List<Causa> traerCausasPorContratista(int idContratista, int idNoConformidad) throws SQLException, ClassNotFoundException {
        return causaDB.traerCausasPorContratista(idContratista, idNoConformidad);
    }
}
