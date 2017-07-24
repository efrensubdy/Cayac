package com.example.DB;

import com.example.Models.ARL;
import com.example.Models.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 24/03/2017.
 */

public class ArlBD {
    public static int tamañoTabla;

    /**
     * Agrega una nueva arl a la base de datos
     * @param arl
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  void nuevarl(ARL arl)throws ClassNotFoundException,SQLException{
        consultarARLS();
        String sql = "INSERT INTO  arl(id,nameArl) VALUES(?,?)";
        Connection con =  Conexion.conection();
        arl.setId(tamañoTabla + 1);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,arl.getId());
        ps.setString(2, arl.getName());
        ps.execute();
        ps.close();
        con.close();


    }

    /**
     *
     * @return una lista con las ARL's que esten registradas en la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<ARL> consultarARLS() throws ClassNotFoundException, SQLException{
        List<ARL> arls = new LinkedList<>();
        String sql ="SELECT * FROM  arl";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ARL na=new ARL();
            na.setId(rs.getInt("id"));
            na.setName(rs.getString("nameArl"));

            arls.add(na);
        }
        ps.close();
        tamañoTabla=arls.size();
        return arls;
    }

    /**
     *
     * @param nameArl
     * @return retorna un entero
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int findArl(String nameArl) throws SQLException, ClassNotFoundException {
        List<ARL> arls=consultarARLS();
        ARL a=null;
        for (int i=0;i<arls.size();i++){
            if(arls.get(i).getName().equals(nameArl)){
                a=arls.get(i);
            }

        }
        return a.getId();
    }



}



