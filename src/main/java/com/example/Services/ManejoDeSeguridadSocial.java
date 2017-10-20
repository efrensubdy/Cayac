package com.example.Services;

import com.example.Beans.AdministradorDeSeguridadSocial;
import com.example.DB.SeguridadSocialBD;
import com.example.Models.SeguridadSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 28/09/2017.
 */
@Service
public class ManejoDeSeguridadSocial implements AdministradorDeSeguridadSocial {
    @Autowired
    public SeguridadSocialBD seguridadSocialBD;
    @Override
    public void agregarSeguridadSocial(SeguridadSocial seguridadSocial) throws SQLException, ClassNotFoundException,IOException {
        seguridadSocialBD.insertarSeguridadSocial(seguridadSocial);
    }

    @Override
    public List<SeguridadSocial> traerSeguridadSocialPorContratista(int idContratista) throws SQLException, ClassNotFoundException {
        return seguridadSocialBD.traerSeguridadSocial(idContratista);
    }

    @Override
    public List<SeguridadSocial> traerSeguridadSocialPorContratistaAlContratante(int idContratista, String mes, int year) throws SQLException, ClassNotFoundException {
        return seguridadSocialBD.traerSeguridadSocialAlContratante(idContratista, mes, year);
    }
}
