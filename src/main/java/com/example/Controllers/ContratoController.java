package com.example.Controllers;

import com.example.Models.Contrato;
import com.example.Services.ManejoDeContratoBD;
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
 * Created by HSEQ on 13/06/2017.
 */
@RestController
@RequestMapping(value="/app/contratos")
public class ContratoController {
    @Autowired
    public ManejoDeContratoBD manejoDeContratoBD;

    /**
     * Métod que obtiene todos los contratos pertenecientesal contratante
     * @param idContratante identificador del contratante que desea consultar los contratos
     * @return
     */
    @RequestMapping(value = "/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerContratos(@PathVariable int idContratante) {

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

    /**
     * Método que obtiene todos los contratos en ejecución
     * @param idContratante identificador dle contratante al que pertencen los contratantes
     * @return Listado con todos los contratos pertencientes al contratante
     */
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
    /**
     * Método que obtiene todos los contratos en ejecución
     * @param idContratante identificador dle contratante al que pertencen los contratantes
     * @return Listado con todos los contratos pertencientes al contratante
     */
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

    /**
     * Método que se encarga de traer el detalle de un contrato a través de su nombre
     * @param nombreContrato nombre del contrato
     * @return el detalle del contrato en un objeto
     */
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

    /**
     * Método que se encarga de trar todos los contratos que se encuentran en una rango de fechas
     * @param fechaInicio rango de inicio de los contratos que se van a consultar
     * @param fechaFin rango de fin de los contratos que se requieren renuciar
     * @param idContratante identificador del contratante a quien pertenecen los contratos
     * @return Listado con los contratos pertencientes al rango y al contratante
     */
    @RequestMapping(value = "fecha/{fechaInicio}/{fechaFin}/{idContratante}", method = RequestMethod.GET)
    public ResponseEntity<?> porFecha(@PathVariable String fechaInicio, @PathVariable String fechaFin,@PathVariable int idContratante) {

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            Date parsed2 = (formatter.parse(fechaFin));
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            java.sql.Date sqlFin = new java.sql.Date(parsed2.getTime());
            return new ResponseEntity<>(manejoDeContratoBD.contratosPorFecha(sqlInicio, sqlFin,idContratante), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Metodo que se encarga de registrar un archivo en la base de datos
     * @param nombreContrato nombre del contrato que se va a registrar
     * @param fechaInicio feche de inicio del contrato
     * @param fechaFin fecha de fin del contrato
     * @param fechaInicioActividades Fecha de inicio de actividades del contrato
     * @param idContratante identificador del contratante
     * @param tipoContrato tipo de contrato
     * @param request con los documentos asociados al contrato
     * @return ACCEPTED si se registra el contrato
     */
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

    /**
     * Método que encarga de actualizar el rut del contrato
     * @param idContratante identificador del contratante
     * @param fechaInicio fehca de Inicio del Contrato
     * @param idContrato indentificador del contrato
     * @param request con el documento que se va actualizar
     * @return
     */
    @RequestMapping(value="rut/{idContratante}/{fechaInicio}/{idContrato}", method = RequestMethod.POST)
    public ResponseEntity<?>actualizarRut(@PathVariable int idContratante,@PathVariable String fechaInicio,@PathVariable int idContrato,
                                               MultipartHttpServletRequest request) {

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            //manejoDeContratoBD.agregarContrato(contrato);
            //org.springframework.web.multipart.MultipartHttpServletRequest
            Iterator<String> itr = request.getFileNames();
            Contrato nuevoContrato=new Contrato();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            nuevoContrato.setFechaInicio(sqlInicio);
            nuevoContrato.setIdContrato(idContrato);
            nuevoContrato.setIdContratante(idContratante);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                nuevoContrato.setFile(fileForDB);
                String fileName = fileForDB.getName();



            }
            manejoDeContratoBD.actualizarRut(nuevoContrato);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }
    /**
     * Método que encarga de actualizar el Camara de Comercio del contrato
     * @param idContratante identificador del contratante
     * @param fechaInicio fehca de Inicio del Contrato
     * @param idContrato indentificador del contrato
     * @param request con el documento que se va actualizar
     * @return
     */
    @RequestMapping(value="camaraDeComercio/{idContratante}/{fechaInicio}/{idContrato}", method = RequestMethod.POST)
    public ResponseEntity<?>actualizarCamaraDeComercio(@PathVariable int idContratante,@PathVariable String fechaInicio,@PathVariable int idContrato,
                                          MultipartHttpServletRequest request) {

        ResponseEntity a;
        try {
            Iterator<String> itr = request.getFileNames();
            Contrato nuevoContrato=new Contrato();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            nuevoContrato.setFechaInicio(sqlInicio);
            nuevoContrato.setIdContrato(idContrato);
            nuevoContrato.setIdContratante(idContratante);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                nuevoContrato.setFile(fileForDB);


            }
            manejoDeContratoBD.actualizarCamaraDeComercio(nuevoContrato);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
        return a;
    }
    /**
     * Método que encarga de actualizar la cedula del representante del contrato
     * @param idContratante identificador del contratante
     * @param fechaInicio fehca de Inicio del Contrato
     * @param idContrato indentificador del contrato
     * @param request con el documento que se va actualizar
     * @return
     */
    @RequestMapping(value="cedulaDelRepresentante/{idContratante}/{fechaInicio}/{idContrato}", method = RequestMethod.POST)
    public ResponseEntity<?>actualizarCedulaDelRepresentante(@PathVariable int idContratante,@PathVariable String fechaInicio,@PathVariable int idContrato,
                                                       MultipartHttpServletRequest request) {

        ResponseEntity a;
        try {
            Iterator<String> itr = request.getFileNames();
            Contrato nuevoContrato=new Contrato();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = formatter.parse(fechaInicio);
            java.sql.Date sqlInicio = new java.sql.Date(parsed.getTime());
            nuevoContrato.setFechaInicio(sqlInicio);
            nuevoContrato.setIdContrato(idContrato);
            nuevoContrato.setIdContratante(idContratante);
            while(itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                File fileForDB=convert(file);
                nuevoContrato.setFile(fileForDB);


            }
            manejoDeContratoBD.actualizarCedulaDelRepresentante(nuevoContrato);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
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