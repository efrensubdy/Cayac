package com.example.Services;

import com.example.Beans.AdministradorDeNoConformidades;
import com.example.DB.NoConformidadDB;
import com.example.Models.NoConformidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 24/10/2017.
 */
@Service
public class ManejoDeNoConformidades implements AdministradorDeNoConformidades {
    @Autowired
    public NoConformidadDB noConformidadDB;

    @Override
    public void agregarNoConformidad(NoConformidad noConformidad) throws SQLException, ClassNotFoundException {
        noConformidadDB.insertarNoConformidad(noConformidad);
    }

    @Override
    public List<NoConformidad> traerNoConformidadesPorContratistas(int idContratista) throws SQLException, ClassNotFoundException {
        return noConformidadDB.traerNoConformidadesPorContratista(idContratista);
    }

    @Override
    public List<NoConformidad> traerNoConformidadesPorContratistasyAuditoria(int idContratista, int idAuditoria) throws SQLException, ClassNotFoundException {
        return noConformidadDB.traerNoConformidadesPorContratistayAuditoria(idContratista, idAuditoria);
    }
}
