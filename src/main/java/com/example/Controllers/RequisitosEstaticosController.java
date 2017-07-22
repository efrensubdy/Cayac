package com.example.Controllers;

import com.example.DB.FinalistDB;
import com.example.Models.Contratista;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import com.example.Services.ManejoDeFinalistaBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 04/07/2017.
 */
@RestController
@RequestMapping(value="/app/requisitoEstaticos")
public class RequisitosEstaticosController {

    @Autowired
    public ManejoDeFinalistaBD manejoDeFinalistaBD;

    public ManejoDeFinalistaBD getManejoDeFinalistaBD() {
        return manejoDeFinalistaBD;
    }

    public void setManejoDeFinalistaBD(ManejoDeFinalistaBD manejoDeFinalistaBD) {
        this.manejoDeFinalistaBD = manejoDeFinalistaBD;
    }

    @RequestMapping(value="{idContratante}/{idCategoria}/previosSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosPreviosSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.previosDefinitivosSugeridos(idContratante, idCategoria), HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeFinalistaBD.previosDefinitivosExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeFinalistaBD.ejecucionDefinitivosSugeridos(idContratante, idCategoria), HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeFinalistaBD.ejecucionDefinitivosExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeFinalistaBD.finalizacionDefinitivosSugeridos(idContratante, idCategoria), HttpStatus.ACCEPTED);

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
            a = new ResponseEntity<>(manejoDeFinalistaBD.finalizacionDefinitivosExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/{idFinalista}/estadoPreviosSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> estadoPreviosSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria,@PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.estadoPreviosSugeridos(idContratante, idCategoria,idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/{idFinalista}/estadoPreviosExtras",method = RequestMethod.GET)
    public ResponseEntity<?> estadoPreviosExtras(@PathVariable int idContratante, @PathVariable int idCategoria,@PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.estadoPreviosExtras(idContratante, idCategoria,idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/{idFinalista}/estadoEjecucionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> estadoEjecucionSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria, @PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.estadoEjecucionSugeridos(idContratante, idCategoria,idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/{idFinalista}/estadoEjecucionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> estadoEjecucionExtras(@PathVariable int idContratante, @PathVariable int idCategoria, @PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.estadoEjecucionExtras(idContratante, idCategoria,idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/{idFinalista}/estadoFinalizacionSugeridos",method = RequestMethod.GET)
    public ResponseEntity<?> estadoFinalizacionSugeridos(@PathVariable int idContratante, @PathVariable int idCategoria,@PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.estadoFinalizacionSugeridos(idContratante, idCategoria,idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="{idContratante}/{idCategoria}/{idFinalista}/estadoFinalizacionExtras",method = RequestMethod.GET)
    public ResponseEntity<?> estadoFinalizacionExtra(@PathVariable int idContratante, @PathVariable int idCategoria,@PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeFinalistaBD.estadoFinalizacionExtras(idContratante, idCategoria,idFinalista), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="previoSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.insertarPrevioSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="previoExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioExtra(@RequestBody RequisitoExtra requisitoExtra){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.insertarPrevioExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="ejecucionSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroEjecucionSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.insertarEjecucionSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="ejecucionExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroEjecucionExtra(@RequestBody RequisitoExtra requisitoExtra){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.insertarEjecucionExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="finalizacionSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroFinalizacionSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.insertarFinalizacionSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="finalizacionExtra",method = RequestMethod.POST)
    public ResponseEntity<?> registroFinalizacionExtra(@RequestBody RequisitoExtra requisitoExtra){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeFinalistaBD.insertarFinalizacionExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }



}
