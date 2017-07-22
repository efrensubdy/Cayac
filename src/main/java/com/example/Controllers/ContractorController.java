package com.example.Controllers;

import com.example.Models.Contratante;
import com.example.Services.ManejoDeContratanteBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 30/03/2017.
 */
@RestController
@RequestMapping(value="/app/contractor")
public class ContractorController {

    private ManejoDeContratanteBD manejoDeContratanteBD;

    public ManejoDeContratanteBD getManejoDeContratanteBD() {
        return manejoDeContratanteBD;
    }
    @Autowired
    public void setManejoDeContratanteBD(ManejoDeContratanteBD manejoDeContratanteBD) {
        this.manejoDeContratanteBD = manejoDeContratanteBD;
    }

    /**
     * Recurso que trae todos los contratantes
     * @return publica en el appi una lista con todos los contratantes
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorDeObtencionDeContratantes(){
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(manejoDeContratanteBD.obtenerContratantes(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Recurso que se encarga de traer contratista por el contratante
     * @param id
     * @param idContrato
     * @return Lista con los contratistas pertenecientes en un contrato
     */
 @RequestMapping(value = "/{id}/{idContrato}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerClientePorContrato(@PathVariable int id,@PathVariable int idContrato){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.contratistaPorContratante(id,idContrato),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Recurso que se encarga de traer al contratista por la categoria , que peryenece al contrato
     * @param idContrato
     * @param idCategoria
     * @return Lista con contratista que pertenecen al contrato y a la categoria
     */
 @RequestMapping(value ="categoria/{idContrato}/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerClientePorCategoria(@PathVariable int idContrato,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.contratistaPorCategoria(idContrato, idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Obtienene los Requisitos Cumplidos del contratista que pertenece al contrato y a la categoria
     * @param idContratista
     * @param idCategoria
     * @param idContratante
     * @return Lista con requisitos cumplidos del contratista pertenciente al contratro y a la categoria
     */

    @RequestMapping(value = "requisitoC/{idContratista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerRequiCumplido(@PathVariable("idContratista") int idContratista,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.requisitosCumplidos(idContratista, idCategoria, idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Obtienene los Requisitos no Cumplidos del contratista que pertenece al contrato y a la categoria
     * @param idContratista
     * @param idCategoria
     * @param idContratante
     * @return Lista con requisitos no cumplidos del contratista pertenciente al contratro y a la categoria
     */
    @RequestMapping(value = "requisitoNC/{idContratista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerRequiNoCumplido(@PathVariable("idContratista") int idContratista,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.requisitosNoCumplidos(idContratista, idCategoria, idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Obtienene los Requisitos Extras Cumplidos del contratista que pertenece al contrato y a la categoria
     * @param idContratista
     * @param idCategoria
     * @param idContratante
     * @return Lista con requisitos Extras cumplidos del contratista pertenciente al contratro y a la categoria
     */
    @RequestMapping(value = "requisitoE/{idContratista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerRequiExtra(@PathVariable("idContratista") int idContratista,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.requisitosExtrasCumplidos(idContratista, idCategoria, idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Obtienene los Requisitos Extras Cumplidos del contratista que pertenece al contrato y a la categoria
     * @param idContratista
     * @param idCategoria
     * @param idContratante
     * @return Lista con requisitos Extras cumplidos del contratista pertenciente al contratro y a la categoria
     */
    @RequestMapping(value = "requisitoENC/{idContratista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerRequiExtraNoCumplido(@PathVariable("idContratista") int idContratista,@PathVariable("idCategoria")int idCategoria,@PathVariable("idContratante")int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.requisitosExtrasNoCumplidos(idContratista, idCategoria, idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>registrarContratante(@RequestBody Contratante contratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeContratanteBD.registrarContratante(contratante);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }



}
