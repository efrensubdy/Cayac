package com.example.Controllers;

import com.example.Models.FechaLimite;
import com.example.Services.ManejoDeContratistasBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 26/05/2017.
 */
@RestController
@RequestMapping(value="/app/limites")
public class LimitController {
    @Autowired
    ManejoDeContratistasBD manejoDeContratistasBD;
    @RequestMapping(value="{idContratante}/{idCategoria}" ,method = RequestMethod.GET)
    public ResponseEntity<?> responseResource(@PathVariable int idContratante, @PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            a = new ResponseEntity<>(manejoDeContratistasBD.getFechaPorContratista(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>registrarFechaLimite(@RequestBody FechaLimite fechaLimite){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeContratistasBD.registrarFechaLimite(fechaLimite);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
