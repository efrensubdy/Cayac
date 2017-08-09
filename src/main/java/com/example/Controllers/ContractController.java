/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controllers;

import com.example.Models.Contratista;
import com.example.Models.Usuario;
import com.example.Services.ManejoDeContratistasBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Efren Fenrnadez
 * Controlador de Contratistas
 */
@RestController
@RequestMapping(value="/app/contract")
public class ContractController {

    private ManejoDeContratistasBD manejo;

    public ManejoDeContratistasBD getManejo() {
        return manejo;
    }
    @Autowired
    public void setManejo(ManejoDeContratistasBD manejo) {
        this.manejo = manejo;
    }

    /**
     * Metodo que devuelve todos los contratistas como una Entidad de Respuesta desde aL AP
     * @return ENTIDAD COON TODOS LOS CONTRATISTAS
     */

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorDeObtencionDeContratistas(){
    try {
        //obtener datos que se enviarán a través del API
        return new ResponseEntity<>(manejo.obtenerContratistas(),HttpStatus.ACCEPTED);
    } catch (Exception ex) {
        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
    }        
    }

    /**
     * METODO QUE DEVUELVE TODAS LAS ACTIVIDADES ECONOMICAS QUE SE PUEDEN PONER A UN CONTRATISTA Y CONTRATANTE
     * @return LISTA CON TODAS LAS ACTIVIDADES ECONOMICAS
     */
    @RequestMapping(value = "activity",method = RequestMethod.GET)
    public ResponseEntity<?> obtencionDeActividadesEconomicas(){
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(manejo.obtenerActividadesEconomicas(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Me deveulve el estado de los requisitos prensentados al contratistas para subir los documentos
     * @param idContratante
     * @param idCategoria
     * @param idContratista
     * @return todos los requisitos que le aplican a el contratista aplicad
     */

    @RequestMapping(value = "estadoR/{idContratante}/{idCategoria}/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerEstaodoDeRequisitos(@PathVariable("idContratante")int idContratante,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratista")int idContratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejo.estadoDeRequisitos(idContratante,idCategoria,idContratista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * METODO QUE DEVUELVE EL ESTADO DE LOS REQUISITOS EXTRAS DEL CONTRATISTA
     * @param idContratante
     * @param idCategoria
     * @param idContratista
     * @return TODOS LOS REQUISITOS EXTRAS APLICADOS AL CONTRATISTA QUE PUEDE SUBIR
     */
    @RequestMapping(value = "estadoE/{idContratante}/{idCategoria}/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerEstadoDeRequisitosExtras(@PathVariable("idContratante")int idContratante,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratista")int idContratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejo.estadoExtras(idContratante,idCategoria,idContratista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Metodo post que agrega al contratista
     * @param contratista
     * @return entidazd de respuesta despues de insertar
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>nuevoContratista(@RequestBody Contratista contratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejo.registrarContratista(contratista);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
