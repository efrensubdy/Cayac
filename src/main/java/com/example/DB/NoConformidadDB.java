package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Conexion;
import com.example.Models.NoConformidad;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 24/10/2017.
 */
@Service
public class NoConformidadDB {

    public void insertarNoConformidad(NoConformidad noConformidad)throws SQLException,ClassNotFoundException{

        String sql = "INSERT INTO  noConformidad(noConformidad,idAuditoria,idContratista,mes,year) VALUES(?,?,?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,noConformidad.getNoConformidad());
        ps.setInt(2,noConformidad.getIdAuditoria());
        ps.setInt(3,noConformidad.getIdContratista());
        ps.setString(4,noConformidad.getMes());
        ps.setInt(5,noConformidad.getYear());
        ps.execute();
        ps.close();
        con.close();



    }
    public List<NoConformidad>traerNoConformidadesPorContratista(int idContratista)throws SQLException,ClassNotFoundException{
        List<NoConformidad>noConformidadList=new LinkedList<>();
        String sql ="SELECT * FROM  noConformidad WHERE idContratista = ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            NoConformidad noConformidad=new NoConformidad();
            noConformidad.setId(rs.getInt("id"));
            noConformidad.setIdAuditoria(rs.getInt("idAuditoria"));
            noConformidad.setIdContratista(rs.getInt("idContratista"));
            noConformidad.setYear(rs.getInt("year"));
            noConformidad.setMes(rs.getString("mes"));
            noConformidad.setNoConformidad(rs.getString("noConformidad"));
            noConformidadList.add(noConformidad);
        }
        ps.close();
        return noConformidadList;
    }

}
