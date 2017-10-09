package com.example.Services;

import com.example.Beans.AdministradorDeIndicadores;
import com.example.DB.IndicadorDB;
import com.example.Models.Contratista;
import com.example.Models.Indicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 03/10/2017.
 */
@Service
public class ManejadorDeIndicadores implements AdministradorDeIndicadores {
    @Autowired
    public IndicadorDB indicadorDB;


    @Override
    public void insertarIndicador(Indicador indicador) throws SQLException, ClassNotFoundException {
        indicadorDB.insertarIndicador(indicador);
    }

    @Override
    public List<Indicador> indicadoresPorContratista(int idContratista, int idContratante) throws SQLException, ClassNotFoundException {
        return indicadorDB.traerIndicadoresPorFinalista(idContratista, idContratante);
    }

    @Override
    public List<Indicador> indicadoresPorContratistaMes(int idContratista, String mes,int year) throws SQLException, ClassNotFoundException {
        return indicadorDB.indicadoresPorMes(idContratista,mes,year);
    }

    @Override
    public List<Indicador> reportesPorMes(int idContratante, String mes,int year) throws SQLException, ClassNotFoundException {
        return indicadorDB.reportePorMes(idContratante, mes, year);
    }

    @Override
    public List<Indicador> reportesPorYear(int idContratante, int year) throws SQLException, ClassNotFoundException {
        return indicadorDB.reportePorAño(idContratante, year);
    }

    @Override
    public List<Contratista> sinRegistroDeIndicador(int idContatante, String mes, int year) throws SQLException, ClassNotFoundException {
        return indicadorDB.sinRegistroDeIndicador(idContatante, mes, year);
    }
}
