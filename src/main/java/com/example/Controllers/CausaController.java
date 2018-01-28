package com.example.Controllers;

import com.example.Models.Causa;
import com.example.Services.ManejadorDeCausas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de Causas
 */
@RestController
@RequestMapping(value="/app/causa")
public class CausaController {
    @Autowired
    public ManejadorDeCausas manejadorDeCausas;

    /**
     * Método que se encarga de registrar la causa en la base de datos
     * @param causa obejto de tipo Causa con la información que se va a registrar
     * @return ACCEPTED si el objeto se registra en la base de datos
     */
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

    /**
     * Método quie se encarga de consultar las causas asociadas a un contratista
     * @param idContratista identificador del contratista a quien pertenecen las causas
     * @param idNoConformidad identificador de la no conformidad a quien pertecen las causas
     * @return lista con todas las causas asociadas al contratista
     */
    @RequestMapping(value = "porContra/{idContratista}/{idNoConformidad}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerCausasPorContratista(@PathVariable int idContratista,@PathVariable int idNoConformidad){

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
