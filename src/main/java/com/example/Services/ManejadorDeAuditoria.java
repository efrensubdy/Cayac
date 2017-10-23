package com.example.Services;

import com.example.Beans.AdministradorDeAuditoria;
import com.example.DB.AuditorioDB;
import com.example.Models.Auditoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by HSEQ on 23/10/2017.
 */
@Service
public class ManejadorDeAuditoria implements AdministradorDeAuditoria {
    @Autowired
    public AuditorioDB auditorioDB;
    @Override
    public void insertarAuditoria(Auditoria auditoria) throws SQLException, ClassNotFoundException ,IOException{
        auditorioDB.insertarAuditoria(auditoria);
    }
}
