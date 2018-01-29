package com.example.DB;


import com.example.Models.Causa;
import com.example.Models.Conexion;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 25/10/2017.
 */
@Service
public class CausaDB {
    /**
     * Método que se encarga de registrar la causa en la bse de datos
     * @param causa
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarCausa(Causa causa)throws SQLException,ClassNotFoundException{
        System.out.println(causa.getCausa());
        //Se prepara la consulta
        String sql = "INSERT INTO  causa(causa,idContratista,idNoConformidad) VALUES(?,?,?)";
        //Se establece la conexión
        Connection con =  Conexion.conection();
        //Se ejecuta la sentecia
        PreparedStatement ps = con.prepareStatement(sql);
        //Se establecen los parametros
        ps.setString(1,causa.getCausa());
        ps.setInt(2,causa.getIdContratista());
        ps.setInt(3,causa.getIdNoConformidad());
        //Se ejectua
        ps.execute();
        //Se cierra la conexión
        ps.close();
        con.close();


    }

    /**
     * Método que trae las causas que pertencen las no conformidades de un contratistaespecíficos
     * @param idContratista identificador del contratista
     * @param idNoConformidad identifcador de la no conformidad
     * @return Listado con todas las causas que pertencen a la no conformidad y al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Causa> traerCausasPorContratista(int idContratista,int idNoConformidad)throws SQLException,ClassNotFoundException{
        List<Causa>causaList=new LinkedList<>();
        String sql ="SELECT * FROM  causa WHERE idContratista = ? and idNoConformidad=?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idNoConformidad);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
           Causa causa=new Causa();
           causa.setId(rs.getInt("id"));
           causa.setCausa(rs.getString("causa"));
           causa.setIdContratista(rs.getInt("idContratista"));
           causa.setIdNoConformidad(rs.getInt("idNoConformidad"));
           causaList.add(causa);
        }
        ps.close();
        return causaList;
    }

}
