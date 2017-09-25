package com.example.Controllers;

import com.example.Models.*;
import com.example.Services.ManejoDePlanesDeTrabajoBD;
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
 * Created by HSEQ on 12/09/2017.
 */
@RestController
@RequestMapping(value="/app/planDeTrabajo")
public class PlanDeTrabajoController {
    @Autowired
    public ManejoDePlanesDeTrabajoBD manejoDePlanesDeTrabajoBD;

    @RequestMapping(value = "actpC/{idContratista}/{mes}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerActividadesDeContratisttas(@PathVariable int idContratista, @PathVariable String mes){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.traerActividadesPorContratista(idContratista,mes),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "conSopor/{idContratista}/{mes}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerActividadesDeContratisttasConSOPORTE(@PathVariable int idContratista, @PathVariable String mes){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.traerActividadesPorContratistaConSoporte(idContratista,mes),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "sinSopor/{idContratista}/{mes}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerActividadesDeContratisttassinSOPORTE(@PathVariable int idContratista, @PathVariable String mes){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.traerActividadesPorContratistaSinSoporte(idContratista,mes),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "contratante/{idContratante}/{mes}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerPendientesDeSoporte(@PathVariable int idContratante, @PathVariable String mes){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.pendientesSinSoporte(idContratante,mes),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "aprobado/{idContratista}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAprobacionDeContratisttas(@PathVariable int idContratista, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.tieneAprobacion(idContratista,idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "aprobadoPlanDeTrabajo/{idContratista}/{idContratante}/{mes}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAprobacionDePlanDeTrabajoContratisttas(@PathVariable int idContratista, @PathVariable int idContratante,@PathVariable String mes){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.tieneAprobacionPlandeTrabajo(idContratista,idContratante,mes),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value = "mensajesContr/{idContratista}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerMensajesDeContratisttas(@PathVariable int idContratista, @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.consultarMensajesPorContratista(idContratista,idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="aprobacion",method = RequestMethod.POST)
    public ResponseEntity<?> agregarAprobacion(@RequestBody Aprobacion aprobacion){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            System.out.println("csjdfhkdsjhf");
            manejoDePlanesDeTrabajoBD.agregarAprobacion(aprobacion);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="aprobacionDePlanDeTrabajo",method = RequestMethod.POST)
    public ResponseEntity<?> agregarAprobacionPlanDeTrabajo(@RequestBody Aprobacion aprobacion){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            System.out.println("csjdfhkdsjhf");
            manejoDePlanesDeTrabajoBD.agregarAprobaciondePlanTrabajo(aprobacion);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(value ="mensaje",method = RequestMethod.POST)
    public ResponseEntity<?> agregarMensaje(@RequestBody Mensaje mensaje){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDePlanesDeTrabajoBD.agregarMensaje(mensaje);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> agregarActividadDePlanTrabajo(@RequestBody PlanDeTrabajo planDeTrabajo){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDePlanesDeTrabajoBD.agregarPlanDeTrabajo(planDeTrabajo);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    @RequestMapping(path = "/{id}/{idContratista}",method = RequestMethod.POST)
    public ResponseEntity<?> actualizarRegistro(@PathVariable Integer id, @PathVariable Integer idContratista
            , MultipartHttpServletRequest request){

        ResponseEntity a;
        try {

            Iterator<String> itr = request.getFileNames();
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                Documento docForDB=new Documento();
                docForDB.setId(id);
                docForDB.setIdContratista(idContratista);
                docForDB.setFile(fileForDB);
                manejoDePlanesDeTrabajoBD.actualizarSoporte(docForDB);
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
