package com.example.DB;

import com.example.Models.Actividad;
import com.example.Models.Conexion;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 12/07/2017.
 */
@Service
public class ActividadesDB {

public void agregarActividadPreviaSugerida(Actividad actividad)throws SQLException,ClassNotFoundException{

    String sql = "INSERT INTO  actprevsuger(idRequisito,idFinalista,nombre,fechaDeEjecucion,responsable,estado) VALUES(?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,actividad.getIdRequisito());
    ps.setInt(2,actividad.getIdFinalista());
    ps.setString(3,actividad.getNombre());
    ps.setDate(4,actividad.getFechaEjecucion());
    ps.setString(5,actividad.getResponsable());
    ps.setString(6,actividad.getEstado());
    ps.execute();
    ps.close();
    con.close();




}
public List<Actividad>traeactividadesPreviasSugeridas(int idFinalista,int idRequisito)throws SQLException,ClassNotFoundException{

    List<Actividad>actividades=new LinkedList<>();
    String sql ="select * from  actprevsuger where idFinalista= ? and idRequisito = ?;";
    PreparedStatement ps = Conexion.conection().prepareStatement(sql);
    ps.setInt(1,idFinalista);
    ps.setInt(2,idRequisito);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        Actividad actividad=new Actividad();
        actividad.setId(rs.getInt("id"));
        actividad.setIdRequisito(rs.getInt("idRequisito"));
        actividad.setIdFinalista(rs.getInt("idFinalista"));
        actividad.setNombre(rs.getString("nombre"));
        actividad.setFechaEjecucion(rs.getDate("fechaDeEjecucion"));
        actividad.setFechaEjecutada(rs.getDate("fechaEjecutada"));
        actividad.setResponsable(rs.getString("responsable"));
        actividad.setContenido(rs.getString("contenido"));
        if(actividad.getContenido()!=null){
            actividad.setMotrar(true);
            actividad.setComparacion(comparaFechas(actividad.getFechaEjecucion(),actividad.getFechaEjecutada()));

        }
        else{
           actividad.setMotrar(false);
           actividad.setComparacion("No subida");
        }
        actividad.setTipo(rs.getString("tipo"));
        actividad.setEstado(rs.getString("estado"));
        actividades.add(actividad);




    }
    ps.close();



    return actividades;
}


