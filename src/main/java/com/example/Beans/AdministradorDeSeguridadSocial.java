package com.example.Beans;

import com.example.Models.SeguridadSocial;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 28/09/2017.
 */
public interface AdministradorDeSeguridadSocial {
    public void agregarSeguridadSocial(SeguridadSocial seguridadSocial) throws SQLException, ClassNotFoundException,IOException;
    public List<SeguridadSocial>traerSeguridadSocialPorContratista(int idContratista)throws SQLException,ClassNotFoundException;

}
