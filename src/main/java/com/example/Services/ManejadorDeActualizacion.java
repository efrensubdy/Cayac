package com.example.Services;

import com.example.Beans.AdministradorDeActualizaciones;
import com.example.DB.ActualizacionDB;
import com.example.Models.*;
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

    @Override
    public void actualizacionInformacionPlanDeTrabajoContratista(PlanDeTrabajo planDeTrabajo) throws SQLException, ClassNotFoundException {
        actualizacionDB.actualizarPlanDeTrabajoDeContratista(planDeTrabajo);
    }

    @Override
    public void actualizacionInformacionNoConformidadContratista(NoConformidad noConformidad) throws SQLException, ClassNotFoundException {
        actualizacionDB.actulizarNoConformidad(noConformidad);
    }
}
