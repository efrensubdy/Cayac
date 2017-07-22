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
 * La siguiente clase se encarga de controlar los contratantes que ingresen al API
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

    @RequestMapping(value = "estadoR/{idContratante}/{idCategoria}/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerEstadoDeRequisitos(@PathVariable("idContratante")int idContratante,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratista")int idContratista){

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
