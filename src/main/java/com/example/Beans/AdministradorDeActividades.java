package com.example.Beans;

import com.example.Models.Actividad;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 12/07/2017.
 */
public interface AdministradorDeActividades {
    public void insertarActividadPreviaSugerida(Actividad actividad)throws SQLException,ClassNotFoundException;
    public List<Actividad>traerActividadesPrevias(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException;
    public void insertarActividadPreviaExtra(Actividad actividad)throws SQLException,ClassNotFoundException;
    public List<Actividad>traerActividadesExtra(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException;
    public void insertarActividadEjecucionSugerida(Actividad actividad)throws SQLException,ClassNotFoundException;
    public List<Actividad>traerActividadesEjecucionSugerida(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException;
    public void insertarActividadEjecucionExtra(Actividad actividad)throws SQLException,ClassNotFoundException;
    public List<Actividad>traerActividadesEjecucionExtra(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException;
    public void insertarActividadFinalizacionSugerida(Actividad actividad)throws SQLException,ClassNotFoundException;
    public List<Actividad>traerActividadesFinalizacionSugerida(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException;
    public void insertarActividadFinalizacionExtra(Actividad actividad)throws SQLException,ClassNotFoundException;
    public List<Actividad>traerActividadesFinalizacionExtra(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException;
}
