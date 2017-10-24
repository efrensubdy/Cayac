package com.example.Beans;

import com.example.Models.Auditoria;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 23/10/2017.
 */
public interface AdministradorDeAuditoria {
public void insertarAuditoria(Auditoria auditoria)throws SQLException,ClassNotFoundException,IOException;
public List<Auditoria>traerAuditoriasDeContratante(int idContratante)throws SQLException,ClassNotFoundException;
    public List<Auditoria>traerAuditoriasDeContratista(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException;
}
