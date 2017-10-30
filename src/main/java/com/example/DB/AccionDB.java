package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Accion;
import com.example.Models.Cierre;
import com.example.Models.Conexion;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 26/10/2017.
 */
@Service
public class AccionDB {
    public boolean consultarRegistro(int idContratista,int idCausa) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from accion where idContratista= ? and idCausa=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idCausa);
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
    public void insertarAccion2(Accion accion)throws SQLException,ClassNotFoundException,IOException{
        System.out.println(accion.getNombre());
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO accion (idContratista,idCausa,nombre,registro,date) VALUES(?,?,?,?,?)";
        Connection con = Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accion.getIdContratista());
        ps.setInt(2, accion.getIdCausa());
        ps.setString(3, accion.getNombre());
        ps.setNull(4, Types.VARCHAR);
        ps.setDate(5, date);
        ps.execute();
        ps.close();
        con.close();





    }
    public void registrarCierre(Cierre cierre)throws SQLException,ClassNotFoundException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO cierreDeNoConfor (idNoConformidad,idContratista,date) VALUES(?,?,?)";
        Connection con = Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, cierre.getIdNoConformidad());
        ps.setInt(2, cierre.getIdContratista());
        ps.setDate(3, date);
        ps.execute();
        ps.close();
        con.close();

    }
    public boolean consultarRegistroDeCierre(int idNoConformidad,int idContratista) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        String sql = "select count(*) as registro from cierreDeNoConfor where idNoConformidad = ? and idContratista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1, idNoConformidad);
        ps.setInt(2, idContratista);
        ResultSet rs = ps.executeQuery();
        int registro = 0;
        while (rs.next()) {
            registro = rs.getInt("registro");

        }
        if (registro == 0) {
            flag = false;
        } else {
            flag = true;
        }
        ps.close();

        return flag;
    }
    public boolean consultarRegistro(int id,int idContratista,int idCausa) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        String sql = "select count(*) as registro from accion where id= ? and idContratista=? and idCausa = ? and registro is not null;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, idContratista);
        ps.setInt(3, idCausa);
        ResultSet rs = ps.executeQuery();
        int registro = 0;
        while (rs.next()) {
            registro = rs.getInt("registro");

        }
        if (registro == 0) {
            flag = false;
        } else {
            flag = true;
        }
        ps.close();

        return flag;
    }

    public void insertarAccion(Accion accion) throws SQLException, ClassNotFoundException, IOException {

        String fileType = getFileExtension(accion.getRegistro());
        boolean flag=consultarRegistro(accion.getId(),accion.getIdContratista(),accion.getIdCausa());
        if(!flag){
            String sql ="UPDATE accion SET registro = ? WHERE id= ? and idContratista= ? and idCausa= ?;";
            Connection con=Conexion.conection();
            accion.setRegistro2("Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() + "."+getFileExtension(accion.getRegistro()));
            File f=accion.getRegistro();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() +"."+getFileExtension(accion.getRegistro()));
            FileUtils.moveFile(f,q);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,accion.getRegistro2());
            ps.setInt(2,accion.getId());
            ps.setInt(3,accion.getIdContratista());
            ps.setInt(4,accion.getIdCausa());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() + "."+getFileExtension(accion.getRegistro()));
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);

            }
            String sql ="UPDATE accion SET registro = ? WHERE id= ? and idContratista= ? and idCausa= ?;";
            Connection con=Conexion.conection();
            accion.setRegistro2("Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() +"."+getFileExtension(accion.getRegistro()));
            File f=accion.getRegistro();
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() + "."+getFileExtension(accion.getRegistro()));
            FileUtils.moveFile(f,y);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,accion.getRegistro2());
            ps.setInt(2,accion.getId());
            ps.setInt(3,accion.getIdContratista());
            ps.setInt(4,accion.getIdCausa());
            ps.execute();
            ps.close();
            con.close();

        }


    }
    public List<Cierre>actividadesCerradas(int idContratista)throws SQLException,ClassNotFoundException{

        List<Cierre> cierreList = new LinkedList<>();
        String sql ="SELECT * FROM  cierreDeNoConfor where idContratista = ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Cierre cierre = new Cierre();
            cierre.setId(rs.getInt("id"));
            cierre.setIdNoConformidad(rs.getInt("idNoConformidad"));
            cierre.setIdContratista(rs.getInt("idContratista"));
            cierreList.add(cierre);

        }
        ps.close();

        return cierreList;



    }
    public List<Accion> traerAccionesPorCausa(int idContratista, int idCausa) throws SQLException,ClassNotFoundException{
        List<Accion>accionList=new LinkedList<>();
        String sql ="SELECT * FROM accion WHERE idContratista =? AND idCausa = ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idCausa);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Accion accion = new Accion();
            accion.setId(rs.getInt("id"));
            accion.setIdContratista(rs.getInt("idContratista"));
            accion.setIdCausa(rs.getInt("idCausa"));
            accion.setRegistro2(rs.getString("registro"));
            if(accion.getRegistro2()==null){
                accion.setEstado(false);
            }
            else{
                accion.setEstado(true);
            }
            accion.setNombre(rs.getString("nombre"));
            accion.setDate(rs.getDate("date"));
            accionList.add(accion);
        }


        return accionList;
    }
    public List<Accion> traerAccionesConRegistro(int idContratista,int idCausa)throws SQLException,ClassNotFoundException{
        List<Accion>accionList=new LinkedList<>();
        String sql ="SELECT * FROM accion LEFT JOIN causa ON causa.id = accion.idCausa WHERE accion.idContratista= ? AND accion.idCausa= ? AND accion.registro IS NOT NULL";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idCausa);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Accion accion = new Accion();
            accion.setId(rs.getInt("id"));
            accion.setIdContratista(rs.getInt("idContratista"));
            accion.setIdCausa(rs.getInt("idCausa"));
            accion.setRegistro2(rs.getString("registro"));
            accion.setNombre(rs.getString("nombre"));
            accion.setDate(rs.getDate("date"));
            accionList.add(accion);
        }


        return accionList;
    }
    public List<Accion> traerAccionesSinRegistro(int idContratista,int idCausa)throws SQLException,ClassNotFoundException{
        List<Accion>accionList=new LinkedList<>();
        String sql ="SELECT * FROM accion LEFT JOIN causa ON causa.id = accion.idCausa WHERE accion.idContratista= ? AND accion.idCausa= ? AND accion.registro IS NULL";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idCausa);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Accion accion = new Accion();
            accion.setId(rs.getInt("id"));
            accion.setIdContratista(rs.getInt("idContratista"));
            accion.setIdCausa(rs.getInt("idCausa"));
            accion.setRegistro2(rs.getString("registro"));
            accion.setNombre(rs.getString("nombre"));
            accion.setDate(rs.getDate("date"));
            accionList.add(accion);
        }
        return accionList;
    }
    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

}
