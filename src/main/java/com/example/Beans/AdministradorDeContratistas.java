/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Beans;

import com.example.Models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HSEQ
 * Interface que define todos los metodos que permiten administrar los contratistas
 */
public interface AdministradorDeContratistas {
    public void registrarContratista(Contratista con) throws SQLException, ClassNotFoundException, IOException;
    public FechaLimite getFechaPorContratista(int idContrato,int idCategoria)throws SQLException,ClassNotFoundException;
    public List<FechaLimite>fechasContratante(int idContratante)throws SQLException,ClassNotFoundException;
    public List<Contratista> obtenerContratistas() throws SQLException, ClassNotFoundException;
    public void registrarImagen(Imagenes imagen)throws SQLException, ClassNotFoundException, IOException;
    public void registrarDocumento(Documento documento)throws SQLException, ClassNotFoundException, IOException;
    public void registrarFechaLimite(FechaLimite fechaLimite)throws SQLException,ClassNotFoundException;
    public String extraertipo(int idContratista, int idRequisitoSugerido)throws  SQLException, ClassNotFoundException;
    public List<RequisitoObligatorio>estadoDeRequisitos(int idContratante,int idCategoria,int idContratista)throws SQLException,ClassNotFoundException;
    public List<RequisitoExtra>estadoExtras(int idContratante,int idCategoria,int idContratista)throws  SQLException,ClassNotFoundException;
    public List<ActividadEconomica>obtenerActividadesEconomicas()throws SQLException,ClassNotFoundException;

}
