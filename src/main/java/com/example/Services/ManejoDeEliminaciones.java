package com.example.Services;

import com.example.Beans.AdministradorDeEliminaciones;
import com.example.DB.EliminarRequisitosDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by HSEQ on 01/08/2017.
 */
@Service
public class ManejoDeEliminaciones implements AdministradorDeEliminaciones {
    @Autowired
    public EliminarRequisitosDB eliminarRequisitosDB;
    @Override
    public void eliminarPrevioSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarPrevioSugerido(idRequisito, idContratante);
    }

    @Override
    public void eliminarPrevioExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarPrevioExtra(idRequisito, idContratante);
    }

    @Override
    public void eliminarEjecucionSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarEjecucionSugerida(idRequisito, idContratante);
    }

    @Override
    public void eliminarEjecucionExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
       eliminarRequisitosDB.eliminarEjecucionExtra(idRequisito, idContratante);
    }

    @Override
    public void eliminarFinalizacionSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarFinalizacionSugerido(idRequisito, idContratante);
    }

    @Override
    public void eliminarFinalizacionExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarFinalizacionExtra(idRequisito, idContratante);
    }

    @Override
    public void eliminarDinamicoPrevioSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarDinamicoPrevio(idRequisito, idContratante);
    }

    @Override
    public void eliminarDinamicoPrevioExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarDinamicoPrevioExtra(idRequisito, idContratante);
    }

    @Override
    public void eliminarDinamicoEjecucionSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarDinamicoEjecucion(idRequisito, idContratante);
    }

    @Override
    public void eliminarDinamicoEjecucionExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarDinamicoEjecucionExtra(idRequisito, idContratante);
    }

    @Override
    public void eliminarDinamicoFinalizacionSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarDinamicoFinalizacion(idRequisito, idContratante);
    }

    @Override
    public void eliminarDinamicoFinalizacionExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarDinamicoFinalizacionExtra(idRequisito, idContratante);
    }
}
