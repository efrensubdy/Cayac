package com.example.Controllers;

import com.example.Models.Accion;
import com.example.Models.Contratista;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/app/actualizacionDeInfo")
public class ActualizacionDeInfoController {



    @RequestMapping(value ="Registro",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody Contratista contratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            System.out.println(contratista.getNombreEmpresa() + "/" + contratista.getDepartamento() + "/" + contratista.getArl());
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
