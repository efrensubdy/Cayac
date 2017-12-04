package com.example.Services;

import com.example.Beans.AdministradorDeActualizaciones;
import com.example.DB.ActualizacionDB;
import com.example.Models.Contratista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class ManejadorDeActualizacion implements AdministradorDeActualizaciones{
    @Autowired
    public ActualizacionDB actualizacionDB;
    @Override
    public void actualizacionInformacionContratista(Contratista contratista) throws SQLException, ClassNotFoundException {
        actualizacionDB.actualizarInfoContratista(contratista);
    }
}
