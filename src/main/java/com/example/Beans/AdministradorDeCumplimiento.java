package com.example.Beans;

import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 06/07/2017.
 * Interface que define todos los metodos que permiten administrar el cumpimiento
 */
public interface AdministradorDeCumplimiento {
    public List<RequisitoObligatorio> requisitosCumplidosPreviosSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoObligatorio> requisitosNoCumplidosSugeridosPrevios(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasPreviosCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>requisitosExtrasPreviosNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException;

}
