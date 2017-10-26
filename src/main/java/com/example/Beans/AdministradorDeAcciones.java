package com.example.Beans;

import com.example.Models.Accion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 26/10/2017.
 */
public interface AdministradorDeAcciones {
    public void registrarAccion(Accion accion)throws SQLException,ClassNotFoundException,IOException;
    public List<Accion>traerAccionesPorContratista(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;

}
