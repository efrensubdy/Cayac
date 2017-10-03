package com.example.Services;

import com.example.Beans.AdministradorDeIndicadores;
import com.example.DB.IndicadorDB;
import com.example.Models.Indicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by HSEQ on 03/10/2017.
 */
@Service
public class ManejadorDeIndicadores implements AdministradorDeIndicadores {
    @Autowired
    public IndicadorDB indicadorDB;


    @Override
    public void insertarIndicador(Indicador indicador) throws SQLException, ClassNotFoundException {
        indicadorDB.insertarIndicador(indicador);
    }
}
