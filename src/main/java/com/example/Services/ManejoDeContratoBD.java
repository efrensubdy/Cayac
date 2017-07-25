package com.example.Services;

import com.example.Beans.AdministradorDeContratos;
import com.example.DB.ContratanteDB;
import com.example.Models.Contrato;
import com.example.Models.Imagenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 13/06/2017.
 */
@Service
public class ManejoDeContratoBD implements AdministradorDeContratos {
    @Autowired
    public ContratanteDB contratanteDB;
    @Override
    public void agregarContrato(Contrato contrato) throws SQLException, ClassNotFoundException {
        contratanteDB.nuevoContrato(contrato);
    }

    @Override
    public List<Contrato> obtenerContratos(int idContratante) throws SQLException, ClassNotFoundException {
        return contratanteDB.consultarContratos(idContratante);
    }

    @Override
    public List<Contrato> contratosPorFecha(Date fechaInicio, Date fechaFin) throws SQLException, ClassNotFoundException {
        return contratanteDB.contratosPorFecha(fechaInicio, fechaFin);
    }

    @Override
    public List<Contrato> contratosEjecucion() throws SQLException, ClassNotFoundException {
        return contratanteDB.consultarContratosEjecucion();
    }

    @Override
    public Contrato obtenerContratoporNombre(int nombreContrato) throws SQLException, ClassNotFoundException {
        return contratanteDB.contratoporNombre(nombreContrato);
    }

    @Override
    public void insertarDocumento(Imagenes imagen) throws SQLException, ClassNotFoundException, IOException {
       contratanteDB.insertarDocumentoContrato(imagen);
    }
}
