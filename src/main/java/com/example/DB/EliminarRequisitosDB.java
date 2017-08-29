package com.example.DB;

import com.example.Models.Conexion;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by HSEQ on 01/08/2017.
 */
@Service
public class EliminarRequisitosDB {
    public void eliminarPrevioSugerido(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requisitosdeejecuiondefsugeridosestaticosprevio WHERE idRequsito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarPrevioExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requisitosdeejecuiondefextrasestaticosprevio WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarEjecucionSugerida(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requisitosdeejecuiondefsugeridosestaticosejecucionactividades WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarEjecucionExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requisitosdeejecuionextrasdefestaticosejecucionactividades WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarFinalizacionSugerido(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM ejecuionsugeridosestaticosdeffinalizaciondeactivdades WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarFinalizacionExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM ejecuionextrassestaticosdeffinalizaciondeactivdades WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarDinamicoPrevio(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requidinadefpresug WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarDinamicoPrevioExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requidinadefpreext WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarDinamicoEjecucion(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requidinadefejecsug WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarDinamicoEjecucionExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requidinadefejecext WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarDinamicoFinalizacion(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requidinadeffinalsug WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    public void eliminarDinamicoFinalizacionExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM requidinadeffinalext WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }


}
