package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Accion;
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
    public void insertarAccion(Accion accion) throws SQLException, ClassNotFoundException, IOException {

            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(accion.getRegistro());
            String sql = "INSERT INTO accion (idContratista,idCausa,nombre,registro,date) VALUES(?,?,?,?,?)";
            Connection con = Conexion.conection();
            accion.setRegistro2("Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" +"."+getFileExtension(accion.getRegistro()));
            File f=accion.getRegistro();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" +"."+getFileExtension(accion.getRegistro()));
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accion.getIdContratista());
            ps.setInt(2, accion.getIdCausa());
            ps.setString(3, accion.getNombre());
            ps.setString(4, accion.getRegistro2());
            ps.setDate(5, date);
            ps.execute();
            ps.close();
            con.close();

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
