package com.example.Beans;

import com.example.Models.Auditoria;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 23/10/2017.
 */
public interface AdministradorDeAuditoria {
public void insertarAuditoria(Auditoria auditoria)throws SQLException,ClassNotFoundException,IOException;

}
