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

    /**
     * Método que se encarga de registrar el indicador en la base de datos
     * @param indicador objeto con la información del indicador que se va registrar
     * @return ACCEPTED si el objeto se registra correctamente
     */
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

    /**
     * Método que se encarga de agregar la aprobación de los indicadores
     * @param aprobacion objeto con la información de la aprobación
     * @return ACCEPTED si la aprobación se registra
     */
    @RequestMapping(value ="aprobacionIndicadores",method = RequestMethod.POST)
    public ResponseEntity<?> agregarAprobacionDeIndicador(@RequestBody Aprobacion aprobacion){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
           manejadorDeIndicadores.insertarAprobacionDeIndicador(aprobacion);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de traer los indicadores por contratista
     * @param idContratista identificador del contratista al que pertenecen los indicadores
     * @param idContratante identificador del contratante al que pertenece el contratista
     * @return
     */
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

    /**
     * Método que se encarga de traer la aprobación de indicadores de un contratista
     * @param idContratista identificador del contratista que se busca saber si tiene la aprobación
     * @param idContratante identificador del contratante que consulta la aprobación
     * @param mes en el que se aprueban los indicadores
     * @param year en que se aprueban los años
     * @return true o false si se tiene o no la aprobacion
     */
    @RequestMapping(value = "aprobadoIndicador/{idContratista}/{idContratante}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAprobacionDeIndicadorContratisttas(@PathVariable int idContratista, @PathVariable int idContratante,@PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeIndicadores.tieneAprobacionElIndicador(idContratista,idContratante,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de traer el promedio del resultado de los indicadores durante un tiempo en específico
     * @param idContratante identificador del contratante que realiza el reporte
     * @param mes mes en el que se consulta el reporte
     * @param year año en el que se consulta el reporte
     * @return objeto con el resultado calculado
     */
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

    /**
     * Método que se encarga de realizar el promedio del resultado de los indicadores durante un año
     * @param idContratante identificador del contratante que realiza el reporte
     * @param year año en el que se requiere el reporte
     * @return
     */
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

    /**
     * método que se encarga de consultar los indicadores y su detalle durante un periodo de tiempo
     * @param idContratista identificador del contratista al que pertencen los indicadores
     * @param mes en el se requiere el detalle del indicador
     * @param year en el que se requiere el detalle del indicador
     * @return lista con el indicador pertenciente al mes y al año
     */
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

    /**
     * Método que se encarga de traer los contratistas que no hayan registrado indicadores durante un tiempo específico
     * @param idContratante identificador del contratante
     * @param mes en el que se requiere saber si hay registro
     * @param year en el que se requiere saber si hay registro
     * @return Listado con los contratistas que no tengan registro de indicadores en el periodo de tiempo que se requiere
     */
    @RequestMapping(value = "sinRegistro/{idContratante}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>sinRegistroDeIndicador(@PathVariable int idContratante, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeIndicadores.sinRegistroDeIndicador(idContratante,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
