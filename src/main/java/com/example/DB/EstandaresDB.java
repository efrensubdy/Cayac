package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.EstandarMinimo;
import com.example.Models.Indicador;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 18/10/2017.
 */
@Service
public class EstandaresDB {
    public void insertarEstandarMinimo(EstandarMinimo estandarMinimo)throws ClassNotFoundException,SQLException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        estandarMinimo.setFechaDeRegistro(date);
        String sql="INSERT INTO estandaresMinimos (recursos,capacitacion,politica,objetivos,evaInicial,planAnual,documen,cuentas,normatividad,mecanismos,adquisiones,contrataciones,cambios,condiciones,registro,vigilancia,peligros,prevencion,planPrevencion,gestion,accionesPreven,idContratista,idContratante,fechaDeRegistro) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = Conexion.conection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setFloat(1,estandarMinimo.getRecursos());
        ps.setFloat(2,estandarMinimo.getCapacitacion());
        ps.setFloat(3,estandarMinimo.getPolitica());
        ps.setFloat(4,estandarMinimo.getObjetivos());
        ps.setFloat(5,estandarMinimo.getEvaInicial());
        ps.setFloat(6,estandarMinimo.getPlanAnual());
        ps.setFloat(7,estandarMinimo.getDocumen());
        ps.setFloat(8,estandarMinimo.getCuentas());
        ps.setFloat(9,estandarMinimo.getNormatividad());
        ps.setFloat(10,estandarMinimo.getMecanismos());
        ps.setFloat(11,estandarMinimo.getAdquisiones());
        ps.setFloat(12,estandarMinimo.getContrataciones());
        ps.setFloat(13,estandarMinimo.getCambios());
        ps.setFloat(14,estandarMinimo.getCondiciones());
        ps.setFloat(15,estandarMinimo.getRegistro());
        ps.setFloat(16,estandarMinimo.getVigilancia());
        ps.setFloat(17,estandarMinimo.getPeligros());
        ps.setFloat(18,estandarMinimo.getPrevencion());
        ps.setFloat(19,estandarMinimo.getPlanPrevencion());
        ps.setFloat(20,estandarMinimo.getGestion());
        ps.setFloat(21,estandarMinimo.getAccionesPreven());
        ps.setInt(22,estandarMinimo.getIdContratista());
        ps.setInt(23,estandarMinimo.getIdContratante());
        ps.setDate(24,estandarMinimo.getFechaDeRegistro());
        ps.execute();
        ps.close();
        con.close();
    }
    public List<EstandarMinimo>consultarEstandaresMinimosPorContratista(int idContratista,int idContratante)throws ClassNotFoundException,SQLException{
        List<EstandarMinimo> estandarMinimos=new LinkedList<>();
        String sql="SELECT * FROM estandaresMinimos WHERE idContratista = ? AND idContratante = ? ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idContratante);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            EstandarMinimo estandarMinimo=new EstandarMinimo();
            estandarMinimo.setId(rs.getInt("id"));
            estandarMinimo.setRecursos(rs.getFloat("recursos"));
            estandarMinimo.setPolitica(rs.getFloat("politica"));
            estandarMinimo.setObjetivos(rs.getFloat("objetivos"));
            estandarMinimo.setEvaInicial(rs.getFloat("evaInicial"));
            estandarMinimo.setPlanAnual(rs.getFloat("planAnual"));
            estandarMinimo.setDocumen(rs.getFloat("documen"));
            estandarMinimo.setCuentas(rs.getFloat("cuentas"));
            estandarMinimo.setNormatividad(rs.getFloat("normatividad"));
            estandarMinimo.setMecanismos(rs.getFloat("mecanismos"));
            estandarMinimo.setAdquisiones(rs.getFloat("adquisiones"));
            estandarMinimo.setContrataciones(rs.getFloat("contrataciones"));
            estandarMinimo.setCambios(rs.getFloat("cambios"));
            estandarMinimo.setCondiciones(rs.getFloat("condiciones"));
            estandarMinimo.setRegistro(rs.getFloat("registro"));
            estandarMinimo.setVigilancia(rs.getFloat("vigilancia"));
            estandarMinimo.setPeligros(rs.getFloat("peligros"));
            estandarMinimo.setPrevencion(rs.getFloat("prevencion"));
            estandarMinimo.setPlanPrevencion(rs.getFloat("planPrevencion"));
            estandarMinimo.setAccionesPreven(rs.getFloat("accionesPreven"));
            estandarMinimo.setGestion(rs.getFloat("gestion"));
            estandarMinimo.setIdContratista(rs.getInt("idContratista"));
            estandarMinimo.setIdContratante(rs.getInt("idContratante"));
            estandarMinimo.setFechaDeRegistro(rs.getDate("fechaDeRegistro"));
            estandarMinimos.add(estandarMinimo);

        }

        return estandarMinimos;
    }
}
