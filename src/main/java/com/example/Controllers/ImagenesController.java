package com.example.Controllers;

import com.example.Models.Imagenes;
import com.example.Services.ManejoDeContratistasBD;
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
 * Created by HSEQ on 26/04/2017.
 */
@RestController
@RequestMapping(value="/app/imagenes")
public class ImagenesController {

@Autowired
private ManejoDeContratistasBD manejoDeContratistasBD;

    public ManejoDeContratistasBD getManejoDeContratistasBD() {
        return manejoDeContratistasBD;
    }

    public void setManejoDeContratistasBD(ManejoDeContratistasBD manejoDeContratistasBD) {
        this.manejoDeContratistasBD = manejoDeContratistasBD;
    }
    /**
     * Método que se encarga de registrar el soporte de un requisito extra en la base de datos
     * @param idContratista identificador del contratista
     * @param idRequisitoSugerido identificador el requisito
     * @param request Documento asociado al soporte  del requisito
     * @return
     */
    @RequestMapping(path = "/{idContratista}/{idRequisitoSugerido}",method = RequestMethod.POST)
    public ResponseEntity<?> InsertarImagen(@PathVariable Integer idContratista,@PathVariable Integer idRequisitoSugerido
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                Imagenes imagenForDB=new Imagenes(idContratista,fileForDB,idRequisitoSugerido);
                manejoDeContratistasBD.registrarImagen(imagenForDB);
            }
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "/{idContratista}/{idRequisitoSugerido}", method = RequestMethod.GET)
    public ResponseEntity<?> tipoImagen(@PathVariable int idContratista, @PathVariable  int idRequisitoSugerido){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeContratistasBD.extraertipo(idContratista, idRequisitoSugerido), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    /**
     * Método que convierte un objeto de tipo Multipart en un objeto de tipo File
     * @param file archivo que se desea transformar
     * @return objeto de tipo File con la información del objeto de tipo Multipart
     * @throws IOException excepción de tipo archivos
     */
    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }





}
