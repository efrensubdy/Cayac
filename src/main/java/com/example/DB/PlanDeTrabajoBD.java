package com.example.DB;

import com.example.Models.Aprobacion;
import com.example.Models.Conexion;
import com.example.Models.PlanDeTrabajo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 12/09/2017.
 */
@Service
public class PlanDeTrabajoBD {

public void agregarPlanDeTrabajo(PlanDeTrabajo plan)throws SQLException,ClassNotFoundException{
    System.out.println(plan.getNombre());
    String sql="INSERT INTO planDeTrabajo (mes,actividad,fechaInicio,fechaFin,evidencia,idContratista) VALUES (?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,plan.getMes());
    ps.setString(2,plan.getNombre());
    ps.setDate(3,plan.getFechaInicio());
    ps.setDate(4,plan.getFechaFin());
    ps.setNull(5, Types.VARCHAR);
    ps.setInt(6,plan.getIdContratista());
    ps.execute();
    ps.close();
    con.close();
}
public boolean tieneAprobacion( int idContratista,int idContratante)throws SQLException,ClassNotFoundException{
  boolean flag=false;
    int registro=0;
    String sql="SELECT COUNT(*) AS registro FROM Aprobacion WHERE idContratista = ? AND idContratante =?";
    PreparedStatement ps = Conexion.conection().prepareStatement(sql);
    ps.setInt(1,idContratista);
    ps.setInt(2,idContratante);
    ResultSet rs =ps.executeQuery();
    while (rs.next()){
        registro=rs.getInt("registro");

    }
    if(registro !=0){
        flag=true;

    }
  return flag;
}
public void agregarAprobacion(Aprobacion aprobacion)throws SQLException,ClassNotFoundException{
    System.out.println("dcsddsfsd");
    String sql="INSERT INTO Aprobacion (idContratista,idContratante) VALUES (?,?)";
    Connection con =Conexion.conection();
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setInt(1,aprobacion.getIdContratista());
    ps.setInt(2,aprobacion.getIdContratante());
    ps.execute();
    ps.close();
    con.close();

}
public List<PlanDeTrabajo>consultarActividadesdelPlanDeTrabajo(int idContratista,String mes)throws SQLException,ClassNotFoundException {
    System.out.println(idContratista);
    List<PlanDeTrabajo> planDeTrabajoList = new LinkedList<>();
    String sql="SELECT * FROM planDeTrabajo WHERE idContratista = ? AND mes = ?;";
    PreparedStatement ps = Conexion.conection().prepareStatement(sql);
    ps.setInt(1,idContratista);
    ps.setString(2,mes);
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
        PlanDeTrabajo planDeTrabajo=new PlanDeTrabajo();
        planDeTrabajo.setId(rs.getInt("id"));
        planDeTrabajo.setNombre(rs.getString("actividad"));
        planDeTrabajo.setMes(rs.getString("mes"));
        planDeTrabajo.setEvidencia(rs.getString("evidencia"));
        planDeTrabajo.setIdContratista(rs.getInt("idContratista"));
        planDeTrabajo.setFechaInicio(rs.getDate("fechaInicio"));
        planDeTrabajo.setFechaFin(rs.getDate("fechaFin"));
        planDeTrabajoList.add(planDeTrabajo);

    }

    return planDeTrabajoList;
}




}
