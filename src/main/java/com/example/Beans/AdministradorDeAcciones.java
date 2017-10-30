package com.example.Beans;

import com.example.Models.Accion;
import com.example.Models.Cierre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 26/10/2017.
 */
public interface AdministradorDeAcciones {
    public void registrarAccion(Accion accion)throws SQLException,ClassNotFoundException,IOException;
    public void registrarOActualizarSoporte(Accion accion)throws SQLException,ClassNotFoundException,IOException;
    public void registrarCierre(Cierre cierre)throws SQLException,ClassNotFoundException;
    public boolean actividadIsClose(int idNoConformidad,int idContratista) throws SQLException, ClassNotFoundException;
    public List<Accion>traerAccionesPorContratista(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;
    public List<Accion>traerAccionesPorContratistaConRegistro(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;
    public List<Accion>traerAccionesPorContratistaSinRegistro(int idContratista, int idCausa)throws SQLException,ClassNotFoundException;
    public List<Cierre>traerNoConforCerradas(int idContratista)throws SQLException,ClassNotFoundException;
}
