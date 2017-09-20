package com.example.DB;

import com.example.Models.*;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
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
    java.util.Date utilDate = new Date();
    java.sql.Date date = new java.sql.Date(utilDate.getTime());
    String sql="INSERT INTO planDeTrabajo (mes,actividad,fechaInicio,fechaFin,evidencia,idContratista,fechaDeRegistro) VALUES (?,?,?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,plan.getMes());
    ps.setString(2,plan.getNombre());
    ps.setDate(3,plan.getFechaInicio());
    ps.setDate(4,plan.getFechaFin());
    ps.setNull(5, Types.VARCHAR);
    ps.setInt(6,plan.getIdContratista());
    ps.setDate(7,date);
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
        if(planDeTrabajo.getEvidencia()==null){
            planDeTrabajo.setEstado(false);
        }
        else{
            planDeTrabajo.setEstado(true);
        }
        planDeTrabajo.setIdContratista(rs.getInt("idContratista"));
        planDeTrabajo.setFechaInicio(rs.getDate("fechaInicio"));
        planDeTrabajo.setFechaFin(rs.getDate("fechaFin"));
        planDeTrabajoList.add(planDeTrabajo);

    }

    return planDeTrabajoList;
}
    public List<PlanDeTrabajo>consultarActividadesdelPlanDeTrabajoConSoporte(int idContratista,String mes)throws SQLException,ClassNotFoundException {
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
            if(planDeTrabajo.getEvidencia()==null){
                planDeTrabajo.setEstado(false);
            }
            else{
                planDeTrabajo.setEstado(true);
            }
            planDeTrabajo.setIdContratista(rs.getInt("idContratista"));
            planDeTrabajo.setFechaInicio(rs.getDate("fechaInicio"));
            planDeTrabajo.setFechaFin(rs.getDate("fechaFin"));
            if (planDeTrabajo.isEstado()){
                planDeTrabajoList.add(planDeTrabajo);
            }


        }

        return planDeTrabajoList;
    }
    public List<PlanDeTrabajo>consultarActividadesdelPlanDeTrabajoSinSoporte(int idContratista,String mes)throws SQLException,ClassNotFoundException {
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
            if(planDeTrabajo.getEvidencia()==null){
                planDeTrabajo.setEstado(false);
            }
            else{
                planDeTrabajo.setEstado(true);
            }
            planDeTrabajo.setIdContratista(rs.getInt("idContratista"));
            planDeTrabajo.setFechaInicio(rs.getDate("fechaInicio"));
            planDeTrabajo.setFechaFin(rs.getDate("fechaFin"));
            if (!planDeTrabajo.isEstado()){
                planDeTrabajoList.add(planDeTrabajo);
            }


        }
        return planDeTrabajoList;
    }
    public List<Contratista>pendientesSinSoporte(int idContratante , String mes )throws SQLException,ClassNotFoundException{
        List<Contratista> contratistaList=new LinkedList<>();
        String sql="SELECT co.idContratista,co.nombreEmpresa,co.nit,co.codigoCIIU,co.nombreGerente,co.email,co.arl,co.direccion,co.telefono,co.duracion,co.departamento,co.idContratante,co.personaContacto,co.cargoPer,co.telefonoCon,co.emailContacto FROM planDeTrabajo AS pt  INNER JOIN contratista AS co INNER JOIN Aprobacion AS a   WHERE pt.idContratista=co.idContratista AND a.idContratista=pt.idContratista AND  pt.evidencia IS NULL AND co.idContratante= ? AND  pt.mes = ? GROUP BY pt.idContratista;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setString(2,mes);
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

    return contratistaList;
    }
    public boolean consultarRegistro(int id,int idContratista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from planDeTrabajo where id= ? and idContratista=? and evidencia is not null;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,id);
        ps.setInt(2,idContratista);
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

public void actualizarSoporte(Documento documento)throws SQLException,ClassNotFoundException,IOException{
    System.out.println(documento.getFile().getName());
    String fileType = getFileExtension(documento.getFile());
    documento.setTipo(fileType);
    boolean flag=consultarRegistro(documento.getId(),documento.getIdContratista());
    if(!flag){
        String sql ="UPDATE planDeTrabajo SET evidencia = ? WHERE id= ? and idContratista= ?;";
        Connection con=Conexion.conection();
        documento.setContenido("Repository/Contratista/"+documento.getIdContratista()+"/dinamico/"+documento.getId()+"Actividad" +"."+documento.getTipo());
        File f=documento.getFile();
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documento.getIdContratista()+"/dinamico/"+documento.getId()+"Actividad" +"."+documento.getTipo());
        FileUtils.moveFile(f,q);
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,documento.getContenido());
        ps.setInt(2,documento.getId());
        ps.setInt(3,documento.getIdContratista());
        ps.execute();
        ps.close();
        con.close();
    }
    else{
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documento.getIdContratista()+"/dinamico/"+documento.getId()+"Actividad" +"."+documento.getTipo());
        if (q.isFile()) {
            FileUtils.deleteQuietly(q);

        }
        String sql ="UPDATE planDeTrabajo SET evidencia = ? WHERE id= ? and idContratista= ?;";
        Connection con=Conexion.conection();
        documento.setContenido("Repository/Contratista/"+documento.getIdContratista()+"/dinamico/"+documento.getId()+"Actividad" +"."+documento.getTipo());
        File f=documento.getFile();
        File y=new File("src/main/resources/static/app/Repository/Contratista/"+documento.getIdContratista()+"/dinamico/"+documento.getId()+"Actividad" +"."+documento.getTipo());
        FileUtils.moveFile(f,y);
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,documento.getContenido());
        ps.setInt(2,documento.getId());
        ps.setInt(3,documento.getIdContratista());
        ps.execute();
        ps.close();
        con.close();

    }


}

    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


}
