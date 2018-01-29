package com.example.Controllers;

import com.example.Models.RequisitoExtra;
import com.example.Services.ManejoDeUsuariosBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 24/04/2017.
 */
@RestController
@RequestMapping(value="/app/requisitosExtras")
public class RequisitosExtrasController {
    @Autowired
    private ManejoDeUsuariosBD manejoDeUsuariosBD;

    public ManejoDeUsuariosBD getManejoDeUsuariosBD() {
        return manejoDeUsuariosBD;
    }

    public void setManejoDeUsuariosBD(ManejoDeUsuariosBD manejoDeUsuariosBD) {
        this.manejoDeUsuariosBD = manejoDeUsuariosBD;
    }

    /**
     * Método que trae todos los requisitos extras al contratante
     * @param idContratante identificador del contratante que aplico los requisitos
     * @param idCategoria identificador de la categoria que pertenecen los contratistas
     * @return listado de objetos  con los posibles requisitos para esa categora
     */
    @RequestMapping(value="{idContratante}/{idCategoria}/extras",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequisitosExtrasObligatiorios(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeUsuariosBD.getExtras(idContratante, idCategoria), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que registra un requisito extra como definitivo
     * @param requisitoExtra que se volverá definitivo
     * @return ACCEPTED SI SE REGISTRA EL REQUISITO
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>agregarExtraObligatorios(@RequestBody RequisitoExtra requisitoExtra){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeUsuariosBD.agregrarExtra(requisitoExtra);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de eliminar requisitos extras
     * @param idRequisito identificador de requisito que se requiere elimninar
     * @param idContratante identificador del contratante que elimina el requisito
     * @return ACCEPTED sose elimina efectivamente el requisito
     */
    @RequestMapping(value="eliminar/{idRequisito}/{idContratante}",method = RequestMethod.DELETE)
    public ResponseEntity<?>EliminarExtra(@PathVariable int idRequisito,@PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeUsuariosBD.EliminarExtra(idRequisito,idContratante);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
