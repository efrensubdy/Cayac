package com.example.Services;

import com.example.Beans.AdministradorDeRequisitosDinamicos;
import com.example.DB.RequisitosDinamicosDB;
import com.example.Models.Requisito;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 10/07/2017.
 */
@Service
public class ManejoDeRequisitosDinamicos implements AdministradorDeRequisitosDinamicos {
    @Autowired
    public RequisitosDinamicosDB requisitosDinamicosDB;

    @Override
    public List<Requisito> llenarDinamicosPreviosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.llenarRequisitosDinamicosPreviosSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> llenarDinamicosPreviosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.llenarRequisitosExtrasPrevios(idContratante, idCategoria);
    }

    @Override
    public List<Requisito> llenarDinamicosEjecucionSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.llenarRequisitosDinamicosEjecucionSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> llenarDinamicosEjecucionExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.llenarRequisitosExtrasEjecucion(idContratante, idCategoria);
    }

    @Override
    public List<Requisito> llenarDinamicosFinalizacionSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.llenarRequisitosDinamicosFinalizacionSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> llenarDinamicosFinalizacionExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.llenarRequisitosExtrasFinalizacion(idContratante, idCategoria);
    }

    @Override
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoPrevioSugerido) throws SQLException, ClassNotFoundException {
        requisitosDinamicosDB.insertarDinamicoPrevioSugerido(nuevoPrevioSugerido);
    }

    @Override
    public void insertarPrevioExtra(RequisitoExtra nuevoPrevioExtra) throws SQLException, ClassNotFoundException {
        requisitosDinamicosDB.insertarDinamicoPrevioExtra(nuevoPrevioExtra);
    }

    @Override
    public void insertarEjecucionSugerido(RequisitoObligatorio nuevoEjecucionSugerido) throws SQLException, ClassNotFoundException {
        requisitosDinamicosDB.insertarDinamicoEjecucionSugerido(nuevoEjecucionSugerido);
    }

    @Override
    public void insertarEjecucionExtra(RequisitoExtra nuevoEjecucionExtra) throws SQLException, ClassNotFoundException {
        requisitosDinamicosDB.insertarDinamicoEjecucionExtra(nuevoEjecucionExtra);
    }

    @Override
    public void insertarFinalizacionSugerido(RequisitoObligatorio nuevoFinalizacionSugerido) throws SQLException, ClassNotFoundException {
       requisitosDinamicosDB.insertarDinamicoFinalizacionSugerido(nuevoFinalizacionSugerido);
    }

    @Override
    public void insertarFinalizacionExtra(RequisitoExtra nuevoFinalizacionExtra) throws SQLException, ClassNotFoundException {
       requisitosDinamicosDB.insertarDinamicoFinalizacionExtra(nuevoFinalizacionExtra);
    }

    @Override
    public List<RequisitoObligatorio> previosDinamicosDefinitivosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.requisitosDinamicosPreviosDefinitivosSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> ejecucionDinamicosDefinitivosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.requisitosDinamicosEjecucionDefinitivosSugeridos(idContratante, idCategoria) ;
    }

    @Override
    public List<RequisitoObligatorio> finalizacionDinamicosDefinitivosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.requisitosDinamicosFinalizacionDefinitivosSugeridos(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> previosDinamicosDefinitivosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.requisitosDinamicosPreviosDefinitivosExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> ejecucionDinamicosDefinitivosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.requisitosDinamicosEjecucionDefinitivosExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> finalizacionDinamicosDefinitivosExtras(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.requisitosDinamicosFinalizacionDefinitivosExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> estadoPreviosSugeridosDinamicos(int idFinalista, int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.estadoPreviosSugeridosDinamicos(idFinalista, idCategoria,idContratante);
    }

    @Override
    public List<RequisitoObligatorio> estadoEjecucionSugeridosDinamicos(int idFinalista, int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.estadoEjecucionSugeridosDinamicos(idFinalista, idCategoria,idContratante);
    }

    @Override
    public List<RequisitoObligatorio> estadoFinalizacionSugeridosDinamicos(int idFinalista, int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.estadoFinalizacionSugeridosDinamicos(idFinalista, idCategoria,idContratante);
    }

    @Override
    public List<RequisitoExtra> estadoPreviosExtrasDinamicos(int idFinalista, int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.estadoPreviosExtrasDinamicos(idFinalista, idCategoria,idContratante);
    }

    @Override
    public List<RequisitoExtra> estadoEjecucionExtrasDinamicos(int idFinalista, int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.estadoEjecucionExtrasDinamicos(idFinalista, idCategoria,idContratante);
    }

    @Override
    public List<RequisitoExtra> estadoFinalizacionExtrasDinamicos(int idFinalista, int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return requisitosDinamicosDB.estadoFinalizacionExtrasDinamicos(idFinalista, idCategoria,idContratante);
    }
}
