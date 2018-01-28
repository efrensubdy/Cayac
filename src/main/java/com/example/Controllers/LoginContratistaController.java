package com.example.Controllers;

import com.example.Models.Usuario;
import com.example.Services.ManejoDeUsuariosBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HSEQ on 04/04/2017.
 */
@RestController
@RequestMapping(value="/app/login/contratista")
public class LoginContratistaController {
    @Autowired
    private ManejoDeUsuariosBD manejoDeUsuariosBD;

    public ManejoDeUsuariosBD getManejoDeUsuariosBD() {
        return manejoDeUsuariosBD;
    }

    public void setManejoDeUsuariosBD(ManejoDeUsuariosBD manejoDeUsuariosBD) {
        this.manejoDeUsuariosBD = manejoDeUsuariosBD;
    }

    /**
     * Método que se encarga del inicio de sesión del contratista
     * @param email correo con el que se va iniciar la sesión
     * @param password contraseña con la que va iniciar la sesión
     * @return objeto con el que inica la sesión
     */
    @RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> loginContratista(@PathVariable String email, @PathVariable  String password){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeUsuariosBD.loginContratista(email,password), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    /**
     * Método que se encarga de traer el identificador de un contratista
     * @param email correo con el que se consultar el identificador
     * @param password con el que se consultar el identificador
     * @return el identificador del contratista
     */
    @RequestMapping(value = "id/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> geIdContratista(@PathVariable String email,@PathVariable  String password){

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(manejoDeUsuariosBD.getIdContratista(email, password),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
        }

    }
    /**
     * Método que se encarga de traer el objeto con el detalle del contratista
     * @param email correo con el que se consultar el  detalle del contratista
     * @param password con el que se consultar el identificador
     * @return el objeto con el detalle del contratista
     */
    @RequestMapping(value = "categoria/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> getContratista(@PathVariable String email,@PathVariable  String password){

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(manejoDeUsuariosBD.getUsuario(email, password),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Método que se encarga de traer los requisitos aplicados por el contratante
     * @param idContratante identificador del contratante que aplica los requistos
     * @param idCategoria identificador de la categoria que se le aplicaron los requisitos
     * @return Listado con los requisitos
     */
    @RequestMapping(value="{idContratante}/{idCategoria}/requisitos",method = RequestMethod.GET)
    public ResponseEntity<?>obtenerSugeridos(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeUsuariosBD.getRequisitosSugeridos(idContratante, idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    /**
     * Método que se encarga de traer los requisitos extras aplicados por el contratante
     * @param idContratante identificador del contratante que aplica los requistos
     * @param idCategoria identificador de la categoria que se le aplicaron los requisitos
     * @return listado con los requisitos
     */
    @RequestMapping(value="{idContratante}/{idCategoria}/extras",method = RequestMethod.GET)
    public ResponseEntity<?>obtenerExtras(@PathVariable int idContratante,@PathVariable int idCategoria){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(manejoDeUsuariosBD.getRequisitosExtras(idContratante, idCategoria),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }
    /**
     * Método con el se actualiza la contraseña del contratista
     * @param user usuario con la información que se va a acutalizar
     * @return  ACCEPTED si se actualiza la contraseña
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>actualizarContraseña(@RequestBody Usuario user){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeUsuariosBD.actualizarContraseñaContratista(user.getIdContratista(),user.getPassword());
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }


}
