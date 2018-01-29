package com.example.Controllers;

import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import com.example.Services.ManejoDeFinalistaBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * método que se encarga de traer los requisitos de ejecución definitivos del contratista
     * @param idContratante identificador del contratante que aplica los requisitos
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @return Listado de objetos tipo Requisito con los requisitos definitivos
     */
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
    /**
     * método que se encarga de traer los requisitos de ejecución extras  definitivos del contratista
     * @param idContratante identificador del contratante que aplica los requisitos extras
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @return Listado de objetos tipo Requisito con los requisitos definitivos
     */
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

    /**
     * Método que se encarga de traer lel estado de los requisitos al contratista para que se encargue de subir los soportes
     * @param idContratante identificador del contratante que aplica los requisitos
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @param idFinalista identficador del contratista
     * @return Listado de objetos de tipo requisito  con el estado de los requisitos así mismo con el estado documental
     */
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
    /**
     * Método que se encarga de traer lel estado de los requisitos exttras al contratista para que se encargue de subir los soportes
     * @param idContratante identificador del contratante que aplica los requisitos extras
     * @param idCategoria identificador de la categoria a la que pertenece el contratista
     * @param idFinalista identficador del contratista
     * @return Listado de objetos de tipo requisito  con el estado de los requisitos así mismo con el estado documental
     */
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

    /**
     * Metodo que se encarga de registrar un requisito como definitivo
     * @param requisitoObligatorio objeto con el comportamiento del requisito
     * @return ACCEPTED si se registra el requisito
     */
    @RequestMapping(value="previosSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> registroPrevioSugerido(@RequestBody RequisitoObligatorio requisitoObligatorio){
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            System.out.println("jejeje");
            manejoDeFinalistaBD.insertarPrevioSugerido(requisitoObligatorio);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Metodo que se encarga de registrar un requisito extra como definitivo
     * @param requisitoExtra objeto con el comportamiento del requisito
     * @return ACCEPTED si se registra el requisito
     */
    @RequestMapping(value="previosExtra",method = RequestMethod.POST)
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



}
