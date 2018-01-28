package com.example.Controllers;

import com.example.Models.Aprobacion;
import com.example.Models.Documento;
import com.example.Models.Mensaje;
import com.example.Models.PlanDeTrabajo;
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

    @RequestMapping(value = "actpC/{idContratista}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerActividadesDeContratisttas(@PathVariable int idContratista, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.traerActividadesPorContratista(idContratista,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que trae todos las actividades que tienen soporte  por contratista
     * @param idContratista identificador del contratista
     * @param mes en el que se registraron las actividades
     * @param year en que se registraron las actividades
     * @return Listado con las actividades que tienen soportes
     */
    @RequestMapping(value = "conSopor/{idContratista}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerActividadesDeContratisttasConSOPORTE(@PathVariable int idContratista, @PathVariable String mes, @PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.traerActividadesPorContratistaConSoporte(idContratista,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    /**
     * Método que trae todos las actividades que no tienen soporte  por contratista
     * @param idContratista identificador del contratista
     * @param mes en el que se registraron las actividades
     * @param year en que se registraron las actividades
     * @return Listado con las actividades que no tienen soportes
     */
    @RequestMapping(value = "sinSopor/{idContratista}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerActividadesDeContratisttassinSOPORTE(@PathVariable int idContratista, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.traerActividadesPorContratistaSinSoporte(idContratista,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga traer los contratistas que no han registrado actividades
     * @param idContratante identificador del contratante que requiere la notificación
     * @param mes en el que se requiere la notificación
     * @param year en el que se requiere la notificación
     * @return Listado con los contratistas que no hayan registrado las actividades durante el periodo indicado
     */
    @RequestMapping(value = "sinRegistro/{idContratante}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerSinRegistroDeActividad(@PathVariable int idContratante,@PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.sinRegistro(idContratante,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se traer las actividades que tienen archivos pendientes de soporte
     * @param idContratante identificador del contratante
     * @param mes en el que se realiza la consulta
     * @param year el que se realiza la consulta
     * @return lISTADO con las actividades que no tienen soporte
     */
    @RequestMapping(value = "contratante/{idContratante}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerPendientesDeSoporte(@PathVariable int idContratante, @PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.pendientesSinSoporte(idContratante,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     *Método que obtiene la aprobación de los contratistas para que inicie actividades
     * @param idContratista identificador del contratista
     * @param idContratante  identificadot del contratante
     * @return true/ false si el contratista tiene aprobación
     */
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

    /**
     *Método que obtiene la aprobación del plan de trabajo durante un periodo de tiempo
     * @param idContratista identificador del contratista
     * @param idContratante identificadot del contratante
     * @param mes en el que se aprueban el plan de trabajo
     * @param year en el que se aprueban el plan de trabajo
     * @return true/false si el contratista tiene la aprobación
     */
    @RequestMapping(value = "aprobadoPlanDeTrabajo/{idContratista}/{idContratante}/{mes}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerAprobacionDePlanDeTrabajoContratisttas(@PathVariable int idContratista, @PathVariable int idContratante,@PathVariable String mes,@PathVariable int year){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.tieneAprobacionPlandeTrabajo(idContratista,idContratante,mes,year),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de traer los mensajes de los contratistas
     * @param idContratista identificador de contratistas
     * @param idContratante identificador de contratantes
     * @return Listado con todos los mensajes pertenecientes a los contratistas
     */
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

    /**
     * Método que se encarga de traer los mensajes del contratante
     * @param idContratante identificador del contratante
     * @return Listado con los mensajes que le pertenecen al contratantw
     */
    @RequestMapping(value = "mensajesContratante/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerMensajesDeContratantes( @PathVariable int idContratante){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDePlanesDeTrabajoBD.consultarMensajesPorContratante(idContratante),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que agrega la aprobación del inicio de actividades al contratante
     * @param aprobacion objeto con la aprobación
     * @return  ACCEPTED si la aprobación se registra
     */
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
    @RequestMapping(value ="mensajeContratante",method = RequestMethod.POST)
    public ResponseEntity<?> agregarMensajeContratante(@RequestBody Mensaje mensaje){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDePlanesDeTrabajoBD.agregarMensajeContratante(mensaje);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de agregar una actividad al plan de trabajo
     * @param planDeTrabajo objeto del plan de trabajo que se registrar en la base de datos
     * @return ACCEPTED si la actividad se registra
     */
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

    /**
     * Método que se encarga de actualizar el soporte de la actividad que registra el contratista
     * @param id identificador de la actividad al que pertenece el soporte
     * @param idContratista identificador del contratista quien registro la actividad
     * @param request Documento que se va registrar o actualizar
     * @return
     */
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
