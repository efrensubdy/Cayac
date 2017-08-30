package com.example.Services;

import com.example.Beans.AdministradorDeCumplimientoDinamico;
import com.example.DB.CumplimientoDinamicoDB;
import com.example.Models.DinamicoCumplido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 30/08/2017.
 */
@Service
public class ManejoDeCumplimientoDB implements AdministradorDeCumplimientoDinamico {

    @Autowired
    public CumplimientoDinamicoDB cumplimientoDinamicoDB;


    @Override
    public List<DinamicoCumplido> cumplidosDinamicosPrevios(int idCategoria, int idContratante, int idFinalista) throws SQLException, ClassNotFoundException {
        return cumplimientoDinamicoDB.dinamicosCumplidos(idCategoria, idContratante, idFinalista);
    }

    @Override
    public List<DinamicoCumplido> noCumplidosDinamicosPrevios(int idCategoria, int idContratante, int idFinalista) throws SQLException, ClassNotFoundException {
        return cumplimientoDinamicoDB.dinamicosNoCumplidos(idCategoria, idContratante, idFinalista);
    }
}