public void agregarActividadPreviaExtra(Actividad actividad)throws SQLException,ClassNotFoundException{
    String sql = "INSERT INTO  actprevext(idRequisito,idFinalista,nombre,fechaDeEjecucion,responsable,estado) VALUES(?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,actividad.getIdRequisito());
    ps.setInt(2,actividad.getIdFinalista());
    ps.setString(3,actividad.getNombre());
    ps.setDate(4,actividad.getFechaEjecucion());
    ps.setString(5,actividad.getResponsable());
    ps.setString(6,actividad.getEstado());
    ps.execute();
    ps.close();
    con.close();





}
    public List<Actividad>traeactividadesPreviasExtras(int idFinalista , int idRequisito)throws SQLException,ClassNotFoundException{

        List<Actividad>actividades=new LinkedList<>();
        String sql ="select * from  actprevext where idFinalista= ?  and idRequisito= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idFinalista);
        ps.setInt(2,idRequisito);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Actividad actividad=new Actividad();
            actividad.setId(rs.getInt("id"));
            actividad.setIdRequisito(rs.getInt("idRequisito"));
            actividad.setIdFinalista(rs.getInt("idFinalista"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setFechaEjecucion(rs.getDate("fechaDeEjecucion"));
            actividad.setFechaEjecutada(rs.getDate("fechaEjecutada"));
            actividad.setResponsable(rs.getString("responsable"));
            actividad.setContenido(rs.getString("contenido"));
            if(actividad.getContenido()!=null){
                actividad.setMotrar(true);
                actividad.setComparacion(comparaFechas(actividad.getFechaEjecucion(),actividad.getFechaEjecutada()));

            }
            else{
                actividad.setMotrar(false);
                actividad.setComparacion("No subida");
            }
            actividad.setTipo(rs.getString("tipo"));
            actividad.setEstado(rs.getString("estado"));
            actividades.add(actividad);





        }

        ps.close();


        return actividades;
    }



    public void agregarActividadEjecucionSugerida(Actividad actividad)throws SQLException,ClassNotFoundException{

    String sql = "INSERT INTO  actejecsug(idRequisito,idFinalista,nombre,fechaDeEjecucion,responsable,estado) VALUES(?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,actividad.getIdRequisito());
    ps.setInt(2,actividad.getIdFinalista());
    ps.setString(3,actividad.getNombre());
    ps.setDate(4,actividad.getFechaEjecucion());
    ps.setString(5,actividad.getResponsable());
    ps.setString(6,actividad.getEstado());
    ps.execute();
    ps.close();
    con.close();



}



    public List<Actividad>traeactividadesEjucionSugeridas(int idFinalista , int idRequisito)throws SQLException,ClassNotFoundException {

        List<Actividad> actividades = new LinkedList<>();
        String sql = "select * from  actejecsug where idFinalista= ?  and idRequisito= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1, idFinalista);
        ps.setInt(2, idRequisito);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Actividad actividad = new Actividad();
            actividad.setId(rs.getInt("id"));
            actividad.setIdRequisito(rs.getInt("idRequisito"));
            actividad.setIdFinalista(rs.getInt("idFinalista"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setFechaEjecucion(rs.getDate("fechaDeEjecucion"));
            actividad.setFechaEjecutada(rs.getDate("fechaEjecutada"));
            actividad.setResponsable(rs.getString("responsable"));
            actividad.setContenido(rs.getString("contenido"));
            if(actividad.getContenido()!=null){
                actividad.setMotrar(true);
                actividad.setComparacion(comparaFechas(actividad.getFechaEjecucion(),actividad.getFechaEjecutada()));

            }
            else{
                actividad.setMotrar(false);
                actividad.setComparacion("No subida");
            }
            actividad.setTipo(rs.getString("tipo"));
            actividad.setEstado(rs.getString("estado"));
            actividades.add(actividad);



        }
        ps.close();
        return actividades;
    }

public void agregarActividadEjecucionExtra(Actividad actividad)throws SQLException,ClassNotFoundException{
    String sql = "INSERT INTO  actejecext(idRequisito,idFinalista,nombre,fechaDeEjecucion,responsable,estado) VALUES(?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,actividad.getIdRequisito());
    ps.setInt(2,actividad.getIdFinalista());
    ps.setString(3,actividad.getNombre());
    ps.setDate(4,actividad.getFechaEjecucion());
    ps.setString(5,actividad.getResponsable());
    ps.setString(6,actividad.getEstado());
    ps.execute();
    ps.close();
    con.close();





}

public List<Actividad>traeactividadesEjucionExtras(int idFinalista , int idRequisito)throws SQLException,ClassNotFoundException {

        List<Actividad> actividades = new LinkedList<>();
        String sql = "select * from  actejecext where idFinalista= ?  and idRequisito= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1, idFinalista);
        ps.setInt(2, idRequisito);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Actividad actividad = new Actividad();
            actividad.setId(rs.getInt("id"));
            actividad.setIdRequisito(rs.getInt("idRequisito"));
            actividad.setIdFinalista(rs.getInt("idFinalista"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setFechaEjecucion(rs.getDate("fechaDeEjecucion"));
            actividad.setFechaEjecutada(rs.getDate("fechaEjecutada"));
            actividad.setResponsable(rs.getString("responsable"));
            actividad.setContenido(rs.getString("contenido"));
            if(actividad.getContenido()!=null){
                actividad.setMotrar(true);
                actividad.setComparacion(comparaFechas(actividad.getFechaEjecucion(),actividad.getFechaEjecutada()));

            }
            else{
                actividad.setMotrar(false);
                actividad.setComparacion("No subida");
            }
            actividad.setTipo(rs.getString("tipo"));
            actividad.setEstado(rs.getString("estado"));
            actividades.add(actividad);



        }
    ps.close();
        return actividades;
    }


public void agregarActividadFinalizacionSugerido(Actividad actividad)throws SQLException,ClassNotFoundException{
    String sql = "INSERT INTO  actfinsug(idRequisito,idFinalista,nombre,fechaDeEjecucion,responsable,estado) VALUES(?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,actividad.getIdRequisito());
    ps.setInt(2,actividad.getIdFinalista());
    ps.setString(3,actividad.getNombre());
    ps.setDate(4,actividad.getFechaEjecucion());
    ps.setString(5,actividad.getResponsable());
    ps.setString(6,actividad.getEstado());
    ps.execute();
    ps.close();
    con.close();




 }

    public List<Actividad>traeactividadesFinalizacionSugeridos(int idFinalista , int idRequisito)throws SQLException,ClassNotFoundException {

        List<Actividad> actividades = new LinkedList<>();
        String sql = "select * from  actfinsug where idFinalista= ?  and idRequisito= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1, idFinalista);
        ps.setInt(2, idRequisito);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Actividad actividad = new Actividad();
            actividad.setId(rs.getInt("id"));
            actividad.setIdRequisito(rs.getInt("idRequisito"));
            actividad.setIdFinalista(rs.getInt("idFinalista"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setFechaEjecucion(rs.getDate("fechaDeEjecucion"));
            actividad.setFechaEjecutada(rs.getDate("fechaEjecutada"));
            actividad.setResponsable(rs.getString("responsable"));
            actividad.setContenido(rs.getString("contenido"));
            if(actividad.getContenido()!=null){
                actividad.setMotrar(true);
                actividad.setComparacion(comparaFechas(actividad.getFechaEjecucion(),actividad.getFechaEjecutada()));

            }
            else{
                actividad.setMotrar(false);
                actividad.setComparacion("No subida");
            }
            actividad.setTipo(rs.getString("tipo"));
            actividad.setEstado(rs.getString("estado"));
            actividades.add(actividad);


        }
        return actividades;
    }





public void agregarActividadFinalizacionExtra(Actividad actividad)throws SQLException,ClassNotFoundException{

    String sql = "INSERT INTO  actfinext(idRequisito,idFinalista,nombre,fechaDeEjecucion,responsable,estado) VALUES(?,?,?,?,?,?)";
    Connection con =  Conexion.conection();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,actividad.getIdRequisito());
    ps.setInt(2,actividad.getIdFinalista());
    ps.setString(3,actividad.getNombre());
    ps.setDate(4,actividad.getFechaEjecucion());
    ps.setString(5,actividad.getResponsable());
    ps.setString(6,actividad.getEstado());
    ps.execute();
    ps.close();
    con.close();



}


    public List<Actividad>traeactividadesFinalizacionExtras(int idFinalista , int idRequisito)throws SQLException,ClassNotFoundException {

        List<Actividad> actividades = new LinkedList<>();
        String sql = "select * from  actfinext where idFinalista= ?  and idRequisito= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1, idFinalista);
        ps.setInt(2, idRequisito);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Actividad actividad = new Actividad();
            actividad.setId(rs.getInt("id"));
            actividad.setIdRequisito(rs.getInt("idRequisito"));
            actividad.setIdFinalista(rs.getInt("idFinalista"));
            actividad.setNombre(rs.getString("nombre"));
            actividad.setFechaEjecucion(rs.getDate("fechaDeEjecucion"));
            actividad.setFechaEjecutada(rs.getDate("fechaEjecutada"));
            actividad.setResponsable(rs.getString("responsable"));
            actividad.setContenido(rs.getString("contenido"));
            if(actividad.getContenido()!=null){
                actividad.setMotrar(true);
                actividad.setComparacion(comparaFechas(actividad.getFechaEjecucion(),actividad.getFechaEjecutada()));

            }
            else{
                actividad.setMotrar(false);
                actividad.setComparacion("No subida");
            }
            actividad.setTipo(rs.getString("tipo"));
            actividad.setEstado(rs.getString("estado"));
            actividades.add(actividad);


        }
        ps.close();
        return actividades;
    }


    public String comparaFechas(java.sql.Date date1,java.sql.Date date2){

    String resultado="";

    Date fechaEjecucion=new java.util.Date(date1.getTime());
    Date fechaEjecudata=new java.util.Date(date2.getTime());
    if(fechaEjecucion.before(fechaEjecudata)){

        resultado="Subido a destiempo";
    }
    else if(fechaEjecucion.after(fechaEjecudata)){

        resultado="Subida a tiempo";
    }
    else if(fechaEjecucion.equals(fechaEjecudata)){
        resultado="Subida justo a tiempo";
    }




    return resultado;
    }



}
