package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Diagnostico;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Service
public class DiagnosticoDB {
    /**
     * Método que se encarga de registrar diagnostico en la base de datos
     * @param diagnostico obejto con la información del diagnostico
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarDiagnostico(Diagnostico diagnostico)throws SQLException,ClassNotFoundException{

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

    /**
     * Método que trae todos los diagnosticos hechos en el software
     * @return lISTADO con todos los diagnosticos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Diagnostico>traerDiagnosticosParaGerencia()throws SQLException,ClassNotFoundException {
List<Diagnostico> diagnosticoList=new LinkedList<>();

    String sql ="SELECT * FROM  diagnostico";
    PreparedStatement ps = Conexion.conection().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setNombreEmpresa(rs.getString("nombreEmpresa"));
        diagnostico.setNombreEmpleado(rs.getString("nombreEmpleado"));
        diagnostico.setTelefono(rs.getString("telefono"));
        diagnostico.setEmail(rs.getString("email"));
        diagnostico.setPrimeraPregunta(rs.getInt("primeraPregunta"));
        diagnostico.setSegundaPregunta(rs.getInt("SegundaPregunta"));
        diagnostico.setTerceraPregunta(rs.getInt("terceraPregunta"));
        diagnostico.setCuartaPregunta(rs.getInt("cuartaPregunta"));
        diagnostico.setQuintaPregunta(rs.getInt("quintaPregunta"));
        diagnostico.setSextaPregunta(rs.getInt("sextaPregunta"));
        diagnostico.setSeptimaPregunta(rs.getInt("septimaPregunta"));
        diagnostico.setOctavaPregunta(rs.getInt("octavaPregunta"));
        diagnostico.setNovenaPregunta(rs.getInt("novenaPregunta"));
        diagnostico.setDecimaPregunta(rs.getInt("decimaPregunta"));
        diagnostico.setDecimoPrimeraPregunta(rs.getInt("decimoPrimeraPregunta"));
        diagnostico.setDecimoSegundaPregunta(rs.getInt("decimoSegundaPregunta"));
        diagnostico.setDecimoTerceraPregunta(rs.getInt("decimoTerceraPregunta"));
        diagnostico.setDecimoCuartaPregunta(rs.getInt("decimoCuartaPregunta"));
        diagnostico.setDecimoQuintaPregunta(rs.getInt("decimoQuintaPregunta"));
        diagnostico.setDecimoSextaPregunta(rs.getInt("decimoSextaPregunta"));
        diagnostico.setDecimoSeptimaPregunta(rs.getInt("decimoSeptimaPregunta"));
        diagnosticoList.add(diagnostico);
    }
    ps.close();



return diagnosticoList;

}


}
