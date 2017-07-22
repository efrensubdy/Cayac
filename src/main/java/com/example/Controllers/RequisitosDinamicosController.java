package com.example.Controllers;

import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import com.example.Services.ManejoDeRequisitosDinamicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 10/07/2017.
 */
@RestController
@RequestMapping(value="/app/dinamicos")
public class RequisitosDinamicosController {
    @Autowired
    public ManejoDeRequisitosDinamicos manejoDeRequisitosDinamicos;
    @RequestMapping(value = "previosSugeridos/{idContratante}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenePreviosSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.llenarDinamicosPreviosSugeridos(idContratante,idCategoria), HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.llenarDinamicosEjecucionSugeridos(idContratante,idCategoria),HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.llenarDinamicosFinalizacionSugeridos(idContratante,idCategoria),HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.llenarDinamicosPreviosExtras(idContratante,idCategoria),HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.llenarDinamicosEjecucionExtras(idContratante,idCategoria),HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.llenarDinamicosFinalizacionExtras(idContratante,idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="previoSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeRequisitosDinamicos.insertarPrevioSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="previoExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioExtra(@RequestBody RequisitoExtra requisitoExtra){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeRequisitosDinamicos.insertarPrevioExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="ejecucionSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroEjecucionSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeRequisitosDinamicos.insertarEjecucionSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="ejecucionExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroEjecucionExtra(@RequestBody RequisitoExtra requisitoExtra){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeRequisitosDinamicos.insertarEjecucionExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="finalizacionSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroFinalizacionSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeRequisitosDinamicos.insertarFinalizacionSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="finalizacionExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroFinalizacionExtra(@RequestBody RequisitoExtra requisitoExtra){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeRequisitosDinamicos.insertarFinalizacionExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
