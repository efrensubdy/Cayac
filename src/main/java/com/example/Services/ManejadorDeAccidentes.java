package com.example.Services;

import com.example.Beans.AdministradorDeAccidentes;
import com.example.DB.AccidentesDB;
import com.example.Models.Accidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 11/10/2017.
 */
@Service
public class ManejadorDeAccidentes implements AdministradorDeAccidentes {
    @Autowired
    public AccidentesDB accidentesDB;
    @Override
    public void insertarAccidente(Accidente accidente) throws SQLException, ClassNotFoundException {
        accidentesDB.insertarAccidente(accidente);
    }

    @Override
    public List<Accidente> traerAccidentesPorContratista(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return accidentesDB.consultarAccidentesporConContratista(idContratista, idContratante);
    }
}
