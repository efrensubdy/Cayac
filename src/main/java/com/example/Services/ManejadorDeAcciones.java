package com.example.Services;

import com.example.Beans.AdministradorDeAcciones;
import com.example.DB.AccionDB;
import com.example.Models.Accion;
import com.example.Models.Cierre;
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
    public void registrarCierre(Cierre cierre) throws SQLException, ClassNotFoundException {
        accionDB.registrarCierre(cierre);
    }

    @Override
    public boolean actividadIsClose(int idNoConformidad, int idContratista) throws SQLException, ClassNotFoundException {
        return accionDB.consultarRegistroDeCierre(idNoConformidad, idContratista);
    }

    @Override
    public List<Accion> traerAccionesPorContratista(int idContratista, int idCausa) throws SQLException, ClassNotFoundException {
        return accionDB.traerAccionesPorCausa(idContratista,idCausa);
    }

    @Override
    public List<Accion> traerAccionesPorContratistaConRegistro(int idContratista, int idCausa) throws SQLException, ClassNotFoundException {
        return accionDB.traerAccionesConRegistro(idContratista, idCausa);
    }

    @Override
    public List<Accion> traerAccionesPorContratistaSinRegistro(int idContratista, int idCausa) throws SQLException, ClassNotFoundException {
        return accionDB.traerAccionesSinRegistro(idContratista,idCausa);
    }

    @Override
    public List<Cierre> traerNoConforCerradas(int idContratista) throws SQLException, ClassNotFoundException {
        return accionDB.actividadesCerradas(idContratista);
    }

    @Override
    public List<Cierre> traerNoConforCerradas(int idContratista, int idAuditaria) throws SQLException, ClassNotFoundException {
        return accionDB.actividadesCerradas(idContratista, idAuditaria);
    }
}
