package com.example.Controllers;

import com.example.Models.Accidente;
import com.example.Services.ManejadorDeAccidentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de Accidentes
 */
@RestController
@RequestMapping(value="/app/accidente")
public class AccidentesController {

    @Autowired
    public ManejadorDeAccidentes manejadorDeAccidentes;

    /**
     * Método que recibe el objeto Accidente a través de un post al Api
     * @param accidente objeto con la información del registro del accidente
     * @return cuando el objeto se registre entrega esto 200 o aceptado
     */
    @RequestMapping(value ="acci",method = RequestMethod.POST)
    public ResponseEntity<?> agergarAccidente(@RequestBody Accidente accidente){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeAccidentes.insertarAccidente(accidente);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que obtine todos los accidentes del contratista
     * @param idContratista identificador del contratista en la base de datos
     * @param idContratante identificador del contratante en la base de datos
     * @return Regresa respuesta de Spring con la lsita de accidentes del contratista
     */
    @RequestMapping(value = "accxContra/{idContratista}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAccidentesPorContratista(@PathVariable int idContratista, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAccidentes.traerAccidentesPorContratista(idContratista,idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
