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
 * Created by HSEQ on 10/11/2017.
 */
@RestController
@RequestMapping(value="/app/eliminarMessages")
public class MessageController {
    @Autowired
    public ManejoDeEliminaciones manejoDeEliminaciones;

    /**
     * Método que se encarga de eliminar mensajes al contratista
     * @param idMessage identificador del mensaje que se va eliminar
     * @return ACCEPTED si se efectua la eliminación
     */
    @RequestMapping(value="eliminarMContratista/{idMessage}",method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarMensajeContratista(@PathVariable int idMessage){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeEliminaciones.eliminarMessagesContratistas(idMessage);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de eliminar mensajes al contratante
     * @param idMessage identificador del mensaje que se va eliminar
     * @return ACCEPTED si se efectua la eliminación
     */
    @RequestMapping(value="eliminarMContratante/{idMessage}",method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarMensajeContratante(@PathVariable int idMessage){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeEliminaciones.eliminarMessagesContratante(idMessage);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}

