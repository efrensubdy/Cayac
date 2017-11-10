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
    public void eliminarMessagesContratistas(int idMessages)throws SQLException,ClassNotFoundException{
        String sql = "DELETE FROM inboxContratista WHERE id= ? ";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idMessages);
        ps.execute();
        ps.close();
        con.close();


    }

}
