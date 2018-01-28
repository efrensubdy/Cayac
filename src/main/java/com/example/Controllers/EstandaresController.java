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

    /**
     * Método que se encarga de registrar los estandares mínimoa
     * @param estandarMinimo objeto con la información que se va registrar
     * @return ACCEPTED si el estandar minimo se registra correctamente
     */
    @RequestMapping(value ="minimos",method = RequestMethod.POST)
    public ResponseEntity<?> agregarEstandarMinimo(@RequestBody EstandarMinimo estandarMinimo){

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

    /**
     * Método que se encarga de consultar los estandares mínimos por contratista
     * @param idContratista identificador del contratista a quien pertenece los estandares mínimos
     * @param idContratante identificador del contratante del que pertence el contratista
     * @return Listado de objetos de tipo EstandarMinimo con la información que se requiere consultar
     */
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

    /**
     * Método que trae todos los estandares mínimnos que pertenecen al mes y al año específico
     * @param month mes que se requiere el detalle
     * @param year año que se requiere el detalle
     * @param idContratante identificador del contratante que require el reporte
     * @return
     */
    @RequestMapping(value = "byMonthAndYear/{month}/{year}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>estandaresByMonthAndYear(@PathVariable int month, @PathVariable int year,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeEstandares.consultarEstandarMinimoByMonthAndYear(month, year,idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
