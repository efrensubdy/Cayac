package com.example.Beans;

import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 06/07/2017.
 */
public interface AdministradorDeCumplimiento {
    public List<RequisitoObligatorio> requisitosCumplidosPreviosSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio> requisitosNoCumplidosSugeridosPrevios(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio> requisitosCumplidosEjecucionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio> requisitosNoCumplidosEjecucionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio> requisitosCumplidosFinalizacionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio> requisitosNoCumplidosFinalizacionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasPreviosCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasPreviosNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasEjecucionCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasEjecucionNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasFinalizacionCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra> requisitosExtrasFinalizacionNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
}
