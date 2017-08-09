package com.example.Controllers;

import com.example.Models.Actividad;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import com.example.Services.ManejoDeActividades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 12/07/2017.
 * Controladdor de Actividades
 */
@RestController
@RequestMapping(value="/app/actividad")
public class ActividadController {
    @Autowired
    public ManejoDeActividades manejoDeActividades;

    /**
     *
      * @param idFinalista
     * @param idRequisito
     * @return ¿
     */
    @RequestMapping(value="{idFinalista}/{idRequisito}/previosSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosPreviosSugeridos(@PathVariable int idFinalista, @PathVariable int idRequisito){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeActividades.traerActividadesPrevias(idFinalista, idRequisito), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idRequisito}/previosExtras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosPreviosExtras(@PathVariable int idFinalista, @PathVariable int idRequisito){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeActividades.traerActividadesExtra(idFinalista, idRequisito), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idRequisito}/ejecucionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosEjecucionSugeridos(@PathVariable int idFinalista, @PathVariable int idRequisito){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeActividades.traerActividadesEjecucionSugerida(idFinalista, idRequisito), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idRequisito}/ejecucionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosEjecucionExtras(@PathVariable int idFinalista, @PathVariable int idRequisito){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeActividades.traerActividadesEjecucionExtra(idFinalista, idRequisito), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idRequisito}/finalizacionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosFinalizacionSugeridos(@PathVariable int idFinalista, @PathVariable int idRequisito){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeActividades.traerActividadesFinalizacionSugerida(idFinalista, idRequisito), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idRequisito}/finalizacionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosFinalizacionExtras(@PathVariable int idFinalista, @PathVariable int idRequisito){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeActividades.traerActividadesFinalizacionExtra(idFinalista, idRequisito), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


    @RequestMapping(value="previoSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioSugerido(@RequestBody Actividad actividad){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejoDeActividades.insertarActividadPreviaSugerida(actividad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="previoExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioExtra(@RequestBody Actividad actividad){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeActividades.insertarActividadPreviaExtra(actividad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="ejecucionSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroEjecucionSugerido(@RequestBody Actividad actividad){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeActividades.insertarActividadEjecucionSugerida(actividad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="ejecucionExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroEjecucionExtra(@RequestBody Actividad actividad){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeActividades.insertarActividadEjecucionExtra(actividad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="finalizacionSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroFinalizacionSugerido(@RequestBody Actividad actividad){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeActividades.insertarActividadFinalizacionSugerida(actividad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="finalizacionExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroFinalizacionExtra(@RequestBody Actividad actividad){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeActividades.insertarActividadFinalizacionExtra(actividad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }








}
