package com.example.Controllers;

import com.example.Models.Contrato;
import com.example.Models.Documento;
import com.example.Models.DocumentoPrevio;
import com.example.Models.Matriz;
import com.example.Services.ManejoDeContratistasBD;
import com.example.Services.ManejoDeDocumentosPrevios;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 15/08/2017.
 */
@RestController
@RequestMapping(value="/app/docuDinaPre")
public class DocumentosDinamicosPreviosController {
    @Autowired
    private ManejoDeDocumentosPrevios manejoDeDocumentosPrevios;
    @RequestMapping(path = "/{idFinalista}/{idRequisito}/{idContratista}",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagen(@PathVariable Integer idFinalista, @PathVariable Integer idRequisito, @PathVariable int idContratista
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while(itr.hasNext()) {
                String uploadedFile = itr.next();

                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                DocumentoPrevio nuevoDocumentoDb=new DocumentoPrevio(idFinalista,fileForDB,idRequisito,idContratista);
                manejoDeDocumentosPrevios.insertarPrevioDinamicoNormal(nuevoDocumentoDb);



            }
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(path = "extras/{idFinalista}/{idRequisito}/{idContratista}",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagenExtra(@PathVariable Integer idFinalista, @PathVariable Integer idRequisito, @PathVariable int idContratista
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while(itr.hasNext()) {
                String uploadedFile = itr.next();

                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                DocumentoPrevio nuevoDocumentoDb=new DocumentoPrevio(idFinalista,fileForDB,idRequisito,idContratista);
                manejoDeDocumentosPrevios.insertarPrevioDinamicoExtra(nuevoDocumentoDb);

            }
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
    @RequestMapping(value = "previos/{idRequisito}/{idFinalista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenePrevios(@PathVariable int idRequisito,@PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeDocumentosPrevios.historicoDeDocumentosPrevios(idRequisito, idFinalista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "extras/{idRequisito}/{idFinalista}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenePreviosExtras(@PathVariable int idRequisito,@PathVariable int idFinalista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeDocumentosPrevios.historicoDeDocumentosPreviosExtras(idRequisito, idFinalista),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value="matriz/{nombreDoc}/{fechaInicio}/{fechaFin}/{idRequisito}/{idFinalista}/{idContratista}", method = RequestMethod.POST)
    public ResponseEntity<?> registrarContrato(@PathVariable String nombreDoc,@PathVariable String fechaInicio,@PathVariable String fechaFin,@PathVariable Integer idRequisito,@PathVariable Integer idFinalista,@PathVariable Integer idContratista,
                                               MultipartHttpServletRequest request) {
        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            //manejoDeContratoBD.agregarContrato(contrato);
            //org.springframework.web.multipart.MultipartHttpServletRequest
            Iterator<String> itr = request.getFileNames();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            Date parsed2 = (formatter.parse(fechaFin));
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            java.sql.Date sqlFin = new java.sql.Date(parsed2.getTime());

            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                Matriz matrizDePeligros=new Matriz();
                String fileName = fileForDB.getName();
                matrizDePeligros.setFile(fileForDB);
                matrizDePeligros.setNombre(nombreDoc);
                matrizDePeligros.setFechaCreacion(sqlInicio);
                matrizDePeligros.setFechaActualizacion(sqlFin);
                matrizDePeligros.setIdRequisito(idRequisito);
                matrizDePeligros.setIdFinalista(idFinalista);
                matrizDePeligros.setContratista(idContratista);
                manejoDeDocumentosPrevios.insertarMatrizPeligros(matrizDePeligros);

            }

            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;

    }

    }
