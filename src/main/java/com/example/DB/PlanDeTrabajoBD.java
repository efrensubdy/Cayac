package com.example.DB;

import com.example.Models.PlanDeTrabajo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by HSEQ on 12/09/2017.
 */
@Service
public class PlanDeTrabajoBD {

public void agregarPlanDeTrabajo(PlanDeTrabajo plan)throws SQLException,ClassNotFoundException{
    System.out.println(plan.getNombre());

}



}
