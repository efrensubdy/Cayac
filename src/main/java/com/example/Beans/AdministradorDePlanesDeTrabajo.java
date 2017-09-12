package com.example.Beans;

import com.example.Models.PlanDeTrabajo;

import java.sql.SQLException;

/**
 * Created by HSEQ on 12/09/2017.
 */
public interface AdministradorDePlanesDeTrabajo {
    public void agregarPlanDeTrabajo(PlanDeTrabajo plan)throws SQLException,ClassNotFoundException;


}
