package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Diagnostico;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class DiagnosticoDB {
    public void insertarDiagnostico(Diagnostico diagnostico)throws SQLException,ClassNotFoundException{
        //System.out.println(diagnostico.nombreEmpresa);
        String sql = "INSERT INTO  diagnostico(nombreEmpresa,nombreEmpleado,telefono,email,primeraPregunta,SegundaPregunta,terceraPregunta,cuartaPregunta,quintaPregunta,sextaPregunta,septimaPregunta,octavaPregunta,novenaPregunta,decimaPregunta,decimoPrimeraPregunta,decimoSegundaPregunta,decimoTerceraPregunta,decimoCuartaPregunta,decimoQuintaPregunta,decimoSextaPregunta,decimoSeptimaPregunta) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,diagnostico.getNombreEmpresa());
        ps.setString(2,diagnostico.getNombreEmpleado());
        ps.setString(3,diagnostico.getTelefono());
        ps.setString(4,diagnostico.getEmail());
        ps.setInt(5,diagnostico.getPrimeraPregunta());
        ps.setInt(6,diagnostico.getSegundaPregunta());
        ps.setInt(7,diagnostico.getTerceraPregunta());
        ps.setInt(8,diagnostico.getCuartaPregunta());
        ps.setInt(9,diagnostico.getQuintaPregunta());
        ps.setInt(10,diagnostico.getSextaPregunta());
        ps.setInt(11,diagnostico.getSeptimaPregunta());
        ps.setInt(12,diagnostico.getOctavaPregunta());
        ps.setInt(13,diagnostico.getNovenaPregunta());
        ps.setInt(14,diagnostico.getDecimaPregunta());
        ps.setInt(15,diagnostico.getDecimoPrimeraPregunta());
        ps.setInt(16,diagnostico.getDecimoSegundaPregunta());
        ps.setInt(17,diagnostico.getDecimoTerceraPregunta());
        ps.setInt(18,diagnostico.getDecimoCuartaPregunta());
        ps.setInt(19,diagnostico.getDecimoQuintaPregunta());
        ps.setInt(20,diagnostico.getDecimoSextaPregunta());
        ps.setInt(21,diagnostico.getDecimoSeptimaPregunta());
        ps.execute();
        ps.close();
        con.close();


    }
}
