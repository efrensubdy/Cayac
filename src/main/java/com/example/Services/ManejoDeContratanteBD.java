package com.example.Services;

import com.example.Beans.AdministradorDeContratante;
import com.example.DB.ContratanteDB;
import com.example.Models.Contratante;
import com.example.Models.Contratista;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 30/03/2017.
 */
@Service
public class ManejoDeContratanteBD implements AdministradorDeContratante {
    @Autowired
    public ContratanteDB contratanteDB;
    @Override
    public void registrarContratante(Contratante contratante) throws SQLException, ClassNotFoundException {
        contratanteDB.nuevaContratante(contratante);
    }

    @Override
    public List<Contratante> obtenerContratantes() throws SQLException, ClassNotFoundException {

        return contratanteDB.consultarContratantes();
    }

    @Override
    public List<Contratista> contratistaPorContratante(int idContratante, int idContrato) throws SQLException, ClassNotFoundException {
        return contratanteDB.contratistasPorContratante(idContratante,idContrato);
    }

    @Override
    public List<Contratista> contratistaPorCategoria(int idContrato, int idCategoria) throws SQLException, ClassNotFoundException {
        return  contratanteDB.contratistasPorCategoria(idContrato, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> requisitosCumplidos(int idContratista,int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return contratanteDB.requisitosCumplidos(idContratista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoObligatorio> requisitosNoCumplidos(int idContratista,int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return contratanteDB.requisitosNoCumplidos(idContratista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasCumplidos(int idContratista,int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return contratanteDB.requisitosExtrasCumplidos(idContratista, idCategoria, idContratante);
    }

    @Override
    public List<RequisitoExtra> requisitosExtrasNoCumplidos(int idContratista,int idCategoria,int idContratante) throws SQLException, ClassNotFoundException {
        return contratanteDB.requisitosExtrasNoCumplidos(idContratista, idCategoria, idContratante);
    }
}
