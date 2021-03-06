package com.example.Services;

import com.example.Beans.AdministradorDePlanesDeTrabajo;
import com.example.DB.PlanDeTrabajoBD;
import com.example.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 12/09/2017.
 */
@Service
public class ManejoDePlanesDeTrabajoBD implements AdministradorDePlanesDeTrabajo{
    @Autowired
    public PlanDeTrabajoBD planDeTrabajoBD;
    @Override
    public void agregarPlanDeTrabajo(PlanDeTrabajo plan) throws SQLException, ClassNotFoundException {
        planDeTrabajoBD.agregarPlanDeTrabajo(plan);
    }

    @Override
    public void agregarAprobacion(Aprobacion aprobacion) throws SQLException, ClassNotFoundException {
        planDeTrabajoBD.agregarAprobacion(aprobacion);
    }

    @Override
    public void agregarAprobaciondePlanTrabajo(Aprobacion aprobacion) throws SQLException, ClassNotFoundException {
        planDeTrabajoBD.agregarAprobaciondePlanDeTrabajo(aprobacion);
    }

    @Override
    public void agregarMensaje(Mensaje mensaje) throws SQLException, ClassNotFoundException {
        planDeTrabajoBD.agregarMensaje(mensaje);
    }

    @Override
    public void agregarMensajeContratante(Mensaje mensaje) throws SQLException, ClassNotFoundException {
        planDeTrabajoBD.agregarMensajeContratante(mensaje);
    }

    @Override
    public void actualizarSoporte(Documento doc) throws SQLException, ClassNotFoundException, IOException {
        planDeTrabajoBD.actualizarSoporte(doc);
    }

    @Override
    public List<PlanDeTrabajo> traerActividadesPorContratista(int idContratista,String mes,int year) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajo(idContratista,mes,year);
    }

    @Override
    public List<PlanDeTrabajo> traerActividadesPorContratistaConSoporte(int idContratista, String mes,int year) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajoConSoporte(idContratista, mes,year);
    }

    @Override
    public List<PlanDeTrabajo> traerActividadesPorContratistaSinSoporte(int idContratista, String mes,int year) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajoSinSoporte(idContratista, mes,year);
    }

    @Override
    public List<Mensaje> consultarMensajesPorContratista(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarMensajesContratista(idContratista, idContratante);
    }

    @Override
    public List<Mensaje> consultarMensajesPorContratante(int idContratante) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarMensajesContratante(idContratante);
    }

    @Override
    public List<Contratista> pendientesSinSoporte(int idContratante, String mes, int year) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.pendientesSinSoporte(idContratante, mes, year);
    }

    @Override
    public List<Contratista> sinRegistro(int idContratante,String mes,int year) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.sinRegistrodeActividad(idContratante, mes, year);
    }

    @Override
    public boolean tieneAprobacion(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.tieneAprobacion(idContratista,idContratante);
    }

    @Override
    public boolean tieneAprobacionPlandeTrabajo(int idContratista, int idContratante, String mes,int year) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.tieneAprobacionPlanDeTrabajo(idContratista, idContratante, mes,year);
    }
}
