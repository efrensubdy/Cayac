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

/**
 * Controlador de Actualizaciones
 */
@RestController
@RequestMapping(value="/app/actualizacionDeInfo")
public class ActualizacionDeInfoController {

    @Autowired
    public ManejadorDeActualizacion manejadorDeActualizacion;

    /**
     * Método que se encarga de actualizar la información del contratista
     * @param contratista objeto del tipo Contratista con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
    /**
     * Método que se encarga de actualizar la información del indicador
     * @param indicador objeto del tipo Indicador con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
    /**
     * Método que se encarga de actualizar la información del accidente
     * @param accidente objeto del tipo Indicador con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
    /**
     * Método que se encarga de actualizar la información del Estandar Mínimo
     * @param estandarMinimo objeto del tipo Indicador con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
    @RequestMapping(value ="RegistroEstandar",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarEstandaContrtista(@RequestBody EstandarMinimo estandarMinimo){

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
    /**
     * Método que se encarga de actualizar la información de la actividad del plan de trabajo
     * @param planDeTrabajo objeto del tipo PlanDeTrabajo con la información actualizada de actividad
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
    @RequestMapping(value ="RegistroPlanDeTrabajo",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarPlanDeTrabajoContratista(@RequestBody PlanDeTrabajo planDeTrabajo){

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
    /**
     * Método que se encarga de actualizar la información de la No Conformidad
     * @param noConformidad objeto del tipo NoConformidad con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
    /**
     * Método que se encarga de actualizar la información de la Causa
     * @param causa objeto del tipo Causa con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
    /**
     * Método que se encarga de actualizar la información de la accion
     * @param accion objeto del tipo Accion con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
    /**
     * Método que se encarga de actualizar la información del ServicioAContratar
     * @param servicioAContratar objeto del tipo ServicioAContratar con la información actualizada
     * @return ACCEPTED si el objeto efectivamente se actualiza en la base de datos
     */
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
