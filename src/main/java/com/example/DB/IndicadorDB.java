package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Contratista;
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
        String sql="INSERT INTO Indicadores (nombreContra,periodo,responsable,departamento,actividad,severidad,frecuencia,mortalidad,prevalencia,incidencia,ausentismo,idContratista,idContratante,año) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        ps.setInt(14,indicador.getYear());
        ps.execute();
        ps.close();
        con.close();


    }
    public List<Indicador>indicadoresPorMes(int idContratista, String mes,int year)throws SQLException,ClassNotFoundException {
        List<Indicador>indicadors=new LinkedList<>();
        String sql="SELECT * FROM Indicadores WHERE idContratista = ? AND periodo = ? AND año = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setString(2,mes);
        ps.setInt(3,year);
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
            indicador.setYear(rs.getInt("año"));
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
            indicador.setYear(rs.getInt("año"));
            indicadors.add(indicador);
        }
        return indicadors;
    }
    public List<Indicador>reportePorMes(int idContratante,String mes,int year)throws SQLException,ClassNotFoundException{
       List<Indicador>indicadors=new LinkedList<>();
        String sql="SELECT * FROM Indicadores WHERE idContratante = ? AND periodo = ? AND año = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setString(2,mes);
        ps.setInt(3,year);
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
            indicador.setYear(rs.getInt("año"));
            indicadors.add(indicador);

        }
        Indicador indicadorResultdo=new Indicador();
        indicadorResultdo.setSeveridad((float) 0);
        indicadorResultdo.setFrecuencia((float) 0);
        indicadorResultdo.setMortalidad((float) 0);
        indicadorResultdo.setPrevalencia((float) 0);
        indicadorResultdo.setIncidencia((float) 0);
        indicadorResultdo.setAusentismo((float)0);
        for (Indicador i:indicadors){
            indicadorResultdo.setSeveridad(indicadorResultdo.getSeveridad()+i.getSeveridad());
            indicadorResultdo.setFrecuencia(indicadorResultdo.getFrecuencia()+i.getFrecuencia());
            indicadorResultdo.setMortalidad(indicadorResultdo.getMortalidad()+i.getMortalidad());
            indicadorResultdo.setPrevalencia(indicadorResultdo.getPrevalencia()+i.getPrevalencia());
            indicadorResultdo.setIncidencia(indicadorResultdo.getIncidencia()+i.getIncidencia());
            indicadorResultdo.setAusentismo(indicadorResultdo.getAusentismo()+i.getAusentismo());
        }
        indicadorResultdo.setSeveridad(indicadorResultdo.getSeveridad()/indicadors.size());
        indicadorResultdo.setFrecuencia(indicadorResultdo.getFrecuencia()/indicadors.size());
        indicadorResultdo.setMortalidad(indicadorResultdo.getMortalidad()/indicadors.size());
        indicadorResultdo.setPrevalencia(indicadorResultdo.getPrevalencia()/indicadors.size());
        indicadorResultdo.setIncidencia(indicadorResultdo.getIncidencia()/indicadors.size());
        indicadorResultdo.setAusentismo(indicadorResultdo.getAusentismo()/indicadors.size());
        indicadors=new LinkedList<>();
        indicadorResultdo.setIdContratante(idContratante);
        indicadorResultdo.setMes(mes);
        indicadorResultdo.setYear(year);
        indicadors.add(indicadorResultdo);
       return indicadors;
    }
    public List<Indicador>reportePorAño(int idContratante,int year)throws SQLException,ClassNotFoundException{
        List<Indicador>indicadors=new LinkedList<>();
        String sql="SELECT * FROM Indicadores WHERE idContratante = ? AND año = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,year);

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
            indicador.setYear(rs.getInt("año"));
            indicadors.add(indicador);

        }
        Indicador indicadorResultdo=new Indicador();
        indicadorResultdo.setSeveridad((float) 0);
        indicadorResultdo.setFrecuencia((float) 0);
        indicadorResultdo.setMortalidad((float) 0);
        indicadorResultdo.setPrevalencia((float) 0);
        indicadorResultdo.setIncidencia((float) 0);
        indicadorResultdo.setAusentismo((float)0);
        for (Indicador i:indicadors){
            indicadorResultdo.setSeveridad(indicadorResultdo.getSeveridad()+i.getSeveridad());
            indicadorResultdo.setFrecuencia(indicadorResultdo.getFrecuencia()+i.getFrecuencia());
            indicadorResultdo.setMortalidad(indicadorResultdo.getMortalidad()+i.getMortalidad());
            indicadorResultdo.setPrevalencia(indicadorResultdo.getPrevalencia()+i.getPrevalencia());
            indicadorResultdo.setIncidencia(indicadorResultdo.getIncidencia()+i.getIncidencia());
            indicadorResultdo.setAusentismo(indicadorResultdo.getAusentismo()+i.getAusentismo());
        }
        indicadorResultdo.setSeveridad(indicadorResultdo.getSeveridad()/indicadors.size());
        indicadorResultdo.setFrecuencia(indicadorResultdo.getFrecuencia()/indicadors.size());
        indicadorResultdo.setMortalidad(indicadorResultdo.getMortalidad()/indicadors.size());
        indicadorResultdo.setPrevalencia(indicadorResultdo.getPrevalencia()/indicadors.size());
        indicadorResultdo.setIncidencia(indicadorResultdo.getIncidencia()/indicadors.size());
        indicadorResultdo.setAusentismo(indicadorResultdo.getAusentismo()/indicadors.size());
        indicadors=new LinkedList<>();
        indicadorResultdo.setIdContratante(idContratante);
        indicadorResultdo.setYear(year);
        indicadors.add(indicadorResultdo);

        return indicadors;
    }
    public List<Contratista> sinRegistroDeIndicador(int idContratante, String mes, int year)throws SQLException,ClassNotFoundException{
        List<Contratista> contratistaList=new LinkedList<>();
        List<Contratista>contratistaEntrega=new LinkedList<>();
        String sql="SELECT co.idContratista,co.nombreEmpresa,co.nit,co.codigoCIIU,co.nombreGerente,co.email,co.arl,co.direccion,co.telefono,co.duracion,co.departamento,co.idContratante,co.personaContacto,co.cargoPer,co.telefonoCon,co.emailContacto  FROM contratista  AS co INNER JOIN finalista AS f  ON co.idContratista = f.idContratista  WHERE co.idContratante =  ? ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Contratista con = new Contratista();
            con.setId(rs.getInt("idContratista"));
            con.setNombreEmpresa(rs.getString("nombreEmpresa"));
            con.setNit(rs.getString("nit"));
            con.setCodigoCIIU(rs.getString("codigoCIIU"));
            con.setNombreDeGerenteGeneral(rs.getString("nombreGerente"));
            con.setEmail(rs.getString("email"));
            con.setArl(String.valueOf(rs.getInt("arl")));
            con.setDireccion(rs.getString("direccion"));
            con.setTelefono(rs.getNString("telefono"));
            con.setDuracionContrato(Integer.valueOf(rs.getString("duracion")));
            con.setDepartamento(String.valueOf(rs.getInt("departamento")));
            con.setContratante(rs.getInt("idContratante"));
            con.setPersonContacto(rs.getString("personaContacto"));
            con.setCargoPersonaContacto(rs.getString("cargoPer"));
            con.setTelefonoPersonaContacto(rs.getString("telefonoCon"));
            con.setEmailContacto(rs.getString("emailContacto"));
            contratistaList.add(con);
        }
        System.out.println(contratistaList.size());
       for (Contratista contra:contratistaList){
           System.out.println(contra.getId());
            String sql2="SELECT  COUNT(*) AS registro FROM Indicadores WHERE  idContratista= ? AND periodo= ? AND año = ? ; ";
            PreparedStatement ps2 = Conexion.conection().prepareStatement(sql2);
            ps2.setInt(1,contra.getId());
            ps2.setString(2,mes);
            ps2.setInt(3,year);
            ResultSet rs2 = ps2.executeQuery();
            int registro=0;
            while (rs2.next()){

               registro=rs2.getInt("registro");

            }
            boolean f =registro!=0;
           if (!f){

               contratistaEntrega.add(contra);
           }

        }
        ps.close();
        return contratistaEntrega;
    }

}
