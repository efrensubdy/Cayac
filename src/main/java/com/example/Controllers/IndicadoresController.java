package com.example.Controllers;

import com.example.Models.Aprobacion;
import com.example.Models.Indicador;
import com.example.Services.ManejadorDeIndicadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 03/10/2017.
 */
@RestController
@RequestMapping(value="/app/indicador")
public class IndicadoresController {

    @Autowired
    public ManejadorDeIndicadores manejadorDeIndicadores;
    @RequestMapping(value ="Indicadores",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody Indicador indicador){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejadorDeIndicadores.insertarIndicador(indicador);

            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "indicadoresContra/{idContratista}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>indicadoresPorContratista(@PathVariable int idContratista, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeIndicadores.indicadoresPorContratista(idContratista,idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "reportesPorMes/{idContratante}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>reporteDeIndicadoresPormes(@PathVariable int idContratante, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeIndicadores.reportesPorMes(idContratante, mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "reportesPorYear/{idContratante}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>reporteDeIndicadoresPorYear(@PathVariable int idContratante, @PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeIndicadores.reportesPorYear(idContratante, year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "indicadoresPorMes/{idContratista}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>indicadoresPorContratistaMes(@PathVariable int idContratista, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeIndicadores.indicadoresPorContratistaMes(idContratista,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
