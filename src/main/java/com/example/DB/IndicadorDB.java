package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Indicador;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        ps.execute();
        ps.close();
        con.close();


    }

}
