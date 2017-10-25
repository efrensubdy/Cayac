package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Causa;
import com.example.Models.Conexion;
import com.example.Models.NoConformidad;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 25/10/2017.
 */
@Service
public class CausaDB {

    public void insertarCausa(Causa causa)throws SQLException,ClassNotFoundException{
        System.out.println(causa.getCausa());
        String sql = "INSERT INTO  causa(causa,idContratista,idNoConformidad) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,causa.getCausa());
        ps.setInt(2,causa.getIdContratista());
        ps.setInt(3,causa.getIdNoConformidad());
        ps.execute();
        ps.close();
        con.close();


    }
    public List<Causa> traerCausasPorContratista(int idContratista,int idNoConformidad)throws SQLException,ClassNotFoundException{
        List<Causa>causaList=new LinkedList<>();
        String sql ="SELECT * FROM  causa WHERE idContratista = ? and idNoConformidad=?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idNoConformidad);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
           Causa causa=new Causa();
           causa.setCausa(rs.getString("causa"));
           causa.setIdContratista(rs.getInt("idContratista"));
           causa.setIdNoConformidad(rs.getInt("idNoConformidad"));
           causaList.add(causa);
        }
        ps.close();
        return causaList;
    }

}
