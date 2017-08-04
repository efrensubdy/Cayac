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
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

    @RequestMapping(value = "ejecucion/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerContratosEjecucion(@PathVariable Integer idContratante) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratoBD.contratosEjecucion(idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "enEjecucion/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerContratosEnEjecucion(@PathVariable Integer idContratante) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratoBD.contratosEnEjecucion(idContratante), HttpStatus.ACCEPTED);

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

    @RequestMapping(value="{nombreContrato}/{fechaInicio}/{fechaFin}/{fechaInicioActividades}/{idContratante}/{tipoContrato}", method = RequestMethod.POST)
    public ResponseEntity<?> registrarContrato(@PathVariable String nombreContrato,@PathVariable String fechaInicio,@PathVariable String fechaFin,@PathVariable String fechaInicioActividades ,@PathVariable Integer idContratante,@PathVariable String tipoContrato,
                                               MultipartHttpServletRequest request) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            //manejoDeContratoBD.agregarContrato(contrato);
            //org.springframework.web.multipart.MultipartHttpServletRequest
            Iterator<String> itr = request.getFileNames();
            Contrato nuevoContrato=new Contrato();
            nuevoContrato.setNombreContrato(nombreContrato);
            nuevoContrato.setTipoContrato(tipoContrato);
            nuevoContrato.setIdContratante(idContratante);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            Date parsed2 = (formatter.parse(fechaFin));
            Date parsed3=formatter.parse(fechaInicioActividades);
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            java.sql.Date sqlFin = new java.sql.Date(parsed2.getTime());
            java.sql.Date sqlInicioDeActividades= new java.sql.Date(parsed3.getTime());
            nuevoContrato.setFechaInicio(sqlInicio);
            nuevoContrato.setFechaFin(sqlFin);
            nuevoContrato.setFecheDeInicioActividades(sqlInicioDeActividades);
            List<File>archivos=new LinkedList<>();
            nuevoContrato.setArchivos(archivos);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                nuevoContrato.getArchivos().add(fileForDB);
                String fileName = fileForDB.getName();



            }
            manejoDeContratoBD.agregarContrato(nuevoContrato);
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