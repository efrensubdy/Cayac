package com.example.Services;

import com.example.Beans.AdministradorDeEliminaciones;
import com.example.DB.EliminarRequisitosDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by HSEQ on 01/08/2017.
 */
@Service
public class ManejoDeEliminaciones implements AdministradorDeEliminaciones {
    @Autowired
    public EliminarRequisitosDB eliminarRequisitosDB;
    @Override
    public void eliminarPrevioSugerido(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarPrevioSugerido(idRequisito, idContratante);
    }

    @Override
    public void eliminarPrevioExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarPrevioExtra(idRequisito, idContratante);
    }

    @Override
    public void eliminarMessagesContratistas(int idMessages) throws SQLException, ClassNotFoundException {
        eliminarRequisitosDB.eliminarMessagesContratistas(idMessages);
    }

}
