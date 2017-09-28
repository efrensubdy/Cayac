package com.example.Beans;

import com.example.Models.SeguridadSocial;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 28/09/2017.
 */
public interface AdministradorDeSeguridadSocial {
    public void agregarSeguridadSocial(SeguridadSocial seguridadSocial) throws SQLException, ClassNotFoundException,IOException;


}
