package com.example.Services;

import com.example.Beans.AdministradorDeContratistas;
import com.example.DB.ContratistasBD;
import com.example.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 27/03/2017.
 */
@Service
public class ManejoDeContratistasBD implements AdministradorDeContratistas {
    @Autowired
    private ContratistasBD contratistasBD;

    public ContratistasBD getContratistasBD() {
        return contratistasBD;
    }

    public void setContratistasBD(ContratistasBD contratistasBD) {
        this.contratistasBD = contratistasBD;
    }

    @Override
    public void registrarContratista(Contratista con) throws SQLException, ClassNotFoundException, IOException {
        contratistasBD.nuevoContratista(con);
    }

    @Override
    public FechaLimite getFechaPorContratista(int idContrato, int idCategoria) throws SQLException, ClassNotFoundException {
        return contratistasBD.obtenerFechaDeContratista(idContrato, idCategoria);
    }


    @Override
    public List<Contratista> obtenerContratistas() throws SQLException, ClassNotFoundException {

        return contratistasBD.consultarContratistas();
    }

    @Override
    public void registrarImagen(Imagenes imagenes) throws SQLException, ClassNotFoundException, IOException {
        contratistasBD.registrarImagen(imagenes);
    }

    @Override
    public void registrarDocumento(Documento documento) throws SQLException, ClassNotFoundException, IOException {
        contratistasBD.registrarDocumento(documento);
    }

    @Override
    public void registrarFechaLimite(FechaLimite fechaLimite) throws SQLException, ClassNotFoundException {
        contratistasBD.InsertarFechaLimite(fechaLimite);
    }

    @Override
    public String extraertipo(int idContratista, int idRequisitoSugerido) throws SQLException, ClassNotFoundException {
       return contratistasBD.tipoDeImagenBD(idContratista, idRequisitoSugerido);
    }

    @Override
    public List<RequisitoObligatorio> estadoDeRequisitos(int idContratante,int idCategoria,int idcontratista) throws SQLException, ClassNotFoundException {
        return contratistasBD.estadoDeRequisitos(idContratante,idCategoria,idcontratista);
    }

    @Override
    public List<RequisitoExtra> estadoExtras(int idContratante,int idCategoria,int idContratista) throws SQLException, ClassNotFoundException {
        return contratistasBD.estadoRequisitosExtras(idContratante,idCategoria,idContratista);
    }

    @Override
    public List<ActividadEconomica> obtenerActividadesEconomicas() throws SQLException, ClassNotFoundException {
        return contratistasBD.actividadesEconomicas();
    }


}
