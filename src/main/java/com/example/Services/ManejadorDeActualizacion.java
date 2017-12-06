package com.example.Services;

import com.example.Beans.AdministradorDeActualizaciones;
import com.example.DB.ActualizacionDB;
import com.example.Models.Accidente;
import com.example.Models.Contratista;
import com.example.Models.EstandarMinimo;
import com.example.Models.Indicador;
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

    @Override
    public void actualizacionInformacionIndicadorContratista(Indicador indicador) throws SQLException, ClassNotFoundException {
        actualizacionDB.actualizarIndicadorContratista(indicador);
    }

    @Override
    public void actualizacionInformacionAccidenteContratista(Accidente accidente) throws SQLException, ClassNotFoundException {
        actualizacionDB.actualizarAccidentesContratistas(accidente);
    }

    @Override
    public void actualizacionInformacionEstandarContratista(EstandarMinimo estandarMinimo) throws SQLException, ClassNotFoundException {
        actualizacionDB.actualizarEstandarMinimoDeContratista(estandarMinimo);
    }
}
