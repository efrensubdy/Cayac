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
    public void agregarMensaje(Mensaje mensaje) throws SQLException, ClassNotFoundException {
        planDeTrabajoBD.agregarMensaje(mensaje);
    }

    @Override
    public void actualizarSoporte(Documento doc) throws SQLException, ClassNotFoundException, IOException {
        planDeTrabajoBD.actualizarSoporte(doc);
    }

    @Override
    public List<PlanDeTrabajo> traerActividadesPorContratista(int idContratista,String mes) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajo(idContratista,mes);
    }

    @Override
    public List<PlanDeTrabajo> traerActividadesPorContratistaConSoporte(int idContratista, String mes) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajoConSoporte(idContratista, mes);
    }

    @Override
    public List<PlanDeTrabajo> traerActividadesPorContratistaSinSoporte(int idContratista, String mes) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajoSinSoporte(idContratista, mes);
    }

    @Override
    public List<Mensaje> consultarMensajesPorContratista(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarMensajesContratista(idContratista, idContratante);
    }

    @Override
    public List<Contratista> pendientesSinSoporte(int idContratante, String mes) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.pendientesSinSoporte(idContratante, mes);
    }

    @Override
    public boolean tieneAprobacion(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.tieneAprobacion(idContratista,idContratante);
    }
}
