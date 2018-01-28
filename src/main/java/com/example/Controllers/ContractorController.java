package com.example.Controllers;

import com.example.Models.Contratante;
import com.example.Models.ServicioAContratar;
import com.example.Services.ManejoDeContratanteBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de Contratantes
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
     * Obtener los servicios que pertenecen al contratante
     * @param idContratante identificador del contratante a quien pertenecen los servicios
     * @return Listado con los servicios a contratar del contratante
     */
    @RequestMapping(value = "servicioaContratar/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerServ(@PathVariable int idContratante) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.obtenerTodosLosServicios(idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método obtiene los servicios a conratar con el contratista
     * @param idContratante identificador del contratante a quien pertencen los servicios a contratar
     * @return Listado con todos los servicios a contratar
     */
    @RequestMapping(value = "servicioConContratista/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerServConContratista(@PathVariable int idContratante) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.obtenerTodosLosServiciosConContratista(idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
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
    @RequestMapping(value = "contratistasPorContratante/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerClientePorContrato(@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratanteBD.contratistaPorContratante(idContratante),HttpStatus.ACCEPTED);

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

    /**
     * Método qie registra un contratante en la base de datos
     * @param contratante objeto con la información del contratante que se desea registrar
     * @return ACCEPTED si el objeto se registra en la base de datos
     */

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

    /**
     * Método que se encarga de registrar un servicio a contratar en la base de datos
     * @param servicioAContratar objeto con la información del servicio a contratar que se va registrar
     * @return ACCEPTED si se registrar el servicioAContratar en la base de datos
     */
    @RequestMapping(value ="serAContratar",method = RequestMethod.POST)
    public ResponseEntity<?>registrarServicioAContratar(@RequestBody ServicioAContratar servicioAContratar){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeContratanteBD.registrarServicioAContratar(servicioAContratar);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }



}
