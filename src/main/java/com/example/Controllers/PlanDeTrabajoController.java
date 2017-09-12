package com.example.Controllers;

import com.example.Models.PlanDeTrabajo;
import com.example.Models.Usuario;
import com.example.Services.ManejoDePlanesDeTrabajoBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 12/09/2017.
 */
@RestController
@RequestMapping(value="/app/planDeTrabajo")
public class PlanDeTrabajoController {
    @Autowired
    public ManejoDePlanesDeTrabajoBD manejoDePlanesDeTrabajoBD;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> agregarActividadDePlanTrabajo(@RequestBody PlanDeTrabajo planDeTrabajo){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDePlanesDeTrabajoBD.agregarPlanDeTrabajo(planDeTrabajo);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
