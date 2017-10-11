package com.example.Services;

import com.example.Beans.AdministradorDeAccidentes;
import com.example.DB.AccidentesDB;
import com.example.Models.Accidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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
}
