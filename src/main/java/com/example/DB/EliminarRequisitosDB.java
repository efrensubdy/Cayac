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
    /**
     * Mètodo que elimina un requisito de la base de datos
     * Nota solo se podrán eliminar mientras no hayan documentos asociados
     * @param idRequisito identificador del requisito que se quiere eliminar
     * @param idContratante identificador del contratante quien requiere eliminar el requisito
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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

    /**
     * Mètodo que elimina un requisito extras de la base de datos
     * Nota solo se podrán eliminar mientras no hayan documentos asociados
     * @param idRequisito identificador del requisito que se quiere eliminar
     * @param idContratante identificador del contratante quien requiere eliminar el requisito
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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

    /**
     * Método que elimina mensajes del inbox del contratista
     * @param idMessages identificador del mensaje que se quiere eliminar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarMessagesContratistas(int idMessages)throws SQLException,ClassNotFoundException{
        String sql = "DELETE FROM inboxContratista WHERE id= ? ";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idMessages);
        ps.execute();
        ps.close();
        con.close();


    }
    /**
     * Método que elimina mensajes del inbox del Contratante
     * @param idMessages identificador del mensaje que se quiere eliminar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarMessagesContratante(int idMessages)throws SQLException,ClassNotFoundException{
        String sql = "DELETE FROM inboxContratante WHERE id= ? ";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idMessages);
        ps.execute();
        ps.close();
        con.close();


    }

}
