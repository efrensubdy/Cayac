package com.example.Services;

import com.example.Beans.AdministradorDePlanesDeTrabajo;
import com.example.DB.PlanDeTrabajoBD;
import com.example.Models.PlanDeTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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
}
