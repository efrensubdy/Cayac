package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Indicador;
import com.example.Models.PlanDeTrabajo;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 03/10/2017.
 */
@Service
public class IndicadorDB {

    public void insertarIndicador(Indicador indicador)throws SQLException,ClassNotFoundException{
        String sql="INSERT INTO Indicadores (nombreContra,periodo,responsable,departamento,actividad,severidad,frecuencia,mortalidad,prevalencia,incidencia,ausentismo,idContratista,idContratante) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = Conexion.conection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,indicador.getNombreContra());
        ps.setString(2,indicador.getMes());
        ps.setString(3,indicador.getResponsable());
        ps.setString(4,indicador.getDepartamento());
        ps.setString(5,indicador.getActividad());
        ps.setFloat(6,indicador.getSeveridad());
        ps.setFloat(7,indicador.getFrecuencia());
        ps.setFloat(8,indicador.getMortalidad());
        ps.setFloat(9,indicador.getPrevalencia());
        ps.setFloat(10,indicador.getIncidencia());
        ps.setFloat(11,indicador.getAusentismo());
        ps.setInt(12,indicador.getIdContratista());
        ps.setInt(13,indicador.getIdContratante());
        ps.execute();
        ps.close();
        con.close();


    }
    public List<Indicador>indicadoresPorMes(int idContratista, String mes)throws SQLException,ClassNotFoundException {
        List<Indicador>indicadors=new LinkedList<>();
        String sql="SELECT * FROM Indicadores WHERE idContratista = ? AND periodo = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setString(2,mes);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Indicador indicador=new Indicador();
            indicador.setId(rs.getInt("id"));
            indicador.setNombreContra(rs.getString("nombreContra"));
            indicador.setMes(rs.getString("periodo"));
            indicador.setResponsable(rs.getString("responsable"));
            indicador.setDepartamento(rs.getString("departamento"));
            indicador.setActividad(rs.getString("actividad"));
            indicador.setSeveridad(rs.getFloat("severidad"));
            indicador.setFrecuencia(rs.getFloat("frecuencia"));
            indicador.setMortalidad(rs.getFloat("mortalidad"));
            indicador.setPrevalencia(rs.getFloat("prevalencia"));
            indicador.setIncidencia(rs.getFloat("incidencia"));
            indicador.setAusentismo(rs.getFloat("ausentismo"));
            indicador.setIdContratista(rs.getInt("idContratista"));
            indicador.setIdContratante(rs.getInt("idContratante"));
            indicadors.add(indicador);

        }
        return indicadors;
    }
    public List<Indicador>traerIndicadoresPorFinalista(int idContratista, int idContratante)throws SQLException,ClassNotFoundException{
        List<Indicador>indicadors=new LinkedList<>();
        String sql="SELECT * FROM Indicadores WHERE idContratista = ? AND idContratante = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idContratante);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Indicador indicador=new Indicador();
            indicador.setId(rs.getInt("id"));
            indicador.setNombreContra(rs.getString("nombreContra"));
            indicador.setMes(rs.getString("periodo"));
            indicador.setResponsable(rs.getString("responsable"));
            indicador.setDepartamento(rs.getString("departamento"));
            indicador.setActividad(rs.getString("actividad"));
            indicador.setSeveridad(rs.getFloat("severidad"));
            indicador.setFrecuencia(rs.getFloat("frecuencia"));
            indicador.setMortalidad(rs.getFloat("mortalidad"));
            indicador.setPrevalencia(rs.getFloat("prevalencia"));
            indicador.setIncidencia(rs.getFloat("incidencia"));
            indicador.setAusentismo(rs.getFloat("ausentismo"));
            indicador.setIdContratista(rs.getInt("idContratista"));
            indicador.setIdContratante(rs.getInt("idContratante"));
            indicadors.add(indicador);
        }
        return indicadors;
    }

}
