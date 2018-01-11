package com.example.Beans;

import com.example.Models.*;

import java.sql.SQLException;

/**
 * Interfaz encargada de la Gestión de la actualización de información del software
 */
public interface AdministradorDeActualizaciones {
    /**
     * Método que actualiza la información del contratista
     * @param contratista objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionContratista(Contratista contratista)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información del Indicador
     * @param indicador objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionIndicadorContratista(Indicador indicador)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información del Accidente
     * @param accidente objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionAccidenteContratista(Accidente accidente)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información del Estandar Minimo
     * @param estandarMinimo objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionEstandarContratista(EstandarMinimo estandarMinimo)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información de la Actividad del Plan de Trabajo
     * @param planDeTrabajo objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionPlanDeTrabajoContratista(PlanDeTrabajo planDeTrabajo)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información de la NoCoformidad
     * @param noConformidad objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionNoConformidadContratista(NoConformidad noConformidad)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información de la Causa
     * @param causa objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionCausaContratista(Causa causa)throws SQLException,ClassNotFoundException;

    /**
     * Método que actualiza la información de la Acción
     * @param accion objeto con la información que se va actualizar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizacionInformacionAccionContratista(Accion accion)throws SQLException,ClassNotFoundException;
}
