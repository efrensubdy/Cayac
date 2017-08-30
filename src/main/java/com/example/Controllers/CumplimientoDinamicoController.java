package com.example.Controllers;

import com.example.Services.ManejoDeCumplimientoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 30/08/2017.
 */
@RestController
@RequestMapping(value="/app/cumplimientoDinamico")
public class CumplimientoDinamicoController {
    @Autowired
    public ManejoDeCumplimientoDB manejoDeCumplimientoDB;

    @RequestMapping(value = "previoSugeridoCumplido/{idCategoria}/{idContratante}/{idFinalista}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiPrevioCumplido( @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante, @PathVariable("idFinalista") int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoDB.cumplidosDinamicosPrevios(idCategoria, idContratante, idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "previoSugeridoNoCumplido/{idCategoria}/{idContratante}/{idFinalista}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiPrevioNoCumplido( @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante, @PathVariable("idFinalista") int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoDB.noCumplidosDinamicosPrevios(idCategoria, idContratante, idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
