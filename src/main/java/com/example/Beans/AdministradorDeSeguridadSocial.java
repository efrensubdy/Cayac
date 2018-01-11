package com.example.Beans;

import com.example.Models.SeguridadSocial;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 28/09/2017.
 * Interface pra la Gestión de la seguridad social
 */
public interface AdministradorDeSeguridadSocial {
    /**
     * Método pra registrar la seguirdad social del contratista
     * @param seguridadSocial objeto con la iformación de la seguridad social
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void agregarSeguridadSocial(SeguridadSocial seguridadSocial) throws SQLException, ClassNotFoundException,IOException;

    /**
     * Método para traer las seguridades sociales al contratista
     * @param idContratista identificador del contratistas
     * @return Listado con  todas las seguridades Sociales del Contratista correspondiente
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<SeguridadSocial>traerSeguridadSocialPorContratista(int idContratista)throws SQLException,ClassNotFoundException;

    /**
     * Método para traer las seguridades sociales al contratante
     * @param idContratista indentificador del contratista
     * @param mes en el cual se requiere el reporte
     * @param year en el cual se requiere el reporte
     * @return Listado con el detalle de la seguridad social del contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<SeguridadSocial>traerSeguridadSocialPorContratistaAlContratante(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException;
}
