package com.example.Services;

import com.example.Beans.AdministradorDeFinalistas;
import com.example.DB.FinalistDB;
import com.example.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 07/06/2017.
 */
@Service
public class ManejoDeFinalistaBD implements AdministradorDeFinalistas{
    @Autowired
    public FinalistDB finalistDB;
    @Override
    public void InsertarFinalista(Finalista finalista) throws SQLException, ClassNotFoundException {
        finalistDB.insertarFinalista(finalista);
    }

    @Override
    public void InsertarManual(Contratista con) throws SQLException, ClassNotFoundException, IOException {
        finalistDB.registroManual(con);
    }

    @Override
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoPrevioSugerido) throws SQLException, ClassNotFoundException {
        finalistDB.insertarPrevioSugerido(nuevoPrevioSugerido);
    }

    @Override
    public void insertarPrevioExtra(RequisitoExtra nuevoPrevioExtra) throws SQLException, ClassNotFoundException {
        finalistDB.insertarPrevioExtra(nuevoPrevioExtra);
    }

    @Override
    public void insertarEjecucionSugerido(RequisitoObligatorio nuevoEjecucionSugerido) throws SQLException, ClassNotFoundException {
        finalistDB.insertarEjecucionSugerido(nuevoEjecucionSugerido);
    }

    @Override
    public void insertarEjecucionExtra(RequisitoExtra nuevoEjecucionExtra) throws SQLException, ClassNotFoundException {
       finalistDB.insertarEjecucionExtra(nuevoEjecucionExtra);
    }

    @Override
    public void insertarFinalizacionSugerido(RequisitoObligatorio nuevoFinalizacionSugerido) throws SQLException, ClassNotFoundException {
       finalistDB.insertarFinalizacionSugerido(nuevoFinalizacionSugerido);
    }

    @Override
    public void insertarFinalizacionExtra(RequisitoExtra nuevoFinalizacionExtra) throws SQLException, ClassNotFoundException {
        finalistDB.insertarFinalizacionExtra(nuevoFinalizacionExtra);
    }

    @Override
    public List<Contratista> posiblesFinalistas(int idContratante,int idContrato) throws SQLException, ClassNotFoundException {
        System.out.println(idContratante);
        System.out.println(idContrato);
        return finalistDB.consultarNoFinalistas(idContratante,idContrato);
    }

    @Override
    public List<Contratista> finalistas(int idContratante,int idContrato) throws SQLException, ClassNotFoundException {
        return finalistDB.consultarFinalistas(idContratante,idContrato);
    }

    @Override
    public List<Requisito> llenarPreviosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.llenarRequisitosPrevios(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> llenarPreviosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.llenarRequisitosExtrasPrevios(idContratante, idCategoria);
    }

    @Override
    public List<Requisito> llenarEjecucionSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.llenarRequisitosEjecucion(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> llenarEjecucionExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.llenarRequisitosExtrasEjecucion(idContratante, idCategoria);
    }

    @Override
    public List<Requisito> llenarFinalizacionSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.llenarRequisitosfinalizacion(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> llenarFinalizacionExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.llenarRequisitosExtrasFinalizacion(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> previosDefinitivosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.requisitosPreviosDefinitivosSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> ejecucionDefinitivosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.requisitosEjecucionDefinitivosSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> finalizacionDefinitivosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.requisitosFinalizacionDefinitivosSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> previosDefinitivosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.requisitosPreviosDefinitivosExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> ejecucionDefinitivosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.requisitosEjecucionDefinitivosExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> finalizacionDefinitivosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return finalistDB.requisitosFinalizacionDefinitivosExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> estadoPreviosSugeridos(int idContratante, int idCategoria ,int idFinalista) throws SQLException, ClassNotFoundException {
        return finalistDB.estadoDeRequisitosPreviosSugeridos(idContratante, idCategoria,idFinalista);
    }

    @Override
    public List<RequisitoObligatorio> estadoEjecucionSugeridos(int idContratante, int idCategoria,int idFinalista) throws SQLException, ClassNotFoundException {
        return finalistDB.estadoDeRequisitosEjecucionSugeridos(idContratante, idCategoria, idFinalista);
    }

    @Override
    public List<RequisitoObligatorio> estadoFinalizacionSugeridos(int idContratante, int idCategoria ,int idFinalista) throws SQLException, ClassNotFoundException {
        return finalistDB.estadoDeRequisitosFinalizacionSugeridos(idContratante, idCategoria, idFinalista);
    }

    @Override
    public List<RequisitoExtra> estadoPreviosExtras(int idContratante, int idCategoria,int idFinalista) throws SQLException, ClassNotFoundException {
        return finalistDB.estadoRequisitosPreviosExtras(idContratante, idCategoria,idFinalista);
    }

    @Override
    public List<RequisitoExtra> estadoEjecucionExtras(int idContratante, int idCategoria,int idFinalista) throws SQLException, ClassNotFoundException {
        return finalistDB.estadoRequisitoseEjecucionExtras(idContratante, idCategoria, idFinalista);
    }

    @Override
    public List<RequisitoExtra> estadoFinalizacionExtras(int idContratante, int idCategoria,int idFinalista) throws SQLException, ClassNotFoundException {
        return finalistDB.estadoRequisitosFinalizacionExtras(idContratante, idCategoria,idFinalista);
    }

}
