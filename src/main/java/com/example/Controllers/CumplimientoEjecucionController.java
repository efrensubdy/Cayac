package com.example.Controllers;

import com.example.Services.ManejoDeCumplimientoBD;
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
 * Created by HSEQ on 06/07/2017.
 */
@RestController
@RequestMapping(value="/app/cumplimiento")
public class CumplimientoEjecucionController {
    @Autowired
    public ManejoDeCumplimientoBD manejoDeCumplimientoBD;
    @RequestMapping(value = "previoSugeridoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiPrevioCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosCumplidosPreviosSugeridos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "previoSugeridoNoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerPrevioSugeridoNoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosNoCumplidosSugeridosPrevios(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "ejecucionSugeridoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerEjecucionSugeridoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosCumplidosEjecucionSugeridos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "ejecucionSugeridoNoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerEjecucionSugeridoNoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosNoCumplidosEjecucionSugeridos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "finalizacionSugeridoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerFinalizacionSugeridoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosCumplidosFinalizacionSugeridos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "finalizacionSugeridoNoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerFinalizacionSugeridoNoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosNoCumplidosFinalizacionSugeridos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value = "previoSugeridoExtraCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiPrevioExtraCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosExtrasPreviosCumplidos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value = "previoSugeridoExtraNoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiPrevioExtraNoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosExtrasPreviosNoCumplidos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value = "ejecucionSugeridoExtraCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiEjecucionExtraCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosExtrasEjecucionCumplidos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "ejecucionExtraNoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiEjecucionExtraNoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosExtrasEjecucionNoCumplidos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "finalizacionExtraCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiFinalizacionExtraCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosExtrasFinalizacionCumplidos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "finalizacionExtraNoCumplido/{idFinalista}/{idCategoria}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiFinalizacionExtraNoCumplido(@PathVariable("idFinalista") int idFinalista, @PathVariable("idCategoria")int idCategoria, @PathVariable("idContratante")int idContratante ){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeCumplimientoBD.requisitosExtrasFinalizacionNoCumplidos(idFinalista, idCategoria, idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
