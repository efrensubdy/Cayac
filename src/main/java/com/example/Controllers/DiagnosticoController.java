package com.example.Controllers;

import com.example.Models.Accidente;
import com.example.Models.Diagnostico;
import com.example.Services.ManejadorDeDiagnosticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 20/11/2017.
 */
@RestController
@RequestMapping(value="/app/diagnostico")
public class DiagnosticoController {
    @Autowired
    public ManejadorDeDiagnosticos manejadorDeDiagnosticos;
    @RequestMapping(value ="diag",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody Diagnostico diagnostico){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeDiagnosticos.insertarDiagnostico(diagnostico);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "diagnosticoGerencia", method = RequestMethod.GET)
    public ResponseEntity<?>indicadoresPorContratista(){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeDiagnosticos.traerDiagnosticosParGerencia(),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
