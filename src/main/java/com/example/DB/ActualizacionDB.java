package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Contratista;
import com.example.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@Service
public class ActualizacionDB {
    public ArlBD arlBD;
    public DepartamentoDB departamentoDB;

    @Autowired
    public  ContratistasBD contratistasBD;
    public void actualizarInfoContratista(Contratista nuevoContratista) throws SQLException, ClassNotFoundException {
        int nivelDeRiesgo=contratistasBD.obtenerNivelDeRiesgo(nuevoContratista.getCodigoCIIU());
        Usuario nuevoUsuario =new Usuario();
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        departamentoDB=new DepartamentoDB();
        arlBD=new ArlBD();
        String sql = "UPDATE contratista  set nombreEmpresa = ?, nit= ?,nombreGerente = ?,arl = ?,direccion = ?,telefono = ?,departamento = ?,fecha_modificacion = ?,personaContacto = ?,cargoPer = ?,telefonoCon = ?,emailContacto = ? WHERE  idContratista = ?";
        Connection con =  Conexion.conection();
        nuevoContratista.setDepartamento(String.valueOf(departamentoDB.findAactivdad(nuevoContratista.getDepartamento())));
        nuevoContratista.setArl(String.valueOf(arlBD.findArl(nuevoContratista.getArl())));
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,nuevoContratista.getNombreEmpresa());
        ps.setString(2,nuevoContratista.getNit());
        ps.setString(3,nuevoContratista.getNombreDeGerenteGeneral());
        ps.setInt(4,Integer.valueOf(nuevoContratista.getArl()));
        ps.setString(5,nuevoContratista.getDireccion());
        ps.setString(6,nuevoContratista.getTelefono());
        ps.setInt(7,Integer.valueOf(nuevoContratista.getDepartamento()));
        ps.setDate(8, date);
        ps.setString(9,nuevoContratista.getPersonContacto());
        ps.setString(10,nuevoContratista.getCargoPersonaContacto());
        ps.setString(11,nuevoContratista.getTelefonoPersonaContacto());
        ps.setString(12,nuevoContratista.getEmailContacto());
        ps.setInt(13,nuevoContratista.getId());
        ps.executeUpdate();
        ps.close();
        con.close();


    }

}
