package com.example.Controllers;

import com.example.Models.*;
import com.example.Services.ManejadorDeActualizacion;
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

@RestController
@RequestMapping(value="/app/actualizacionDeInfo")
public class ActualizacionDeInfoController {

    @Autowired
    public ManejadorDeActualizacion manejadorDeActualizacion;

    @RequestMapping(value ="Registro",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarInfoContratista(@RequestBody Contratista contratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionContratista(contratista);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroIndicador",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarIndicadorContrtista(@RequestBody Indicador indicador){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionIndicadorContratista(indicador);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroAccidente",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarAccidenteContrtista(@RequestBody Accidente accidente){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionAccidenteContratista(accidente);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroEstandar",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarAccidenteContrtista(@RequestBody EstandarMinimo estandarMinimo){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionEstandarContratista(estandarMinimo);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroPlanDeTrabajo",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarPlanDeTrabajoContrtista(@RequestBody PlanDeTrabajo planDeTrabajo){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionPlanDeTrabajoContratista(planDeTrabajo);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroNoConformidad",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarNoConformidadContrtista(@RequestBody NoConformidad noConformidad){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API


            manejadorDeActualizacion.actualizacionInformacionNoConformidadContratista(noConformidad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroCausa",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarCausaContrtista(@RequestBody Causa causa){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API


            manejadorDeActualizacion.actualizacionInformacionCausaContratista(causa);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroAccion",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarAccionContrtista(@RequestBody Accion accion){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionAccionContratista(accion);

            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroServicio",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarServicioContratante(@RequestBody ServicioAContratar servicioAContratar){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

           manejadorDeActualizacion.actualizarInformacionServicioContratista(servicioAContratar);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
