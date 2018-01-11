package com.example.Beans;

import com.example.Models.Contrato;
import com.example.Models.Imagenes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 13/06/2017.
 * Interface que define todos los metodos que permiten administrar los contratos
 */
public interface AdministradorDeContratos {
    /**
     * Método a que registra un contrato en la base de datos
     * @param contrato objeto con la información que se desea registrar en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void agregarContrato(Contrato contrato)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método que actualiza al Rut del contrato
     * @param contrato objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void actualizarRut(Contrato contrato)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método que actualiza al Camara de Comercio del contrato
     * @param contrato objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void actualizarCamaraDeComercio(Contrato contrato)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método que actualiza la cedula del Representante del contrato
     * @param contrato
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void actualizarCedulaDelRepresentante(Contrato contrato)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método que obtiene todos los contratos pertenecientes al contratante
     * @param idContratante identificador del contratante
     * @return Listado con los contratos pertenecientes al contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contrato>obtenerContratos(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     *  Método que obtiene los contratos que pertenecen al contratnate dentro de un rango de fechas
     * @param fechaInicio fecha de inicio del contrato
     * @param fechaFin fecha de fin del contrato
     * @param idContratante identificador de contrantante al que pertenecen los contratos
     * @return Listado de contratos que pertenecen al rango y al contratante indicdo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contrato>contratosPorFecha(java.sql.Date fechaInicio,java.sql.Date fechaFin,int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método que obtiene los contratos
     * @param idContratante
     * @return Listado con los Contratos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contrato>contratosEjecucion(int idContratante)throws SQLException,ClassNotFoundException;
    /**
     * Método que obtiene los contratos
     * @param idContratante
     * @return Listado con los Contratos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contrato>contratosEnEjecucion(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método que obtiene un contrato a través del Nombre
     * @param nombreContrato
     * @return obtiene el contrato encapsulado en objeto
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Contrato obtenerContratoporNombre(int nombreContrato)throws SQLException,ClassNotFoundException;
    public void insertarDocumento(Imagenes imagen)throws SQLException,ClassNotFoundException , IOException;

}
