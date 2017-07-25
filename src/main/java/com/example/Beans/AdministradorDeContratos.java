package com.example.Beans;

import com.example.Models.Contrato;
import com.example.Models.DocumentoFinalizacion;
import com.example.Models.Imagenes;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 13/06/2017.
 */
public interface AdministradorDeContratos {
    public void agregarContrato(Contrato contrato)throws SQLException,ClassNotFoundException;
    public List<Contrato>obtenerContratos(int idContratante)throws SQLException,ClassNotFoundException;
    public List<Contrato>contratosPorFecha(java.sql.Date fechaInicio,java.sql.Date fechaFin)throws SQLException,ClassNotFoundException;
    public List<Contrato>contratosEjecucion()throws SQLException,ClassNotFoundException;
    public Contrato obtenerContratoporNombre(int nombreContrato)throws SQLException,ClassNotFoundException;
    public void insertarDocumento(Imagenes imagen)throws SQLException,ClassNotFoundException , IOException;

}
