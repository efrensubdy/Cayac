package com.example.Services;

import com.example.Beans.AdministradorDeEstandares;
import com.example.DB.EstandaresDB;
import com.example.Models.EstandarMinimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 18/10/2017.
 */
@Service
public class ManejadorDeEstandares implements AdministradorDeEstandares {
    @Autowired
    public EstandaresDB estandaresDB;
    @Override
    public void insertarEstandar(EstandarMinimo estandarMinimo) throws ClassNotFoundException, SQLException {
        estandaresDB.insertarEstandarMinimo(estandarMinimo);
    }

    @Override
    public List<EstandarMinimo> consultarEstandarMinimoPorContratista(int idContratista, int idContratante) throws ClassNotFoundException, SQLException {
        return estandaresDB.consultarEstandaresMinimosPorContratista(idContratista, idContratante);
    }
}
