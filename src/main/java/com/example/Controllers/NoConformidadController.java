package com.example.Controllers;

import com.example.Models.Aprobacion;
import com.example.Models.NoConformidad;
import com.example.Services.ManejoDeNoConformidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 24/10/2017.
 */
@RestController
@RequestMapping(value="/app/noConformidad")
public class NoConformidadController {
    @Autowired
    public ManejoDeNoConformidades manejoDeNoConformidades;

    @RequestMapping(value ="registro",method = RequestMethod.POST)
    public ResponseEntity<?> agregarNoConformidad(@RequestBody NoConformidad noConformidad){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejoDeNoConformidades.agregarNoConformidad(noConformidad);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "porContra/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerNoConformidadesPorContratista(@PathVariable int idContratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeNoConformidades.traerNoConformidadesPorContratistas(idContratista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "porContra/{idContratista}/{idAuditoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerNoConformidadesPorContratistayAuditoria(@PathVariable int idContratista, @PathVariable int idAuditoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeNoConformidades.traerNoConformidadesPorContratistasyAuditoria(idContratista, idAuditoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
