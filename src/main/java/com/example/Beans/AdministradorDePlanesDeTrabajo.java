package com.example.Beans;

import com.example.Models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 12/09/2017.
 */
public interface AdministradorDePlanesDeTrabajo {
    public void agregarPlanDeTrabajo(PlanDeTrabajo plan)throws SQLException,ClassNotFoundException;
    public void agregarAprobacion(Aprobacion aprobacion)throws SQLException,ClassNotFoundException;
    public void agregarAprobaciondePlanTrabajo(Aprobacion aprobacion)throws SQLException,ClassNotFoundException;
    public void agregarMensaje(Mensaje mensaje)throws SQLException,ClassNotFoundException;
    public void actualizarSoporte(Documento doc)throws SQLException,ClassNotFoundException,IOException;
    public List<PlanDeTrabajo>traerActividadesPorContratista(int idContratista,String mes)throws SQLException,ClassNotFoundException;
    public List<PlanDeTrabajo>traerActividadesPorContratistaConSoporte(int idContratista,String mes)throws SQLException,ClassNotFoundException;
    public List<PlanDeTrabajo>traerActividadesPorContratistaSinSoporte(int idContratista,String mes)throws SQLException,ClassNotFoundException;
    public List<Mensaje>consultarMensajesPorContratista(int idContratista,int idContratante)throws SQLException,ClassNotFoundException;
    public List<Contratista>pendientesSinSoporte(int idContratante,String mes) throws SQLException,ClassNotFoundException;
    public List<Contratista>sinRegistro(int idContratante) throws SQLException,ClassNotFoundException;
    public boolean tieneAprobacion(int idContratista,int idContratante)throws SQLException,ClassNotFoundException;
    public boolean tieneAprobacionPlandeTrabajo(int idContratista,int idContratante,String mes)throws SQLException,ClassNotFoundException;


}
