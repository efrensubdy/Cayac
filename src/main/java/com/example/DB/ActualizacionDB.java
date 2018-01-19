package com.example.DB;

import com.example.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
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
    public void actualizarIndicadorContratista(Indicador indicador)throws SQLException,ClassNotFoundException{

        String sql="UPDATE Indicadores set  periodo = ? , responsable = ? , departamento = ?, actividad = ?, severidad = ?, frecuencia = ?,mortalidad = ?,prevalencia = ?,incidencia = ?,ausentismo = ?,idContratista = ?,año = ? where id= ?";
        Connection con = Conexion.conection();
        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,indicador.getMes());
        ps.setString(2,indicador.getResponsable());
        ps.setString(3,indicador.getDepartamento());
        ps.setString(4,indicador.getActividad());
        ps.setFloat(5,indicador.getSeveridad());
        ps.setFloat(6,indicador.getFrecuencia());
        ps.setFloat(7,indicador.getMortalidad());
        ps.setFloat(8,indicador.getPrevalencia());
        ps.setFloat(9,indicador.getIncidencia());
        ps.setFloat(10,indicador.getAusentismo());
        ps.setInt(11,indicador.getIdContratista());;
        ps.setInt(12,indicador.getYear());
        ps.setInt(13,indicador.getId());
        ps.executeUpdate();
        ps.close();
        con.close();



    }
    public void actualizarAccidentesContratistas(Accidente accidente)throws SQLException,ClassNotFoundException{

        String sql="UPDATE accidentes set descripcion = ?,primerApellido = ?,segundoApellido = ?,primerNombre = ?,segundoNombre = ?,identificacion = ?,numero = ?,nacimiento = ?,sexo = ?,departamento = ?,muni = ?,zonas = ?,cargo = ?,ingreso = ?,accidente = ?,hora = ?,diaSe = ?,jornada = ?,sino = ?,tipoA = ?,lugari = ?,depa = ?,mun = ?,zon = ?,si2 = ?,tipoB = ?,lesion = ?,mecanismo = ?,parte = ?,agente = ?,idContratista = ?,idContratante = ? WHERE id =?";
        Connection con = Conexion.conection();
        PreparedStatement ps=con.prepareStatement(sql);
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
        ps.setInt(33,accidente.getId());
        ps.execute();
        ps.close();
        con.close();





    }
    public void actualizarEstandarMinimoDeContratista(EstandarMinimo estandarMinimo)throws SQLException,ClassNotFoundException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        estandarMinimo.setFechaDeRegistro(date);
        String sql="UPDATE estandaresMinimos set recursos = ?,capacitacion = ?,politica = ?,objetivos = ?,evaInicial = ?,planAnual = ?,documen = ?,cuentas = ?,normatividad = ?,mecanismos = ?,adquisiones = ?,contrataciones = ?,cambios = ?,condiciones = ?,registro = ?,vigilancia = ?,peligros = ?,prevencion= ?,planPrevencion = ?,gestion = ?,accionesPreven = ?,idContratista = ?,idContratante = ?,fechaDeRegistro = ? where id = ? ";
        Connection con = Conexion.conection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setFloat(1,estandarMinimo.getRecursos());
        ps.setFloat(2,estandarMinimo.getCapacitacion());
        ps.setFloat(3,estandarMinimo.getPolitica());
        ps.setFloat(4,estandarMinimo.getObjetivos());
        ps.setFloat(5,estandarMinimo.getEvaInicial());
        ps.setFloat(6,estandarMinimo.getPlanAnual());
        ps.setFloat(7,estandarMinimo.getDocumen());
        ps.setFloat(8,estandarMinimo.getCuentas());
        ps.setFloat(9,estandarMinimo.getNormatividad());
        ps.setFloat(10,estandarMinimo.getMecanismos());
        ps.setFloat(11,estandarMinimo.getAdquisiones());
        ps.setFloat(12,estandarMinimo.getContrataciones());
        ps.setFloat(13,estandarMinimo.getCambios());
        ps.setFloat(14,estandarMinimo.getCondiciones());
        ps.setFloat(15,estandarMinimo.getRegistro());
        ps.setFloat(16,estandarMinimo.getVigilancia());
        ps.setFloat(17,estandarMinimo.getPeligros());
        ps.setFloat(18,estandarMinimo.getPrevencion());
        ps.setFloat(19,estandarMinimo.getPlanPrevencion());
        ps.setFloat(20,estandarMinimo.getGestion());
        ps.setFloat(21,estandarMinimo.getAccionesPreven());
        ps.setInt(22,estandarMinimo.getIdContratista());
        ps.setInt(23,estandarMinimo.getIdContratante());
        ps.setDate(24,estandarMinimo.getFechaDeRegistro());
        ps.setInt(25,estandarMinimo.getId());
        ps.execute();
        ps.close();
        con.close();



    }
    public void actualizarPlanDeTrabajoDeContratista(PlanDeTrabajo plan)throws SQLException,ClassNotFoundException{

        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql="UPDATE planDeTrabajo set mes= ?,actividad = ?,fechaInicio = ?,fechaFin = ?,idContratista = ?,fechaDeRegistro = ?,year = ? where id =?";
        Connection con =  Conexion.conection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,plan.getMes());
        ps.setString(2,plan.getNombre());
        ps.setDate(3,plan.getFechaInicio());
        ps.setDate(4,plan.getFechaFin());
        ps.setInt(5,plan.getIdContratista());
        ps.setDate(6,date);
        ps.setInt(7,plan.getYear());
        ps.setInt(8,plan.getId());
        ps.execute();
        ps.close();
        con.close();



    }
    public void actulizarNoConformidad(NoConformidad noConformidad)throws SQLException,ClassNotFoundException{
        System.out.println(noConformidad.noConformidad);
        String sql = "UPDATE noConformidad  set noConformidad = ?,mes = ?,year = ? where id= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,noConformidad.getNoConformidad());
        ps.setString(2,noConformidad.getMes());
        ps.setInt(3,noConformidad.getYear());
        ps.setInt(4,noConformidad.getId());
        ps.execute();
        ps.close();
        con.close();





    }
    public void actulizarCausa(Causa causa)throws SQLException,ClassNotFoundException{
        System.out.println(causa.causa);
        String sql = "UPDATE causa set causa =? where id = ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,causa.getCausa());
        ps.setInt(2,causa.getId());
        ps.execute();
        ps.close();
        con.close();
    }
    public void actulizarAccion(Accion accion)throws SQLException,ClassNotFoundException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "UPDATE  accion  set nombre = ?, date = ?  WHERE id = ?";
        Connection con = Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, accion.getNombre());
        ps.setDate(2,date);
        ps.setInt(3,accion.getId());
        ps.execute();
        ps.close();
        con.close();
    }
    public void actualizarServicioAContratar(ServicioAContratar servicioAContratar)throws SQLException,ClassNotFoundException{
        System.out.println(servicioAContratar.getNombre());
        String sql = "UPDATE  servicioacontratar  set nombre = ?, tipo = ?  WHERE id = ?";
        Connection con = Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,servicioAContratar.getNombre());
        ps.setString(2,servicioAContratar.getTipo());
        ps.setInt(3,servicioAContratar.getId());
        ps.execute();
        ps.close();
        con.close();




    }









}
