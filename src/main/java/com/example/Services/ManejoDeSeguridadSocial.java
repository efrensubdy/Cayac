package com.example.Services;

import com.example.Beans.AdministradorDeSeguridadSocial;
import com.example.DB.SeguridadSocialBD;
import com.example.Models.SeguridadSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 28/09/2017.
 */
@Service
public class ManejoDeSeguridadSocial implements AdministradorDeSeguridadSocial {
    @Autowired
    public SeguridadSocialBD seguridadSocialBD;
    @Override
    public void agregarSeguridadSocial(SeguridadSocial seguridadSocial) throws SQLException, ClassNotFoundException,IOException {
        seguridadSocialBD.insertarSeguridadSocial(seguridadSocial);
    }
}