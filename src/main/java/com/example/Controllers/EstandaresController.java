package com.example.Controllers;

import com.example.Models.EstandarMinimo;
import com.example.Services.ManejadorDeEstandares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 18/10/2017.
 */

@RestController
@RequestMapping(value="/app/estandares")
public class EstandaresController {
 @Autowired
 public ManejadorDeEstandares manejadorDeEstandares;
    @RequestMapping(value ="minimos",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody EstandarMinimo estandarMinimo){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejadorDeEstandares.insertarEstandar(estandarMinimo);

            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "estandaresContra/{idContratista}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>estandaresPorContratista(@PathVariable int idContratista, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeEstandares.consultarEstandarMinimoPorContratista(idContratista,idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "byMonthAndYear/{month}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>estandaresByMonthAndYear(@PathVariable int month, @PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeEstandares.consultarEstandarMinimoByMonthAndYear(month, year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
