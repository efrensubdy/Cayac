package com.example.Controllers;

import com.example.Services.ManejoDeRequisitosDinamicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 10/07/2017.
 */
@RestController
@RequestMapping(value="/app/dinamicosDefinitivos")
public class RequisitosDinamicosDefCpntroller {
    @Autowired
    public ManejoDeRequisitosDinamicos manejoDeRequisitosDinamicos;
    @RequestMapping(value="{idContratante}/{idCategoria}/previosSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosPreviosSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.previosDinamicosDefinitivosSugeridos(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/previosExtras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosPreviosExtras(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.previosDinamicosDefinitivosExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/ejecucionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosEjecucionSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.ejecucionDinamicosDefinitivosSugeridos(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/ejecucionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosEjecucionExtras(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.ejecucionDinamicosDefinitivosExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/finalizacionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosFinalizacionSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.finalizacionDinamicosDefinitivosSugeridos(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/finalizacionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosFinalizacionExtras(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.finalizacionDinamicosDefinitivosExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idCategoria}/{idContratante}/estadoPreviosSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> estadoPreviosSugeridos(@PathVariable int idFinalista, @PathVariable int idCategoria,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.estadoPreviosSugeridosDinamicos(idFinalista, idCategoria,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idCategoria}/{idContratante}/estadoPreviosExtras",method = RequestMethod.GET)
    public ResponseEntity<?> estadoPreviosExtras(@PathVariable int idFinalista, @PathVariable int idCategoria, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.estadoPreviosExtrasDinamicos(idFinalista, idCategoria,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idCategoria}/{idContratante}/estadoEjecucionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> estadoEjecucionSugeridos(@PathVariable int idFinalista, @PathVariable int idCategoria,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.estadoEjecucionSugeridosDinamicos(idFinalista, idCategoria,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idCategoria}/{idContratante}/estadoEjecucionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> estadoEjecucionExtras(@PathVariable int idFinalista, @PathVariable int idCategoria,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.estadoEjecucionExtrasDinamicos(idFinalista, idCategoria,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idCategoria}/{idContratante}/estadoFinalizacionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> estadoFinalizacionSugeridos(@PathVariable int idFinalista, @PathVariable int idCategoria,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.estadoFinalizacionSugeridosDinamicos(idFinalista, idCategoria,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idFinalista}/{idCategoria}/{idContratante}/estadoFinalizacionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> estadoFinalizacionExtra(@PathVariable int idFinalista, @PathVariable int idCategoria,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeRequisitosDinamicos.estadoFinalizacionExtrasDinamicos(idFinalista, idCategoria,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }




}
