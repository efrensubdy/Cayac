package com.example.Controllers;

import com.example.Models.Accidente;
import com.example.Models.Indicador;
import com.example.Services.ManejadorDeAccidentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 11/10/2017.
 */
@RestController
@RequestMapping(value="/app/accidente")
public class AccidentesController {

    @Autowired
    public ManejadorDeAccidentes manejadorDeAccidentes;
    @RequestMapping(value ="acci",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody Accidente accidente){

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
