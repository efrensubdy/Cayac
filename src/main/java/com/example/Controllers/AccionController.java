package com.example.Controllers;

import com.example.Models.Accion;
import com.example.Services.ManejadorDeAcciones;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de Acciones
 */
@RestController
@RequestMapping(value="/app/accion")
public class AccionController {
    @Autowired
    public ManejadorDeAcciones manejadorDeAcciones;

    /**
     *Método para registrar un documento asociado a la acción registrada
     * @param idContratista identificador del contratista que registro la acción
     * @param idCausa identidificador de la causa a la que pertenece la acción
     * @param id identificador de la acción que se registro
     * @param request que contiene el documento
     * @return Accpeted si efectivamente se registra el documento tanto en la base de datos como en el repositorio
     */
    @RequestMapping(path = "/{idContratista}/{idCausa}/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> RegistraroActualizarSoporteDeAccion(@PathVariable Integer idContratista, @PathVariable Integer idCausa, @PathVariable Integer id
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

    /**
     * Método que obtine todas las acciones pertenecientes a un contratista específico
     * @param idContratista identificador del contratista al que pertenecen las acciones
     * @param idCausa identificador de la causa a la que pertenece la acción
     * @return
     */
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

    /**
     * Método que obtiene todas lacciones de un contratista que tienen un registro en el repositorio
     * @param idContratista identificador del contratista a quien pertenecen las acciones
     * @param idCausa identificador de la causa a la cual estan asociadas las acciones
     * @return una lista de objetos de tipo acción con las acciones que tienen un documento asociado en el repositorio
     */
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

    /**
     * Método que obtiene todas lacciones de un contratista que no tienen un registro en el repositorio
     * @param idContratista identificador del contratista a quien pertenecen las acciones
     * @param idCausa identificador de la causa a la cual estan asociadas las acciones
     * @return una lista de objetos de tipo acción con las acciones que no tienen un documento asociado en el repositorio
     */
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

    /**
     * Método que agrega una acción a la base de datos
     * @param accion objeto con la información que se va registrar en la base de datos
     * @return accepted si el objeto y su información efectivamente se registran en la base de datos
     */
    @RequestMapping(value ="Registro",method = RequestMethod.POST)
    public ResponseEntity<?> agregarAccion(@RequestBody Accion accion){

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
