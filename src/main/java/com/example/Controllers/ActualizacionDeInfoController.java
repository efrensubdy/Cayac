package com.example.Controllers;

import com.example.Models.Accion;
import com.example.Models.Contratista;
import com.example.Models.Indicador;
import com.example.Services.ManejadorDeActualizacion;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ManejadorDeActualizacion manejadorDeActualizacion;

    @RequestMapping(value ="Registro",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarInfoContratista(@RequestBody Contratista contratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionContratista(contratista);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="RegistroIndicador",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarIndicadorContrtista(@RequestBody Indicador indicador){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeActualizacion.actualizacionInformacionIndicadorContratista(indicador);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
