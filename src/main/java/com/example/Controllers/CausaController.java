package com.example.Controllers;

import com.example.Models.Causa;
import com.example.Models.NoConformidad;
import com.example.Services.ManejadorDeCausas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 25/10/2017.
 */
@RestController
@RequestMapping(value="/app/causa")
public class CausaController {
    @Autowired
    public ManejadorDeCausas manejadorDeCausas;
    @RequestMapping(value ="registro",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCausa(@RequestBody Causa causa){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeCausas.insertarCausa(causa);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "porContra/{idContratista}/{idNoConformidad}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAprobacionDeContratisttas(@PathVariable int idContratista,@PathVariable int idNoConformidad){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeCausas.traerCausasPorContratista(idContratista, idNoConformidad),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
