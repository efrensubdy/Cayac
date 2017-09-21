package com.example.Controllers;

import com.example.Models.DocumentoPrevio;
import com.example.Services.ManejoDeDocumentosDeEjecucion;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 05/07/2017.
 */
@RestController
@RequestMapping(value="/app/docEstaticos")
public class DocumentosEstaticosController {
    @Autowired
    public ManejoDeDocumentosDeEjecucion manejoDeDocumentosDeEjecucion;

    @RequestMapping(path = "/{idFinalista}/{idRequisito}/{idContratista}/previoSugerido",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarDocumentoPrevioSugerido(@PathVariable Integer idFinalista, @PathVariable Integer idRequisito,@PathVariable Integer idContratista
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                DocumentoPrevio documentoPrevio=new DocumentoPrevio(idFinalista,fileForDB,idRequisito,idContratista);
                manejoDeDocumentosDeEjecucion.insertarDocumentoPrevioSugerido(documentoPrevio);


            }
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(path = "/{idFinalista}/{idRequisito}/{idContratista}/previoExtra",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarDocumentoPrevioExtra(@PathVariable Integer idFinalista, @PathVariable Integer idRequisito,@PathVariable Integer idContratista
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                DocumentoPrevio documentoPrevio=new DocumentoPrevio(idFinalista,fileForDB,idRequisito,idContratista);
                manejoDeDocumentosDeEjecucion.insertarDocumentoPrevioExtra(documentoPrevio);


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





}
