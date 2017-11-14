package com.example.Controllers;

import com.example.Models.Causa;
import com.example.Models.Mensaje;
import com.example.Services.ManejoDeEliminaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 10/11/2017.
 */
@RestController
@RequestMapping(value="/app/eliminarMessages")
public class MessageController {
    @Autowired
    public ManejoDeEliminaciones manejoDeEliminaciones;
    @RequestMapping(value="eliminarMContratista/{idMessage}",method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarMensajeContratista(@PathVariable int idMessage){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            System.out.println(idMessage);
            manejoDeEliminaciones.eliminarMessagesContratistas(idMessage);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value="eliminarMContratante/{idMessage}",method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarMensajeContratante(@PathVariable int idMessage){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            System.out.println(idMessage);
            manejoDeEliminaciones.eliminarMessagesContratante(idMessage);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}

