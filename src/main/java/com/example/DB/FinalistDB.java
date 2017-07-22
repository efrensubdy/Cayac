package com.example.DB;

import com.example.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 07/06/2017.
 */
@Service
public class FinalistDB {
    @Autowired
    public ContratistasBD contratistasBD;

    public ContratistasBD getContratistasBD() {
        return contratistasBD;
    }

    public void setContratistasBD(ContratistasBD contratistasBD) {
        this.contratistasBD = contratistasBD;
    }


    public FinalistDB()throws SQLException,ClassNotFoundException{

    }
    public void insertarFinalista(Finalista finalista)throws SQLException,ClassNotFoundException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO sys.Finalista (idContratista,fechaCreacion, fechaModificacion, estado,idContrato)   VALUES(?,?,?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, finalista.getIdContratista());
        ps.setDate(2,date);
        ps.setDate(3,date);
        ps.setString(4,"F");
        ps.setInt(5,finalista.getIdContrato());
        ps.execute();
        ps.close();
        con.close();
    }
    public  List<Contratista> consultarNoFinalistas(int idContrante,int idContrato) throws ClassNotFoundException, SQLException{
        List<Contratista> contratistas = new LinkedList<>();
        String sql ="select t1.idContratista,t1.nombreEmpresa,t1.nit,t1.codigoCIIU,t1.nombreGerente,t1.email,t1.arl,t1.direccion,t1.telefono,t1.duracion,t1.departamento,t1.idContratante,t1.personaContacto,t1.cargoPer,t1.telefonoCon,t1.emailContacto,t1.idContrato  FROM  sys.contratista as t1 left join sys.finalista as t2 on t1.idContratista=t2.idContratista where t2.idContratista is null  and t1.idContratante = ? and t1.idContrato = ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContrante);
        ps.setInt(2,idContrato);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contratista con=new Contratista();
            con.setId(rs.getInt("idContratista"));
            con.setNombreEmpresa(rs.getString("nombreEmpresa"));
            con.setNit(rs.getString("nit"));
            con.setCodigoCIIU(rs.getString("codigoCIIU"));
            con.setNombreDeGerenteGeneral(rs.getString("nombreGerente"));
            con.setEmail(rs.getString("email"));
            con.setArl(String.valueOf( rs.getInt("arl")));
            con.setDireccion(rs.getString("direccion"));
            con.setTelefono(rs.getNString("telefono"));
            con.setDuracionContrato(Integer.valueOf(rs.getString("duracion")));
            con.setDepartamento(String.valueOf(rs.getInt("departamento")));
            con.setContratante(rs.getInt("idContratante"));
            con.setPersonContacto(rs.getString("personaContacto"));
            con.setCargoPersonaContacto(rs.getString("cargoPer"));
            con.setTelefonoPersonaContacto(rs.getString("telefonoCon"));
            con.setEmailContacto(rs.getString("emailContacto"));
            con.setIdContrato(rs.getInt("idContrato"));
            con.setIdCategoria(contratistasBD.traerCategoria(rs.getInt("idContratista")));
            con.setCumplidos(contratistasBD.obtenerCumplidos(con.getId(),con.getIdCategoria(),con.getContratante()));
            contratistas.add(con);
        }
        ps.close();
        return contratistas;
    }
    public  List<Contratista> consultarFinalistas(int idContrante,int idContrato) throws ClassNotFoundException, SQLException{
        List<Contratista> contratistas = new LinkedList<>();
        String sql ="select t2.idFinalista, t1.idContratista,t1.nombreEmpresa,t1.nit,t1.codigoCIIU,t1.nombreGerente,t1.email,t1.arl,t1.direccion,t1.telefono,t1.duracion,t1.departamento,t1.idContratante,t1.personaContacto,t1.cargoPer,t1.telefonoCon,t1.emailContacto,t2.idContrato  FROM  sys.contratista as t1 left join sys.finalista as t2 on t1.idContratista=t2.idContratista where t2.idContratista is not null  and t1.idContratante = ? and t2.idContrato = ? ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContrante);
        ps.setInt(2,idContrato);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contratista con=new Contratista();
            con.setIdFinalista(rs.getInt("idFinalista"));
            con.setId(rs.getInt("idContratista"));
            con.setNombreEmpresa(rs.getString("nombreEmpresa"));
            con.setNit(rs.getString("nit"));
            con.setCodigoCIIU(rs.getString("codigoCIIU"));
            con.setNombreDeGerenteGeneral(rs.getString("nombreGerente"));
            con.setEmail(rs.getString("email"));
            con.setArl(String.valueOf( rs.getInt("arl")));
            con.setDireccion(rs.getString("direccion"));
            con.setTelefono(rs.getNString("telefono"));
            con.setDuracionContrato(Integer.valueOf(rs.getString("duracion")));
            con.setDepartamento(String.valueOf(rs.getInt("departamento")));
            con.setContratante(rs.getInt("idContratante"));
            con.setPersonContacto(rs.getString("personaContacto"));
            con.setCargoPersonaContacto(rs.getString("cargoPer"));
            con.setTelefonoPersonaContacto(rs.getString("telefonoCon"));
            con.setEmailContacto(rs.getString("emailContacto"));
            con.setIdContrato(rs.getInt("idContrato"));
            con.setIdCategoria(contratistasBD.traerCategoria(rs.getInt("idContratista")));
            con.setCumplidos(contratistasBD.obtenerCumplidos(con.getId(),con.getIdCategoria(),con.getContratante()));

            contratistas.add(con);
        }
        ps.close();
        return contratistas;
    }
    public void registroManual(Contratista contratista) throws SQLException, ClassNotFoundException, IOException {
        contratistasBD.nuevoContratista(contratista);
        Contratista contra=contratistasBD.getContratista(contratista.nombreEmpresa);
        System.out.println(contra.getId());
        Finalista finalistaManual= new Finalista();
        finalistaManual.setIdContratista(contra.getId());
        finalistaManual.setIdContrato(contra.getIdContrato());
        insertarFinalista(finalistaManual);

    }
    public List<Requisito> llenarRequisitosPrevios(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio,t1.requisito from (sys.requisitosdeejecuionsugeridosestaticosprevio as t1 ) left join sys.requisitosdeejecuiondefsugeridosestaticosprevio as t2 on t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio=t2.idRequsito and t2.idContratante= ?\n" +
                "where t2.idrequisitosdeejecuiondefsugeridosestaticosprevio is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("idRequisitosDeEjecuionSugeridosEstaticosPrevio"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        return requisitos;

    }
    public List<Requisito> llenarRequisitosEjecucion(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select t1.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades, t1.requisito from (sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as t1 ) left join sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as t2 on t1.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("idrequisitosdeejecuionsugeridosestaticosEjecucionActividades"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        return requisitos;

    }
    public List<Requisito> llenarRequisitosfinalizacion(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select t1.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades, t1.requisito from (sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as t1 ) left join sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as t2 on t1.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.defFinalizaactiv is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        return requisitos;

    }
    public List<RequisitoExtra> llenarRequisitosExtrasPrevios(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select t1.idRequisitosDeEjecuionSugeridosextrasPrevio,t1.requisito from (sys.requisitosdeejecuionextrasestaticosprevio as t1) left join sys.requisitosdeejecuiondefextrasestaticosprevio as t2 on t1.idRequisitosDeEjecuionSugeridosextrasPrevio=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idrequisitosdeejecuiondefextrasestaticosprevio is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("idRequisitosDeEjecuionSugeridosextrasPrevio"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        return requisitosExtras;

    }
    public List<RequisitoExtra> llenarRequisitosExtrasEjecucion(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select t1.idrequisitosdeejecuionextrasestaticosEjecucionActividades,t1.requisito from (sys.requisitosdeejecuionextrasestaticosejecucionactividades as t1) left join sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as t2 on t1.idrequisitosdeejecuionextrasestaticosEjecucionActividades=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idrequisitosdeejecuionextrasestaticosejecucionactividades is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("idrequisitosdeejecuionextrasestaticosEjecucionActividades"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        return requisitosExtras;

    }
    public List<RequisitoExtra> llenarRequisitosExtrasFinalizacion(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select * from (sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as t1) left join sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as t2 on t1.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idejecuionextrassestaticosdeffinalizaciondeactivdades is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        return requisitosExtras;

    }
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoRequisitoPrevioSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO sys.requisitosdeejecuiondefsugeridosestaticosprevio (idContratante,idCategoria,idRequsito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoPrevioSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoPrevioSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoPrevioSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarPrevioExtra(RequisitoExtra nuevoRequisitoPrevioExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO sys.requisitosdeejecuiondefextrasestaticosprevio(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoPrevioExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoPrevioExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoPrevioExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarEjecucionSugerido(RequisitoObligatorio nuevoRequisitoEjecucionSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades (idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoEjecucionSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoEjecucionSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoEjecucionSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarEjecucionExtra(RequisitoExtra nuevoRequisitoEjecucionExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO sys.requisitosdeejecuionextrasdefestaticosejecucionactividades(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        System.out.println("chdsbhdjfghdfg");
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoEjecucionExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoEjecucionExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoEjecucionExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarFinalizacionSugerido(RequisitoObligatorio nuevoRequisitoFinalizacionSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades (idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoFinalizacionSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoFinalizacionSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoFinalizacionSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarFinalizacionExtra(RequisitoExtra nuevoRequisitoFinalizacionExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO sys.ejecuionextrassestaticosdeffinalizaciondeactivdades(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoFinalizacionExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoFinalizacionExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoFinalizacionExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }

    public List<RequisitoObligatorio>requisitosPreviosDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.idrequisitosdeejecuiondefsugeridosestaticosprevio,ro.idContratante,r.idCategoria, ro.idRequsito,r.requisito from sys.requisitosdeejecuiondefsugeridosestaticosprevio as ro inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r where ro.idRequsito=r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and ro.idContratante= ? and ro.idCategoria= ?; ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosprevio"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequsito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoObligatorioList.add(ro);
        }
        ps.close();

        return requisitoObligatorioList;

    }
    public List<RequisitoObligatorio>requisitosEjecucionDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as ro inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r where ro.idRequisito=r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and ro.idContratante= ? and ro.idCategoria= ? ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoObligatorioList.add(ro);
        }

        ps.close();
        return requisitoObligatorioList;

    }
    public List<RequisitoObligatorio>requisitosFinalizacionDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.defFinalizaactiv,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as ro inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r where ro.idRequisito=r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and ro.idContratante= ? and ro.idCategoria= ? ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("defFinalizaactiv"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoObligatorioList.add(ro);
        }

        ps.close();
        return requisitoObligatorioList;

    }
    public List<RequisitoExtra>requisitosPreviosDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.idrequisitosdeejecuiondefextrasestaticosprevio, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from sys.requisitosdeejecuiondefextrasestaticosprevio as ro inner join sys.requisitosdeejecuionextrasestaticosprevio as r where ro.idRequisito=r.idRequisitosDeEjecuionSugeridosextrasPrevio and ro.idContratante= ? and ro.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("idrequisitosdeejecuiondefextrasestaticosprevio"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }
        ps.close();

        return requisitoExtrasList;

    }
    public List<RequisitoExtra>requisitosEjecucionDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.idrequisitosdeejecuionextrasestaticosejecucionactividades, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as ro inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r where ro.idRequisito=r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and ro.idContratante= ? and ro.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("idrequisitosdeejecuionextrasestaticosejecucionactividades"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }
        ps.close();

        return requisitoExtrasList;

    }
    public List<RequisitoExtra>requisitosFinalizacionDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.idejecuionextrassestaticosdeffinalizaciondeactivdades, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as ro inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r where ro.idRequisito=r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and ro.idContratante= ? and ro.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("idejecuionextrassestaticosdeffinalizaciondeactivdades"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }

        ps.close();
        return requisitoExtrasList;

    }

    public List<RequisitoObligatorio>estadoDeRequisitosPreviosSugeridos(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosprevio,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,r.requisito,d.estado  from (sys.requisitosdeejecuiondefsugeridosestaticosprevio as re inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r on  re.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and re.idCategoria= ? and re.idContratante= ?) left join sys.documentosestaticospreviosobli as d  on re.idCategoria= ? and d.idFinalista= ? and re.idrequisitosdeejecuiondefsugeridosestaticosprevio=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosprevio"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosEstaticosPrevio"));
            if(rs.getString("estado")==null){
                requisitoObligatorio.setEstado(false);
            }
            else {
                requisitoObligatorio.setEstado(true);
            }
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoObligatorio>estadoDeRequisitosEjecucionSugeridos(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,r.requisito,d.estado from (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as re inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r on  re.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and re.idCategoria= ? and re.idContratante= ?) left join sys.documentosestaticosejecsug as d  on re.idCategoria= ? and d.idFinalista =? and re.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitosdeejecuionsugeridosestaticosEjecucionActividades"));
            if(rs.getString("estado")==null){
                requisitoObligatorio.setEstado(false);
            }
            else {
                requisitoObligatorio.setEstado(true);
            }
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }


    public List<RequisitoObligatorio>estadoDeRequisitosFinalizacionSugeridos(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select DISTINCT  re.defFinalizaactiv,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,r.requisito,d.estado from (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r on  re.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and re.idCategoria= ? and re.idContratante= ?) left join sys.documentosestaticosfinalisug as d  on re.idCategoria= ? and d.idFinalista= ? and re.defFinalizaactiv=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("defFinalizaactiv"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades"));
            if(rs.getString("estado")==null){
                requisitoObligatorio.setEstado(false);
            }
            else {
                requisitoObligatorio.setEstado(true);
            }
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoExtra>estadoRequisitosPreviosExtras(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idrequisitosdeejecuiondefextrasestaticosprevio,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.estado from (sys.requisitosdeejecuiondefextrasestaticosprevio as re inner join sys.requisitosdeejecuionextrasestaticosprevio as r on  re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria= ? and re.idContratante= ?) left join sys.documentosestaticospreviosextras as d  on re.idCategoria= ? and d.idFinalista= ? and re.idRequisito=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuiondefextrasestaticosprevio"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosextrasPrevio"));
            if(rs.getString("estado")==null){
                requisitoExtra.setEstado(false);
            }
            else {
                requisitoExtra.setEstado(true);
            }

            requisitosExtrasLisT.add(requisitoExtra);

        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>estadoRequisitoseEjecucionExtras(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idrequisitosdeejecuionextrasestaticosejecucionactividades,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito,d.estado from (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as re inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r on  re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and re.idCategoria= ? and re.idContratante= ?) left join sys.documentosestaticosejecext as d  on re.idCategoria= ? and d.idFinalista= ? and re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuionextrasestaticosejecucionactividades"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idrequisitosdeejecuionextrasestaticosEjecucionActividades"));
            if(rs.getString("estado")==null){
                requisitoExtra.setEstado(false);
            }
            else {
                requisitoExtra.setEstado(true);
            }

            requisitosExtrasLisT.add(requisitoExtra);

        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>estadoRequisitosFinalizacionExtras(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idejecuionextrassestaticosdeffinalizaciondeactivdades,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito,d.estado from (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r on  re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and re.idCategoria= ? and re.idContratante= ?) left join sys.documentosestaticosfinaliext as d  on re.idCategoria= ? and d.idFinalista= ? and re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idejecuionextrassestaticosdeffinalizaciondeactivdades"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades"));
            if(rs.getString("estado")==null){
                requisitoExtra.setEstado(false);
            }
            else {
                requisitoExtra.setEstado(true);
            }

            requisitosExtrasLisT.add(requisitoExtra);

        }
        ps.close();
        return requisitosExtrasLisT;
    }


}
