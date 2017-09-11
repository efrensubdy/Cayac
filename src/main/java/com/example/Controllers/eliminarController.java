package com.example.Controllers;

import com.example.Services.ManejoDeEliminaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 01/08/2017.
 */
@RestController
@RequestMapping(value="/app/eliminar")
public class eliminarController {
    @Autowired
    public ManejoDeEliminaciones manejoDeEliminaciones;

    @RequestMapping(value="eliminarPS/{idRequisito}/{idContratante}",method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPrevioSugerido(@PathVariable int idRequisito, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeEliminaciones.eliminarPrevioSugerido(idRequisito,idContratante);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="eliminarPE/{idRequisito}/{idContratante}",method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPrevioextra(@PathVariable int idRequisito, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeEliminaciones.eliminarPrevioExtra(idRequisito,idContratante);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }



}
