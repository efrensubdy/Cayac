package com.example.DB;

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
    /**
     * Método que consulta si un acción ya se registro en la base de datos
     * @param idContratista identificador del contratista
     * @param idCausa identificador de la causa a la que pertence la acción
     * @return true / false si se encuentra el registro en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Método que se encarga de reghistrar la acción en la base de datos sin registrar el soporte del documento
     * @param accion objeto con la información de la acción que se va registrar
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarAccion2(Accion accion)throws SQLException,ClassNotFoundException,IOException{
        System.out.println(accion.getNombre());
        //Se realiza la fecha del registro
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO accion (idContratista,idCausa,nombre,registro,date) VALUES(?,?,?,?,?)";
        Connection con = Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accion.getIdContratista());
        ps.setInt(2, accion.getIdCausa());
        ps.setString(3, accion.getNombre());
        //Se llena como null el registro debido a que no tiene un documento asociado en el momento
        ps.setNull(4, Types.VARCHAR);
        ps.setDate(5, date);
        ps.execute();
        ps.close();
        con.close();





    }

    /**
     * Método que registra el cierra de una no conformidad en la base de datos
     * @param cierre objeto con la información del cierre de la no conformidad
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void registrarCierre(Cierre cierre)throws SQLException,ClassNotFoundException{
        //Fecha de registro del cierra
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        //Se prepara la setencia
        String sql = "INSERT INTO cierreDeNoConfor (idNoConformidad,idContratista,date) VALUES(?,?,?)";
        //Se realiza la conexión
        Connection con = Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        //Se establecen los parametros para inserción
        ps.setInt(1, cierre.getIdNoConformidad());
        ps.setInt(2, cierre.getIdContratista());
        ps.setDate(3, date);
        //Se ejecuta
        ps.execute();
        //Se CIERRA LA CONEXIÓN
        ps.close();
        con.close();

    }

    /**
     * Método consulta si una no conformidad efectivamente  si esta cerrada
     * @param idNoConformidad identificador de la no conformidad que se quiere consultar
     * @param idContratista identificador del contratista a quien pertenece la no conformidad
     * @return true /false si efectivamente esta cerrada la noConformidad
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
        //si el registro es cero es que no se ecuentra cerrada
        if (registro == 0) {
            flag = false;
        } else {
            flag = true;
        }
        ps.close();

        return flag;
    }

    /**
     * Método que consulta si una acción tiene efectivamente un soporte documental
     * @param id identificador de la acción
     * @param idContratista
     * @param idCausa
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Método que registra l acción y su soporte en la base de datos o actualiza el documento
     * @param accion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarAccion(Accion accion) throws SQLException, ClassNotFoundException, IOException {

        String fileType = getFileExtension(accion.getRegistro());
        boolean flag=consultarRegistro(accion.getId(),accion.getIdContratista(),accion.getIdCausa());
        //Si no hay registro
        if(!flag){
            String sql ="UPDATE accion SET registro = ? WHERE id= ? and idContratista= ? and idCausa= ?;";
            Connection con=Conexion.conection();
            //Se pone la ruta donde se encuentra el documento
            accion.setRegistro2("Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() + "."+getFileExtension(accion.getRegistro()));
            File f=accion.getRegistro();
            //Se mueve el archivo a la ruta del repositorio
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
        //Si hay registro
        else{
            //Se elimina el archivo anterior del repositorio
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+accion.getIdContratista()+"/estatico/"+accion.getIdCausa()+"CausaAccion" + accion.getId() + "."+getFileExtension(accion.getRegistro()));
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);

            }
            //Se mueve el nuevo documento
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

    /**
     * Método que trae todas las no conformidades cerradas de un contratista
     * @param idContratista identificador del contratista
     * @return Listadp con las actividades cerradas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Cierre>actividadesCerradas(int idContratista)throws SQLException,ClassNotFoundException{

        List<Cierre> cierreList = new LinkedList<>();
        //Se prepara la sentncia
        String sql ="SELECT * FROM  cierreDeNoConfor where idContratista = ?";
        //se prepara la conexion
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        //se establecen los parametros de consulta
        ps.setInt(1,idContratista);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Cierre cierre = new Cierre();
            cierre.setId(rs.getInt("id"));
            cierre.setIdNoConformidad(rs.getInt("idNoConformidad"));
            cierre.setIdContratista(rs.getInt("idContratista"));
            cierreList.add(cierre);

        }
        //SE cierran la conexión
        ps.close();

        return cierreList;



    }

    public List<Cierre>actividadesCerradas(int idContratista,int idAuditoria)throws SQLException,ClassNotFoundException{

        List<Cierre> cierreList = new LinkedList<>();
        String sql ="SELECT cierreDeNoConfor.id,cierreDeNoConfor.idNoConformidad,cierreDeNoConfor.idContratista FROM cierreDeNoConfor INNER JOIN noConformidad ON noConformidad.id = cierreDeNoConfor.idNoConformidad WHERE cierreDeNoConfor.idContratista = ? AND noConformidad.idAuditoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idAuditoria);
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

    /**
     * Método que se encarga de traer las acciones asociadas a una causa
     * @param idContratista identificador del contratista
     * @param idCausa identificador de la causa a la que pertencen la acciones
     * @return Listado con las acciones asocidas a la contratista y causa
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Método que trae todas las acciones que tenga un documento asociado
     * @param idContratista identificador del contratista
     * @param idCausa identificador de la causa a la que pertencen la acciones
     * @return Listado con las acciones que tienen un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accion> traerAccionesConRegistro(int idContratista,int idCausa)throws SQLException,ClassNotFoundException{
        List<Accion>accionList=new LinkedList<>();
        //Se prepara la consulta trayendo solo aquellas acciones que tengan registro y pertenezcan  a la causa que se requiere
        String sql ="SELECT * FROM accion LEFT JOIN causa ON causa.id = accion.idCausa WHERE accion.idContratista= ? AND accion.idCausa= ? AND accion.registro IS NOT NULL";
        //Se realiza la conexión
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        //Se establecen los parametros de busqueda
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
    /**
     * Método que trae todas las acciones que no tengan un documento asociado
     * @param idContratista identificador del contratista
     * @param idCausa identificador de la causa a la que pertencen la acciones
     * @return Listado con las acciones que no  tienen un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accion> traerAccionesSinRegistro(int idContratista,int idCausa)throws SQLException,ClassNotFoundException{
        List<Accion>accionList=new LinkedList<>();
        //Se prepara la consulta trayendo solo aquellas acciones que tengan registro y pertenezcan  a la causa que se requiere
        String sql ="SELECT * FROM accion LEFT JOIN causa ON causa.id = accion.idCausa WHERE accion.idContratista= ? AND accion.idCausa= ? AND accion.registro IS NULL";
        //Se realiza la conexión
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        //Se establecen los parametros de busqueda
        ps.setInt(1,idContratista);
        ps.setInt(2,idCausa);
        //Se ejecuta la consulta
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

    /**
     * Se obtiene la extensión del archivo
     * @param fullName archivo que se quiere saber la extensión
     * @return String con la extensión
     */
    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

}
