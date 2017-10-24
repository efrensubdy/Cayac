package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Auditoria;
import com.example.Models.Conexion;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 23/10/2017.
 */
@Service
public class AuditorioDB {
    public boolean consultarRegistroDocumento(String mes, int year, int idContratista,int idContratante)throws SQLException,ClassNotFoundException{
        boolean flag=false;
        String sql ="select count(*) as registro from auditoria where mes= ? AND year=? AND idContratista = ? AND idContratante= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setString(1,mes);
        ps.setInt(2,year);
        ps.setInt(3,idContratista);
        ps.setInt(4,idContratante);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;

    }
    public void insertarAuditoria(Auditoria auditoria) throws SQLException, ClassNotFoundException, IOException {

        boolean flag=consultarRegistroDocumento(auditoria.getMes(),auditoria.getYear(),auditoria.getIdContratista(),auditoria.getIdContratante());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(auditoria.getFile());
            auditoria.setTipo(fileType);
            String sql = "INSERT INTO auditoria (auditoria,idContratista,idContratante,mes,year,date) VALUES(?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            auditoria.setAuditoria("Repository/Contratista/"+auditoria.getIdContratista()+"/dinamico/"+auditoria.getMes()+"auditoria" + auditoria.getYear() + "."+auditoria.getTipo());
            File f=auditoria.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+auditoria.getIdContratista()+"/dinamico/"+auditoria.getMes()+"auditoria" + auditoria.getYear() + "."+auditoria.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, auditoria.getAuditoria());
            ps.setInt(2, auditoria.getIdContratista());
            ps.setInt(3, auditoria.getIdContratante());
            ps.setString(4, auditoria.getMes());
            ps.setInt(5,auditoria.getYear());
            ps.setDate(6,date);
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(auditoria.getFile());
            auditoria.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+auditoria.getIdContratista()+"/dinamico/"+auditoria.getMes()+"auditoria" + auditoria.getYear() + "."+auditoria.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);

            }
            String sql = "UPDATE  auditoria set fechaActualizacion = ? where idContratista = ? and idContratante= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,auditoria.getIdContratista());
            ps.setInt(3,auditoria.getIdContratante());
            ps.execute();
            con.close();
            File f=auditoria.getFile();
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+auditoria.getIdContratista()+"/dinamico/"+auditoria.getMes()+"auditoria" + auditoria.getYear() + "."+auditoria.getTipo());
            FileUtils.moveFile(f,y);

        }

    }
    public List<Auditoria>traerAuditoriasPorContratante(int idContratante)throws SQLException,ClassNotFoundException{
        List<Auditoria>auditoriaList=new LinkedList<>();
        String sql ="SELECT auditoria.id,auditoria.auditoria,auditoria.idContratista, auditoria.mes,auditoria.year,auditoria.date,contratista.nombreEmpresa FROM auditoria INNER JOIN contratista ON auditoria.idContratista=contratista.idContratista WHERE auditoria.idContratante =?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Auditoria auditoria=new Auditoria();
            auditoria.setId(rs.getInt("id"));
            auditoria.setAuditoria(rs.getString("auditoria"));
            auditoria.setIdContratista(rs.getInt("idContratista"));
            auditoria.setMes(rs.getString("mes"));
            auditoria.setYear(rs.getInt("year"));
            auditoria.setFecha(rs.getDate("date"));
            auditoria.setNombreEmpresa(rs.getString("nombreEmpresa"));
            auditoriaList.add(auditoria);
        }
        ps.close();


        return auditoriaList;
    }
    public List<Auditoria>traerAuditoriasPorContratista(int idContratista,String mes,int year)throws SQLException,ClassNotFoundException{
        List<Auditoria>auditoriaList=new LinkedList<>();
        String sql ="SELECT auditoria.id,auditoria.auditoria,auditoria.idContratista, auditoria.mes,auditoria.year,auditoria.date,contratista.nombreEmpresa FROM auditoria INNER JOIN contratista ON auditoria.idContratista=contratista.idContratista WHERE auditoria.idContratista =? AND auditoria.mes =? AND auditoria.year =? ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setString(2,mes);
        ps.setInt(3,year);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Auditoria auditoria=new Auditoria();
            auditoria.setId(rs.getInt("id"));
            auditoria.setAuditoria(rs.getString("auditoria"));
            auditoria.setIdContratista(rs.getInt("idContratista"));
            auditoria.setMes(rs.getString("mes"));
            auditoria.setYear(rs.getInt("year"));
            auditoria.setFecha(rs.getDate("date"));
            auditoria.setNombreEmpresa(rs.getString("nombreEmpresa"));
            auditoriaList.add(auditoria);
        }
        ps.close();


        return auditoriaList;
    }
    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}
