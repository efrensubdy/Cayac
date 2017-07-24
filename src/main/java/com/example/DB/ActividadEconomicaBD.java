package com.example.DB;

import com.example.Models.ActividadEconomica;
import com.example.Models.Conexion;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 29/03/2017.
 */
@Service
public class ActividadEconomicaBD {
    public  int tamañoTabla;

    /**
     *
     * @return lista con todas las actividades economicas dentro de la base de datos
      * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<ActividadEconomica> consultarActividadesEconomicas() throws ClassNotFoundException, SQLException{
        List<ActividadEconomica> actividadEconomica = new LinkedList<>();
        String sql ="SELECT * FROM  activdadeconomica";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ActividadEconomica ae=new ActividadEconomica();
            ae.setCodigoCUU(rs.getInt("codigoCIIU"));
            ae.setDescripcion(rs.getString("descripcion"));
            ae.setNivelDeRiesgo(rs.getInt("nivelDeRiesgo"));

            actividadEconomica.add(ae);
        }
        ps.close();


        tamañoTabla=actividadEconomica.size();
        return actividadEconomica;
    }

    /**
     * @param numeroActividad numero de actividad de empresa
     * @return retorna la actividad de la empresa que esta en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  int findAactivdad(int numeroActividad) throws SQLException, ClassNotFoundException {
        List<ActividadEconomica> ae=consultarActividadesEconomicas();
        ActividadEconomica a=null;
        for (int i=0;i<ae.size();i++){
            if(ae.get(i).getCodigoCUU()==numeroActividad){
                a=ae.get(i);
            }

        }
        return a.getCodigoCUU();
    }

}
