package com.example.Controllers;

import com.example.Models.Cierre;
import com.example.Services.ManejadorDeAcciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 30/10/2017.
 */
@RestController
@RequestMapping(value="/app/cierre")
public class CierreController {
    @Autowired
    public ManejadorDeAcciones manejadorDeAcciones;

    /**
     * Mètodo que se encarga de registrar el cierre de una No Conformidad
     * @param cierre objeto de tipo cierre con la información del cierre
     * @return ACCEPTED si el cierre se registra en la base de datos
     */
    @RequestMapping(value ="registro",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCierre(@RequestBody Cierre cierre){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeAcciones.registrarCierre(cierre);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encargar de consultar si encuentra cerrada la noConformidad
     * @param idNoConformidad identificador de la noConformidad que se quiere cerrar
     * @param idContratista identificador del contratista al que se le cerro la No Conformidad
     * @return
     */
    @RequestMapping(value = "isClose/{idNoConformidad}/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>actividadIsClose(@PathVariable int idNoConformidad, @PathVariable int idContratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAcciones.actividadIsClose(idNoConformidad, idContratista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que trae las NoConformidades cerradas por contratistas
     * @param idContratista identificador del contratista
     * @return Listado de objetos con tipo NoConformidad con las no conformidades cerradas
     */
    @RequestMapping(value = "isCl/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerCerradas(@PathVariable int idContratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAcciones.traerNoConforCerradas(idContratista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que trae las NoConformidades cerradas por contratistas y auditora
     * @param idContratista identificador del contratista
     * @param idAuditoria identificador de la auditoria a quien pertencen las no conformidades
     * @return lista con las no conformidades cerradas pertenecientes a la auditoria
     */
    @RequestMapping(value = "isCl/{idContratista}/{idAuditoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerCerradas(@PathVariable int idContratista,@PathVariable int idAuditoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAcciones.traerNoConforCerradas(idContratista,idAuditoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
