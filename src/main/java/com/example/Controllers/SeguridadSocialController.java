package com.example.Controllers;

import com.example.Models.Documento;
import com.example.Models.SeguridadSocial;
import com.example.Services.ManejoDeContratistasBD;
import com.example.Services.ManejoDeSeguridadSocial;
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
 * Created by HSEQ on 25/09/2017.
 */
@RestController
@RequestMapping(value="/app/seguridadSocial")
public class SeguridadSocialController {
    @Autowired
    public ManejoDeSeguridadSocial manejoDeSeguridadSocial;

    @RequestMapping(path = "/{idContratista}/{idContratante}/{mes}/{cambios}/{year}",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagen(@PathVariable Integer idContratista, @PathVariable Integer idContratante,@PathVariable String mes,@PathVariable String cambios,@PathVariable int year
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            List<File> archivos=new LinkedList<>();
            SeguridadSocial seguridadSocial=new SeguridadSocial();
            seguridadSocial.setArchivos(archivos);
            seguridadSocial.setIdContratista(idContratista);
            seguridadSocial.setIdContratante(idContratante);
            seguridadSocial.setMes(mes);
            seguridadSocial.setCambios(cambios);
            seguridadSocial.setYear(year);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                seguridadSocial.getArchivos().add(fileForDB);

            }
            manejoDeSeguridadSocial.agregarSeguridadSocial(seguridadSocial);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "segContra/{idContratista}", method = RequestMethod.GET)
    public ResponseEntity<?>indicadoresPorContratista(@PathVariable int idContratista){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeSeguridadSocial.traerSeguridadSocialPorContratista(idContratista),HttpStatus.ACCEPTED);

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
