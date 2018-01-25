package com.example.Controllers;

import com.example.Models.Accidente;
import com.example.Models.Accion;
import com.example.Models.SeguridadSocial;
import com.example.Services.ManejadorDeAcciones;
import com.example.Services.ManejadorDeCausas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 26/10/2017.
 */
@RestController
@RequestMapping(value="/app/accion")
public class AccionController {
    @Autowired
    public ManejadorDeAcciones manejadorDeAcciones;

    /**
     *
     * @param idContratista
     * @param idCausa
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(path = "/{idContratista}/{idCausa}/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagen(@PathVariable Integer idContratista, @PathVariable Integer idCausa, @PathVariable Integer id
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            Accion accion=new Accion();
            accion.setId(id);
            accion.setIdContratista(idContratista);
            accion.setIdCausa(idCausa);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                accion.setRegistro(fileForDB);
            }
            manejadorDeAcciones.registrarOActualizarSoporte(accion);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "porContra/{idContratista}/{idCausa}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAccionesPorContratista(@PathVariable int idContratista,@PathVariable int idCausa){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAcciones.traerAccionesPorContratista(idContratista, idCausa),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "conRegistro/{idContratista}/{idCausa}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAccionesPorContratistaConRegistro(@PathVariable int idContratista,@PathVariable int idCausa){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAcciones.traerAccionesPorContratistaConRegistro(idContratista, idCausa),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "sinRegistro/{idContratista}/{idCausa}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAccionesPorContratistaSinRegistro(@PathVariable int idContratista,@PathVariable int idCausa){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAcciones.traerAccionesPorContratistaSinRegistro(idContratista, idCausa),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="Registro",method = RequestMethod.POST)
    public ResponseEntity<?> agregarIndicador(@RequestBody Accion accion){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API

            manejadorDeAcciones.registrarAccion(accion);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
