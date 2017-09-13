package com.example.Services;

import com.example.Beans.AdministradorDePlanesDeTrabajo;
import com.example.DB.PlanDeTrabajoBD;
import com.example.Models.Aprobacion;
import com.example.Models.PlanDeTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<PlanDeTrabajo> traerActividadesPorContratista(int idContratista,String mes) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.consultarActividadesdelPlanDeTrabajo(idContratista,mes);
    }

    @Override
    public boolean tieneAprobacion(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return planDeTrabajoBD.tieneAprobacion(idContratista,idContratante);
    }
}
