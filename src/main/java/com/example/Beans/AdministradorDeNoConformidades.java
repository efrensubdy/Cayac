package com.example.Beans;

import com.example.Models.NoConformidad;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 24/10/2017.
 */
public interface  AdministradorDeNoConformidades {
    public void agregarNoConformidad(NoConformidad noConformidad)throws SQLException,ClassNotFoundException;
    public List<NoConformidad>traerNoConformidadesPorContratistas(int idContratista)throws SQLException,ClassNotFoundException;
    public List<NoConformidad>traerNoConformidadesPorContratistasyAuditoria(int idContratista,int idAuditoria)throws SQLException,ClassNotFoundException;
}
