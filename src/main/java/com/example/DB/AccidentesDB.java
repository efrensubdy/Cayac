package com.example.DB;

import com.example.Models.Accidente;
import com.example.Models.Conexion;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 11/10/2017.
 */
@Service
public class AccidentesDB {
    /**
     * Método que se encarga de registrar el accidente en la base de datos
     * @param accidente objeto con la información del accidente
     * @throws SQLException conexion with mysql motor
     * @throws ClassNotFoundException
     */
    public void insertarAccidente(Accidente accidente)throws SQLException,ClassNotFoundException{
        //sentencia
        String sql="INSERT INTO accidentes (descripcion,primerApellido,segundoApellido,primerNombre,segundoNombre,identificacion,numero,nacimiento,sexo,departamento,muni,zonas,cargo,ingreso,accidente,hora,diaSe,jornada,sino,tipoA,lugari,depa,mun,zon,si2,tipoB,lesion,mecanismo,parte,agente,idContratista,idContratante) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //se inicia la conexión
        Connection con = Conexion.conection();
        //Se prepara la conculta
        PreparedStatement ps=con.prepareStatement(sql);
        //Se asignan los valores de tipo  ? de la consulta según su ubicación
        ps.setString(1,accidente.getDescripcion());
        ps.setString(2,accidente.getPrimerApellido());
        ps.setString(3,accidente.getSegundoApellido());
        ps.setString(4,accidente.getPrimerNombre());
        ps.setString(5,accidente.getSegundoNombre());
        ps.setString(6,accidente.getIdentificacion());
        ps.setInt(7,accidente.getNumero());
        ps.setDate(8,accidente.getNacimiento());
        ps.setString(9,accidente.getSexo());
        ps.setString(10,accidente.getDepartamento());
        ps.setString(11,accidente.getMuni());
        ps.setString(12,accidente.getZonas());
        ps.setString(13,accidente.getCargo());
        ps.setDate(14,accidente.getIngreso());
        ps.setDate(15,accidente.getAccidente());
        ps.setString(16,accidente.getHora());
        ps.setString(17,accidente.getDiaSe());
        ps.setString(18,accidente.getJornada());
        ps.setString(19,accidente.getSino());
        ps.setString(20,accidente.getTipoA());
        ps.setString(21,accidente.getLugari());
        ps.setString(22,accidente.getDepa());
        ps.setString(23,accidente.getMun());
        ps.setString(24,accidente.getZon());
        ps.setString(25,accidente.getSi2());
        ps.setString(26,accidente.getTipoB());
        ps.setString(27,accidente.getLesion());
        ps.setString(28,accidente.getMecanismo());
        ps.setString(29,accidente.getParte());
        ps.setString(30,accidente.getAgente());
        ps.setInt(31,accidente.getIdContratista());
        ps.setInt(32,accidente.getIdContratante());
        //Se ejecuta
        ps.execute();
        //Se cierran las conexiones
        ps.close();
        con.close();


    }

    /**
     * MÉTODO QUE SE ENCARFA DE TRAER EL ACCIDENTE POR CONTRATANTE
     * @param idContratista identificador del contratista
     * @param idContratante identificador del contratante
     * @return Listado con los accidentes pertenecientes a ese contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Accidente> consultarAccidentesporConContratista(int idContratista, int idContratante)throws SQLException,ClassNotFoundException{
        List<Accidente>accidenteList=new LinkedList<>();
        //Se realiza la setencia
        String sql="SELECT * FROM accidentes WHERE idContratista = ? AND idContratante = ?;";
        //Se realiza la conexion
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        //Se establecen los parametros de consulta
        ps.setInt(1,idContratista);
        ps.setInt(2,idContratante);
        //Se ejecuta la consulta
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Accidente accidente=new Accidente();
            accidente.setId(rs.getInt("id"));
            accidente.setDescripcion(rs.getString("descripcion"));
            accidente.setPrimerApellido(rs.getString("primerApellido"));
            accidente.setSegundoApellido(rs.getString("segundoApellido"));
            accidente.setPrimerNombre(rs.getString("primerNombre"));
            accidente.setSegundoNombre(rs.getString("segundoNombre"));
            accidente.setIdentificacion(rs.getString("identificacion"));
            accidente.setNumero(rs.getInt("numero"));
            accidente.setNacimiento(rs.getDate("nacimiento"));
            accidente.setSexo(rs.getString("sexo"));
            accidente.setDepartamento(rs.getString("departamento"));
            accidente.setMuni(rs.getString("muni"));
            accidente.setZonas(rs.getString("zonas"));
            accidente.setCargo(rs.getString("cargo"));
            accidente.setIngreso(rs.getDate("ingreso"));
            accidente.setAccidente(rs.getDate("accidente"));
            accidente.setHora(rs.getString("hora"));
            accidente.setDiaSe(rs.getString("diaSe"));
            accidente.setJornada(rs.getString("jornada"));
            accidente.setSino(rs.getString("sino"));
            accidente.setTipoA(rs.getString("tipoA"));
            accidente.setLugari(rs.getString("lugari"));
            accidente.setDepa(rs.getString("depa"));
            accidente.setMun(rs.getString("mun"));
            accidente.setZon(rs.getString("zon"));
            accidente.setSi2(rs.getString("si2"));
            accidente.setTipoB(rs.getString("tipoB"));
            accidente.setLesion(rs.getString("lesion"));
            accidente.setMecanismo(rs.getString("mecanismo"));
            accidente.setParte(rs.getString("parte"));
            accidente.setAgente(rs.getString("agente"));
            accidente.setIdContratante(rs.getInt("idContratante"));
            accidente.setIdContratista(rs.getInt("idContratista"));
            accidenteList.add(accidente);
        }
        return accidenteList;
    }
}
