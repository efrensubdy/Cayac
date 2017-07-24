package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Departamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 29/03/2017.
 */
public class DepartamentoDB {
    public int tamañoTabla;

    /**
     *
     * @return lista con todos los departamentos de la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Departamento> consultarDepartamentos() throws ClassNotFoundException, SQLException {
        List<Departamento> departamentos = new LinkedList<>();
        String sql ="SELECT * FROM departamento";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Departamento depa=new Departamento ();
            depa.setIdDepartamento(rs.getInt("idDepartamento"));
            depa.setNombreDepa(rs.getString("nombreDepa"));
            depa.setIdCiu(rs.getInt("idCiu"));

            departamentos.add(depa);
        }
        ps.close();

        tamañoTabla=departamentos.size();
        return departamentos;
    }

    /**
     *
     * @param nameDpto
     * @return el numero de ciudad
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int findAactivdad(String nameDpto) throws SQLException, ClassNotFoundException {

        List<Departamento> dpto=consultarDepartamentos();
        Departamento a=null;
        for (int i=0;i<dpto.size();i++){

            if(dpto.get(i).getNombreDepa().equals(nameDpto)){
                a=dpto.get(i);



            }

        }
        return a.getIdDepartamento();
    }

}
