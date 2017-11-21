package com.example.Services;

import com.example.Beans.AdministradorDeDignostico;
import com.example.DB.DiagnosticoDB;
import com.example.Models.Diagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class ManejadorDeDiagnosticos implements AdministradorDeDignostico {
    @Autowired
    public DiagnosticoDB diagnosticoDB;
    @Override
    public void insertarDiagnostico(Diagnostico diagnostico) throws SQLException, ClassNotFoundException {
        diagnosticoDB.insertarDiagnostico(diagnostico);
    }
}
