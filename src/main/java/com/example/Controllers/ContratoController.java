package com.example.Controllers;

import com.example.Models.Contratante;
import com.example.Models.Contrato;
import com.example.Models.Imagenes;
import com.example.Services.ManejoDeContratoBD;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 13/06/2017.
 */
@RestController
@RequestMapping(value="/app/contratos")
public class ContratoController {
    @Autowired
    public ManejoDeContratoBD manejoDeContratoBD;

    @RequestMapping(value = "/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRequiCumplido(@PathVariable int idContratante) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratoBD.obtenerContratos(idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value = "/ejecucion", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerContratosEjecucion() {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratoBD.contratosEjecucion(), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value = "id/{nombreContrato}", method = RequestMethod.GET)
    public ResponseEntity<?> porNombre(@PathVariable int nombreContrato) {

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API

            return new ResponseEntity<>(manejoDeContratoBD.obtenerContratoporNombre(nombreContrato), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "fecha/{fechaInicio}/{fechaFin}", method = RequestMethod.GET)
    public ResponseEntity<?> porFecha(@PathVariable String fechaInicio, @PathVariable String fechaFin) {

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            Date parsed2 = (formatter.parse(fechaFin));
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            java.sql.Date sqlFin = new java.sql.Date(parsed2.getTime());
            return new ResponseEntity<>(manejoDeContratoBD.contratosPorFecha(sqlInicio, sqlFin), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registrarContratante(@RequestBody Contrato contrato) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeContratoBD.agregarContrato(contrato);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(path = "/documentoContrato/{idcontratante}", method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagen(@PathVariable Integer idcontratante
            , MultipartHttpServletRequest request) {

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB = convert(file);
                Imagenes imagenForDB = new Imagenes();
                imagenForDB.setIdContratante(idcontratante);
                imagenForDB.setFile(fileForDB);
                System.out.println(imagenForDB.getFile().getName());
                //manejoDeContratoBD.insertarDocumento(imagenForDB);
            }
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
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