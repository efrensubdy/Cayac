package com.example.Services;

import com.example.Beans.AdministradorDeActividades;
import com.example.DB.ActividadesDB;
import com.example.Models.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 12/07/2017.
 */
@Service
public class ManejoDeActividades implements AdministradorDeActividades {

    @Autowired
    public ActividadesDB actividadesDB;


    @Override
    public void insertarActividadPreviaSugerida(Actividad actividad) throws SQLException, ClassNotFoundException {
        actividadesDB.agregarActividadPreviaSugerida(actividad);
    }

    @Override
    public List<Actividad> traerActividadesPrevias(int idFinalista,int idRequisito) throws SQLException, ClassNotFoundException {
        return actividadesDB.traeactividadesPreviasSugeridas(idFinalista, idRequisito);
    }

    @Override
    public void insertarActividadPreviaExtra(Actividad actividad) throws SQLException, ClassNotFoundException {
        actividadesDB.agregarActividadPreviaExtra(actividad);
    }

    @Override
    public List<Actividad> traerActividadesExtra(int idFinalista,int idRequisito) throws SQLException, ClassNotFoundException {
        return actividadesDB.traeactividadesPreviasExtras(idFinalista, idRequisito);
    }

    @Override
    public void insertarActividadEjecucionSugerida(Actividad actividad) throws SQLException, ClassNotFoundException {
        actividadesDB.agregarActividadEjecucionSugerida(actividad);
    }

    @Override
    public List<Actividad> traerActividadesEjecucionSugerida(int idFinalista,int idRequisito) throws SQLException, ClassNotFoundException {
        return actividadesDB.traeactividadesEjucionSugeridas(idFinalista, idRequisito);
    }

    @Override
    public void insertarActividadEjecucionExtra(Actividad actividad) throws SQLException, ClassNotFoundException {
        actividadesDB.agregarActividadEjecucionExtra(actividad);
    }

    @Override
    public List<Actividad> traerActividadesEjecucionExtra(int idFinalista,int idRequisito) throws SQLException, ClassNotFoundException {
        return actividadesDB.traeactividadesEjucionExtras(idFinalista, idRequisito);
    }

    @Override
    public void insertarActividadFinalizacionSugerida(Actividad actividad) throws SQLException, ClassNotFoundException {
        actividadesDB.agregarActividadFinalizacionSugerido(actividad);
    }

    @Override
    public List<Actividad> traerActividadesFinalizacionSugerida(int idFinalista,int idRequisito) throws SQLException, ClassNotFoundException {
        return actividadesDB.traeactividadesFinalizacionSugeridos(idFinalista, idRequisito);
    }

    @Override
    public void insertarActividadFinalizacionExtra(Actividad actividad) throws SQLException, ClassNotFoundException {
        actividadesDB.agregarActividadFinalizacionExtra(actividad);
    }

    @Override
    public List<Actividad> traerActividadesFinalizacionExtra(int idFinalista,int idRequisito) throws SQLException, ClassNotFoundException {
        return  actividadesDB.traeactividadesFinalizacionExtras(idFinalista, idRequisito);
    }
}
