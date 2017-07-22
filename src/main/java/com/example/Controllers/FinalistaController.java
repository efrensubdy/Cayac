package com.example.Controllers;

import com.example.Models.Contratista;
import com.example.Models.Finalista;
import com.example.Services.ManejoDeFinalistaBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 07/06/2017.
 */
@RestController
@RequestMapping(value="/app/finalista")
public class FinalistaController {
    @Autowired
    public ManejoDeFinalistaBD manejoDeFinalistaBD;

    @RequestMapping(value = "/{idContratante}/{idContrato}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerClientePorId(@PathVariable int idContratante,@PathVariable int idContrato){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.posiblesFinalistas(idContratante,idContrato),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "definitivo/{idContratante}/{idContrato}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerFinalistas(@PathVariable int idContratante,@PathVariable int idContrato){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.finalistas(idContratante,idContrato),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "previosSugeridos/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenePreviosSugeridos(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.llenarPreviosSugeridos(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "ejecucionSugeridos/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obteneEjecucionSugeridos(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.llenarEjecucionSugeridos(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "finalizacionSugeridos/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerFinalizacionugeridos(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.llenarFinalizacionSugeridos(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "previosExtras/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenePreviosExtras(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.llenarPreviosExtras(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "ejecucionExtras/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerEjecucionExtras(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.llenarEjecucionExtras(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "finalizacionExtras/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerFinalizacionExtras(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.llenarFinalizacionExtras(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> nuevoFinalista(@RequestBody Finalista finalista){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.InsertarFinalista(finalista);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="manual",method = RequestMethod.POST)
    public ResponseEntity<?> registroManual(@RequestBody Contratista contratista){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.InsertarManual(contratista);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
