package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Conexion;
import com.example.Models.SeguridadSocial;
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
 * Created by HSEQ on 28/09/2017.
 */
@Service
public class SeguridadSocialBD {
    public  boolean consultarRegistroDeImagen(int idContratante, int idContratista,String mes)throws SQLException,ClassNotFoundException {
        boolean flag=false;
        System.out.println(idContratante);
        String sql ="select count(*) as registro from seguridadsocial where idContratante= ? and idContratista=? and mes = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idContratista);
        ps.setString(3,mes);
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
        ps.close();
        return flag;


    }
 public void insertarSeguridadSocial(SeguridadSocial seguridadSocial)throws SQLException,ClassNotFoundException,IOException{
     System.out.println(seguridadSocial.getArchivos().get(1).getName());
     boolean flag=consultarRegistroDeImagen(seguridadSocial.getIdContratante(),seguridadSocial.getIdContratista(),seguridadSocial.getMes());
     if(!flag){
         java.util.Date utilDate = new Date();
         java.sql.Date date = new java.sql.Date(utilDate.getTime());
         String fileType = getFileExtension(seguridadSocial.getArchivos().get(0));
         String fileType2= getFileExtension(seguridadSocial.getArchivos().get(1));
         String sql = "INSERT INTO seguridadsocial (mes,fechaDeSubida,seguridadSocial,idContratista,idContratante,personal,cambios,tipo1,tipo2,year) VALUES(?,?,?,?,?,?,?,?,?,?)";
         Connection con =  Conexion.conection();
         seguridadSocial.setPersonal("Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"personal" +"."+fileType2);
         seguridadSocial.setSeguridadSocial("Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"SS" +"."+fileType);
         File f=seguridadSocial.getArchivos().get(0);
         File f2=seguridadSocial.getArchivos().get(1);
         File q=new File("src/main/resources/static/app/Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"personal" +"."+fileType);
         File q2=new File("src/main/resources/static/app/Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"SS" +"."+fileType2);
         FileUtils.moveFile(f,q);
         FileUtils.moveFile(f2,q2);
         System.out.println(f.getName());
         PreparedStatement ps = con.prepareStatement(sql);

         ps.setString(1,seguridadSocial.getMes());
         ps.setDate(2,date);
         ps.setString(3,seguridadSocial.getSeguridadSocial());
         ps.setInt(4,seguridadSocial.getIdContratista());
         ps.setInt(5,seguridadSocial.getIdContratante());
         ps.setString(6,seguridadSocial.getPersonal());
         ps.setString(7,seguridadSocial.getCambios());
         ps.setString(8,fileType);
         ps.setString(9,fileType2);
         ps.setInt(10,seguridadSocial.getYear());
         ps.execute();
         ps.close();
         con.close();
     }
     else{
         java.util.Date utilDate = new Date();
         java.sql.Date date = new java.sql.Date(utilDate.getTime());
         String fileType = getFileExtension(seguridadSocial.getArchivos().get(0));
         String fileType2= getFileExtension(seguridadSocial.getArchivos().get(1));
         File q=new File("src/main/resources/static/app/Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"personal" +"."+fileType2);
         File q2=new File("src/main/resources/static/app/Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"SS" +"."+fileType);
         if (q.isFile()) {
             FileUtils.deleteQuietly(q);
         }
         if (q2.isFile()) {
             FileUtils.deleteQuietly(q2);
         }

         String sql = "UPDATE  seguridadsocial set fechaDeSubida = ? where idContratista = ? and idContratista= ?";
         Connection con =  Conexion.conection();
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setDate(1,date);
         ps.setInt(2,seguridadSocial.getIdContratista());
         ps.setInt(3,seguridadSocial.getIdContratante());
         ps.execute();
         con.close();
         File f=seguridadSocial.getArchivos().get(1);
         File f2=seguridadSocial.getArchivos().get(2);
         File y=new File("src/main/resources/static/app/Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"personal" +"."+fileType2);
         File y1=new File("src/main/resources/static/app/Repository/Contratista/"+seguridadSocial.getIdContratista()+"/dinamico/"+seguridadSocial.getMes()+"SS" +"."+fileType);
         FileUtils.moveFile(f,y);
         FileUtils.moveFile(f2,y1);

     }


 }
 public List<SeguridadSocial> traerSeguridadSocial(int idContratista)throws SQLException,ClassNotFoundException{
        List<SeguridadSocial>seguridadSocialList=new LinkedList<>();
     String sql ="SELECT * FROM  seguridadsocial where idContratista = ?";
     PreparedStatement ps = Conexion.conection().prepareStatement(sql);
     ps.setInt(1,idContratista);
     ResultSet rs = ps.executeQuery();
     while(rs.next()){
         SeguridadSocial seguridadSocial =new SeguridadSocial();
         seguridadSocial.setId(rs.getInt("id"));
         seguridadSocial.setMes(rs.getString("mes"));
         seguridadSocial.setFechaDeSubida(rs.getDate("fechaDeSubida"));
         seguridadSocial.setSeguridadSocial(rs.getString("seguridadSocial"));
         seguridadSocial.setIdContratista(rs.getInt("idContratista"));
         seguridadSocial.setIdContratante(rs.getInt("idContratante"));
         seguridadSocial.setPersonal(rs.getString("personal"));
         seguridadSocial.setCambios(rs.getString("cambios"));
         seguridadSocial.setYear(rs.getInt("year"));
          seguridadSocialList.add(seguridadSocial);
     }
     ps.close();
     return seguridadSocialList;
 }
    public List<SeguridadSocial> traerSeguridadSocialAlContratante(int idContratista,String mes , int year)throws SQLException,ClassNotFoundException{
        List<SeguridadSocial>seguridadSocialList=new LinkedList<>();
        String sql ="SELECT * FROM  seguridadsocial where idContratista = ? AND mes= ? AND year= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setString(2,mes);
        ps.setInt(3,year);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            SeguridadSocial seguridadSocial =new SeguridadSocial();
            seguridadSocial.setId(rs.getInt("id"));
            seguridadSocial.setMes(rs.getString("mes"));
            seguridadSocial.setFechaDeSubida(rs.getDate("fechaDeSubida"));
            seguridadSocial.setSeguridadSocial(rs.getString("seguridadSocial"));
            seguridadSocial.setIdContratista(rs.getInt("idContratista"));
            seguridadSocial.setIdContratante(rs.getInt("idContratante"));
            seguridadSocial.setPersonal(rs.getString("personal"));
            seguridadSocial.setCambios(rs.getString("cambios"));
            seguridadSocial.setYear(rs.getInt("year"));
            seguridadSocialList.add(seguridadSocial);
        }
        ps.close();
        return seguridadSocialList;
    }


    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


}
