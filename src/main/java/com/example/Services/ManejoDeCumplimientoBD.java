package com.example.Services;

import com.example.Beans.AdministradorDeCumplimiento;
import com.example.DB.CumplimientoEjecucionDB;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 06/07/2017.
 */
@Service
public class ManejoDeCumplimientoBD implements AdministradorDeCumplimiento {
    @Autowired
    public CumplimientoEjecucionDB cumplimientoEjecucionDB;
    @Override
    public List<RequisitoObligatorio> requisitosCumplidosPreviosSugeridos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosCumplidosPreviosSugeridos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoObligatorio> requisitosNoCumplidosSugeridosPrevios(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosNoCumplidosSugeridosPrevios(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoObligatorio> requisitosCumplidosEjecucionSugeridos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosCumplidosEjecucionSugeridos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoObligatorio> requisitosNoCumplidosEjecucionSugeridos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosNoCumplidosEjecucionSugeridos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoObligatorio> requisitosCumplidosFinalizacionSugeridos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosCumplidosFinalizacionSugeridos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoObligatorio> requisitosNoCumplidosFinalizacionSugeridos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosNoCumplidosFinalizacionSugeridos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasPreviosCumplidos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosExtrasPreviosCumplidos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasPreviosNoCumplidos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosExtrasPreviosNoCumplidos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasEjecucionCumplidos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosExtrasEjecucionCumplidos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasEjecucionNoCumplidos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosExtrasEjecucionNoCumplidos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasFinalizacionCumplidos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosExtrasFinalizacionCumplidos(idFinalista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasFinalizacionNoCumplidos(int idFinalista, int idCategoria, int idContratante) throws SQLException, ClassNotFoundException {
        return cumplimientoEjecucionDB.requisitosExtrasFinalizacionNoCumplidos(idFinalista, idCategoria, idContratante);
    }
}
