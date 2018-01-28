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

    /**
     * Método que obtiene todos los requisitos previos con un documento asociado en el repositorio
     * @param idFinalista identificador del finalista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertencen los requisitos
     * @param idContratante identificador del contratante que requiere los requisitos
     * @return
     */
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
    /**
     * Método que obtiene todos los requisitos previos sin un  documento asociado en el repositorio
     * @param idFinalista identificador del finalista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertencen los requisitos
     * @param idContratante identificador del contratante que requiere los requisitos
     * @return
     */
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
    /**
     * Método que obtiene todos los requisitos Extras con un documento asociado en el repositorio
     * @param idFinalista identificador del finalista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertencen los requisitos
     * @param idContratante identificador del contratante que requiere los requisitos
     * @return
     */

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
    /**
     * Método que obtiene todos los requisitos Extras sin un  documento asociado en el repositorio
     * @param idFinalista identificador del finalista al que se le aplicaron los requisitos
     * @param idCategoria identificador de la categoria a la que pertencen los requisitos
     * @param idContratante identificador del contratante que requiere los requisitos
     * @return
     */

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

}
