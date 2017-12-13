package com.example.Controllers;

import com.example.Models.EstandarMinimo;
import com.example.Models.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/app/example")
public class exampleController {

    @RequestMapping(value ="minimos",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody Example example){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            System.out.println(example.getName());
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "estandaresContra/{idContratista}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>estandaresPorContratista(@PathVariable int idContratista, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            List<Example>ayuda = new LinkedList<>();
            Example b= new Example();
            b.setId(1);
            b.setName("Gordon");
            ayuda.add(b);
            System.out.println("se llego bebe");
            a = new ResponseEntity<>(ayuda,HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}
