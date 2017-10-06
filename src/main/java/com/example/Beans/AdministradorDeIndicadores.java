package com.example.Beans;

import com.example.Models.Indicador;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 03/10/2017.
 */
public interface AdministradorDeIndicadores {
    public void insertarIndicador(Indicador indicador)throws SQLException,ClassNotFoundException;
    public List<Indicador> indicadoresPorContratista(int idContratista, int idContratante)throws SQLException,ClassNotFoundException;
    public List<Indicador> indicadoresPorContratistaMes(int idContratista, String mes,int year)throws SQLException,ClassNotFoundException;
    public List<Indicador> reportesPorMes(int idContratante, String mes,int year)throws SQLException,ClassNotFoundException;
    public List<Indicador> reportesPorYear(int idContratante, int year)throws SQLException,ClassNotFoundException;
}
