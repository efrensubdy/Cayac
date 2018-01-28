package com.example.Controllers;

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

    /**
     * Método que registra la NoConformidad en la base de datos
     * @param noConformidad objeto con la información de la noConformidad que se va a registrar
     * @return ACCEPTED si se registra la no conformidad
     */
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

    /**
     * Método que se encarga de traer las no conformidades pertenecientes a un contratistas
     * @param idContratista identificador del contratista al que pertencen las no conformidades
     * @return Listado con objetos de tipo NoConformidad que pertenezcan al contratista
     */
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

    /**
     * Método que se encarga de traer las no conformidades pertenecientes a un contratistas y una auditoria
     * @param idContratista identificador del contratista al que pertencen las no conformidades
     * @param idAuditoria identificador de la auditoria a la que pertenecen las no conformidades
     * @return Listado con objetos de tipo NoConformidad que pertenezcan al contratista
     */
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
