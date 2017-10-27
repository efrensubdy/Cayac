package com.example.Services;

import com.example.Beans.AdministradorDeAcciones;
import com.example.DB.AccionDB;
import com.example.Models.Accion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 26/10/2017.
 */
@Service
public class ManejadorDeAcciones implements AdministradorDeAcciones {
    @Autowired
    public AccionDB accionDB;
    @Override
    public void registrarAccion(Accion accion) throws SQLException, ClassNotFoundException,IOException {
        accionDB.insertarAccion2(accion);
    }

    @Override
    public void registrarOActualizarSoporte(Accion accion) throws SQLException, ClassNotFoundException, IOException {
        accionDB.insertarAccion(accion);
    }

    @Override
    public List<Accion> traerAccionesPorContratista(int idContratista, int idCausa) throws SQLException, ClassNotFoundException {
        return accionDB.traerAccionesPorCausa(idContratista,idCausa);
    }
}
