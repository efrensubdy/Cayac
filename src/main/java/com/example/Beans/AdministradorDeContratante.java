package com.example.Beans;

import com.example.Models.Contratante;
import com.example.Models.Contratista;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 30/03/2017.
 */
public interface AdministradorDeContratante {
public void registrarContratante(Contratante contratante) throws SQLException, ClassNotFoundException;
public List<Contratante>obtenerContratantes() throws SQLException, ClassNotFoundException;
public List<Contratista>contratistaPorContratante(int idContratante, int idContrato) throws SQLException, ClassNotFoundException;public List<Contratista>contratistaPorCategoria( int idContrato,int idCategoria) throws SQLException, ClassNotFoundException;
public List<RequisitoObligatorio> requisitosCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;
public List<RequisitoObligatorio> requisitosNoCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;
public List<RequisitoExtra> requisitosExtrasCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;
public List<RequisitoExtra> requisitosExtrasNoCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException, ClassNotFoundException;

}
