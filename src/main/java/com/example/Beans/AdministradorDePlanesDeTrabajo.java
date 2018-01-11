package com.example.Beans;

import com.example.Models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 12/09/2017.
 */
public interface AdministradorDePlanesDeTrabajo {
    /**
     * Método para Registrar plan de Trabajo en la base de datos
     * @param plan objeto con la información de la actividad a registrar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void agregarPlanDeTrabajo(PlanDeTrabajo plan)throws SQLException,ClassNotFoundException;

    /**
     * Método para registrar la aprobación par iniciar el plan de trabajo del  contratista
     * @param aprobacion objeto con la información de la aprobación
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void agregarAprobacion(Aprobacion aprobacion)throws SQLException,ClassNotFoundException;

    /**
     * Método para establecer la aprobacion del  plan de trabajo
     * @param aprobacion objeto con la información
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void agregarAprobaciondePlanTrabajo(Aprobacion aprobacion)throws SQLException,ClassNotFoundException;

    /**
     * Método para registrar un mensaje al contratista
     * @param mensaje objeto con la información del mensake
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void agregarMensaje(Mensaje mensaje)throws SQLException,ClassNotFoundException;
    /**
     * Método para registrar un mensaje al contratante
     * @param mensaje objeto con la información del mensake
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void agregarMensajeContratante(Mensaje mensaje)throws SQLException,ClassNotFoundException;

    /**
     * Método para agregar el soporte de la actividad
     * @param doc documento que se va agregar en el repositorio y cuyo registro quedará en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void actualizarSoporte(Documento doc)throws SQLException,ClassNotFoundException,IOException;

    /**
     * Método para traer todas las actividades por contratista
     * @param idContratista identificador de contratista
     * @param mes mes en el que se quieren las actividades
     * @param year año en el que se quieren las actividades
     * @return Listado con las actividades del mes y el año específico
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<PlanDeTrabajo>traerActividadesPorContratista(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer todas actividades de contratistas con soporte
     * @param idContratista identificador de contratistas
     * @param mes mes para las notificaciones
     * @param year año para las notificaciones
     * @return Listado de actividades con soporte
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<PlanDeTrabajo>traerActividadesPorContratistaConSoporte(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException;
    /**
     * Método para traer todas actividades de contratistas sin soporte
     * @param idContratista identificador de contratistas
     * @param mes mes para las notificaciones
     * @param year año para las notificaciones
     * @return Listado de actividades sin soporte
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<PlanDeTrabajo>traerActividadesPorContratistaSinSoporte(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException;

    /**
     * Método para consultar los mensajes de Contratista
     * @param idContratista identificador de contratista
     * @param idContratante identificdor de contratante al cual pertenece el contratista
     * @return Listado de Mensajes pertenecientes al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Mensaje>consultarMensajesPorContratista(int idContratista,int idContratante)throws SQLException,ClassNotFoundException;
    /**
     * Método para consultar los mensajes de contratante
     * @param idContratante identificdor de contratante al cual pertenecen los mensajes
     * @return Listado de Mensajes pertenecientes al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Mensaje>consultarMensajesPorContratante(int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método que trae todos los contratistas con actividade pendientes de soporte
     * @param idContratante identificador de contratante
     * @param mes en el cual se pretende sacar el reporte
     * @param year en el cual se pretende sacar el reporte
     * @return Listado cde contratistas con actividade pendientes de soporte
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>pendientesSinSoporte(int idContratante,String mes,int year) throws SQLException,ClassNotFoundException;

    /**
     * Método que trae todos los contratistas sin actividades registradas
     * @param idContratante identificador de contratante
     * @param mes en el cual se pretende sacar el reporte
     * @param year en el cual se pretende sacar el reporte
     * @return Listado cde contratistas sin actividades registradas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>sinRegistro(int idContratante,String mes,int year) throws SQLException,ClassNotFoundException;

    /**
     * Método para identificar si se tiene aprobado el inicio de actividades
     * @param idContratista indentificador de contratista que se le aprueba las actividades
     * @param idContratante identificador de contratante que aproba dicho inicio
     * @return true/false dependiendo si hay o no la aprobacion
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean tieneAprobacion(int idContratista,int idContratante)throws SQLException,ClassNotFoundException;

    /**
     * Método para identificar si el plan del trabajo esta aprobado en el mes y en el año especificado
     * @param idContratista identificador de contratista al que se le aprueba las actividades
     * @param idContratante identifixador de contratante que aproba el plan
     * @param mes en el que se quiere identificar
     * @param year en el que se quiere identificar
     * @return true/false dependiendo si hay o no la aprobacion
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean tieneAprobacionPlandeTrabajo(int idContratista,int idContratante,String mes,int year)throws SQLException,ClassNotFoundException;


}
