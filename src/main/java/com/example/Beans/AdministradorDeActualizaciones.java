package com.example.Beans;

import com.example.Models.*;

import java.sql.SQLException;

public interface AdministradorDeActualizaciones {
    public void actualizacionInformacionContratista(Contratista contratista)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionIndicadorContratista(Indicador indicador)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionAccidenteContratista(Accidente accidente)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionEstandarContratista(EstandarMinimo estandarMinimo)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionPlanDeTrabajoContratista(PlanDeTrabajo planDeTrabajo)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionNoConformidadContratista(NoConformidad noConformidad)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionCausaContratista(Causa causa)throws SQLException,ClassNotFoundException;
    public void actualizacionInformacionAccionContratista(Accion accion)throws SQLException,ClassNotFoundException;
}
