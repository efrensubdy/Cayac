package com.example.Controllers;

import com.example.Models.Auditoria;
import com.example.Models.SeguridadSocial;
import com.example.Services.ManejadorDeAuditoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
 * Created by HSEQ on 23/10/2017.
 */
@RestController
@RequestMapping(value="/app/auditoria")
public class AuditoriaController {
    @Autowired
    public ManejadorDeAuditoria manejadorDeAuditoria;
    @RequestMapping(path = "/{idContratista}/{idContratante}/{mes}/{year}",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagen(@PathVariable Integer idContratista, @PathVariable Integer idContratante, @PathVariable String mes, @PathVariable int year
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            List<File> archivos=new LinkedList<>();
            Auditoria auditoria=new Auditoria();
            auditoria.setArchivos(archivos);
            auditoria.setIdContratista(idContratista);
            auditoria.setIdContratante(idContratante);
            auditoria.setMes(mes);
            auditoria.setYear(year);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                auditoria.setFile(fileForDB);

            }
            manejadorDeAuditoria.insertarAuditoria(auditoria);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "audi/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAuditoriasPorContratante( @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAuditoria.traerAuditoriasDeContratante(idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "audi/{idContratista}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAuditoriasPorContratista( @PathVariable int idContratista, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejadorDeAuditoria.traerAuditoriasDeContratista(idContratista,mes,year),HttpStatus.ACCEPTED);

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
