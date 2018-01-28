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
@RequestMapping(value="/app/login/contratante")
public class LoginContratanteController {
    @Autowired
    private ManejoDeUsuariosBD manejoDeUsuariosBD;
    public boolean bandera;

    public ManejoDeUsuariosBD getManejoDeUsuariosBD() {
        return manejoDeUsuariosBD;
    }

    public void setManejoDeUsuariosBD(ManejoDeUsuariosBD manejoDeUsuariosBD) {
        this.manejoDeUsuariosBD = manejoDeUsuariosBD;
    }


    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * Método que se encarga del inicio de sesión del contratante
     * @param email correo con el que se va iniciar la sesión
     * @param password contraseña con la que va iniciar la sesión
     * @return objeto con el que inica la sesión
     */
    @RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> loginContratante(@PathVariable String email,@PathVariable  String password){

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            bandera=manejoDeUsuariosBD.loginContratante(email, password);
            return new ResponseEntity<>(bandera,HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Método que se encarga de traer el identificador de un contratante
     * @param email correo con el que se consultar el identificador
     * @param password con el que se consultar el identificador
     * @return el identificador del contratante
     */
    @RequestMapping(value = "id/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> geIdContratante(@PathVariable String email,@PathVariable  String password){

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(manejoDeUsuariosBD.getIdContratante(email,password),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Método que se encarga de traer el objeto con el detalle del contratante
     * @param email correo con el que se consultar el el detalle
     * @param password con el que se consultar el identificador
     * @return el objeto con el detalle del contratante
     */
    @RequestMapping(value = "categoria/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> getContratante(@PathVariable String email,@PathVariable  String password){

        ResponseEntity a;
        try {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(manejoDeUsuariosBD.getUsuario2(email, password),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Método con el se actualiza la contraseña del contratante
     * @param user usuario con la información que se va a acutalizar
     * @return  ACCEPTED si se actualiza la contraseña
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>actualizarContraseña(@RequestBody Usuario user){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            manejoDeUsuariosBD.actualizarContraseñaContratante(user.getIdContratante(),user.getPassword());
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
