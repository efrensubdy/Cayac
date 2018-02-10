package com.example.DB;


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

    /**
     * Método que registra una no Confromidad en la base de datos
     * @param noConformidad objeto con la informacion que se requiere registrar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Método que trae las no conformidades asociadas a un contratista
     * @param idContratista identificador del contratista al que pertenecen las no conformidades
     * @return Listado con todas las no conformidades en objetos de tipo NoConformidad
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Método que se encarga de traer las no conformidades por contratistas conform a una auditoria
     * @param idContratista identificador del contratista a quien pertenecen las no conformidades
     * @param idAuditoria identificador de las auditorias que pertenecen las no conformidades
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<NoConformidad>traerNoConformidadesPorContratistayAuditoria(int idContratista,int idAuditoria)throws SQLException,ClassNotFoundException{
        List<NoConformidad>noConformidadList=new LinkedList<>();
        String sql ="SELECT noConformidad.id , noConformidad.idAuditoria, noConformidad.idContratista,noConformidad.year,noConformidad.mes, noConformidad.noConformidad  FROM noConformidad INNER JOIN auditoria ON auditoria.id = noConformidad.idAuditoria AND noConformidad.idAuditoria = ? AND noConformidad.idContratista= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idAuditoria);
        ps.setInt(2,idContratista);
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
