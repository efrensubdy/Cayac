package com.example.Services;

import com.example.Beans.AdministradorDeUsuarios;
import com.example.DB.UsersDB;
import com.example.Models.Requisito;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import com.example.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 04/04/2017.
 */
@Service
public class ManejoDeUsuariosBD implements AdministradorDeUsuarios {
    @Autowired
    public UsersDB usersDB;

    public UsersDB getUsersDB() {
        return usersDB;
    }

    public void setUsersDB(UsersDB usersDB) {
        this.usersDB = usersDB;
    }

    @Override
    public boolean loginContratante(String email, String password) throws SQLException, ClassNotFoundException {

        return usersDB.GetUsuarioContratante(email,password);
    }

    @Override
    public boolean loginContratista(String email, String password) throws SQLException, ClassNotFoundException {
        return usersDB.GetUsuarioContratista(email, password);
    }

    @Override
    public int getIdContratante(String email, String password) throws SQLException, ClassNotFoundException {
        return usersDB.getIdContratante(email, password);
    }

    @Override
    public int getIdContratista(String email, String password) throws SQLException, ClassNotFoundException {
        return usersDB.getIdContratista(email, password);
    }

    @Override
    public Usuario getUsuario(String email, String password) throws SQLException, ClassNotFoundException {
        return usersDB.getUsuario(email, password);
    }

    @Override
    public Usuario getUsuario2(String email, String password) throws SQLException, ClassNotFoundException {
        return usersDB.getUsuario2(email, password);
    }

    @Override
    public List<Requisito> getRequisitosSugeridos(int idContrante, int idCategoria) throws SQLException, ClassNotFoundException {
        return usersDB.getRequisitosSugeridos(idContrante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> getRequisitosExtras(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        return usersDB.getExtras(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoObligatorio> getObligatorios(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        return usersDB.requisitosObligatoriosPorContratista(idContratante, idCategoria);
    }

    @Override
    public List<RequisitoExtra> getExtras(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        return usersDB.requisitosExtrasPorContratista(idContratante, idCategoria);
    }

    @Override
    public void actualizarContraseñaContratante(int idContratante, String newPassword) throws SQLException, ClassNotFoundException {
        usersDB.actualizarContraseñaContratante(idContratante, newPassword);
    }

    @Override
    public void actualizarContraseñaContratista(int idContratista, String newPassword) throws SQLException, ClassNotFoundException {
        usersDB.actualizarContraseñaContratista(idContratista, newPassword);
    }

    @Override
    public void agregarObligatorio(RequisitoObligatorio obligatorio) throws SQLException, ClassNotFoundException {
        usersDB.agregarRequisitoObligatorios(obligatorio);
    }

    @Override
    public void agregrarExtra(RequisitoExtra extra) throws SQLException, ClassNotFoundException {
        usersDB.agregarRequisitoExtras(extra);
    }

    @Override
    public void EliminarObligatorio(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        usersDB.EliminarRequisitoObligatorios(idRequisito, idContratante);
    }

    @Override
    public void EliminarExtra(int idRequisito, int idContratante) throws SQLException, ClassNotFoundException {
        usersDB.EliminarRequisitoObligatoriosExtra(idRequisito, idContratante);
    }

}
