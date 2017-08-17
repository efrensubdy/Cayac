package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.Requisito;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 10/07/2017.
 */
@Service
public class RequisitosDinamicosDB {

    public List<Requisito> llenarRequisitosDinamicosPreviosSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select t1.id,t1.requisito from (requidinapresug as t1 ) left join requidinadefpresug as t2 on t1.id=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.id is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("id"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        return requisitos;

    }
    public List<Requisito> llenarRequisitosDinamicosEjecucionSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select t1.id,t1.requisito from (requidinaejecsug as t1 ) left join requidinadefejecsug as t2 on t1.id=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.id is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("id"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        return requisitos;

    }

    public List<Requisito> llenarRequisitosDinamicosFinalizacionSugeridos(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select t1.id,t1.requisito from (requidinafinalsug as t1 ) left join requidinadeffinalsug as t2 on t1.id=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.id is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("id"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        return requisitos;

    }

    public List<RequisitoExtra> llenarRequisitosExtrasPrevios(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select t1.id,t1.requisito from (requidinapreex as t1) left join requidinadefpreext as t2 on t1.id=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.id is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("id"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        return requisitosExtras;

    }

    public List<RequisitoExtra> llenarRequisitosExtrasEjecucion(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select t1.id,t1.requisito from (requidinaejecext as t1) left join requidinadefejecext as t2 on t1.id=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.id is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("id"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        return requisitosExtras;

    }

    public List<RequisitoExtra> llenarRequisitosExtrasFinalizacion(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select t1.id,t1.requisito from (requidinafinalext as t1) left join requidinadeffinalext as t2 on t1.id=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.id is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("id"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        return requisitosExtras;

    }

    public void insertarDinamicoPrevioSugerido(RequisitoObligatorio nuevoRequisitoPrevioSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requidinadefpresug (idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoPrevioSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoPrevioSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoPrevioSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarDinamicoPrevioExtra(RequisitoExtra nuevoRequisitoPrevioExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requidinadefpreext(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoPrevioExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoPrevioExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoPrevioExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarDinamicoEjecucionSugerido(RequisitoObligatorio nuevoRequisitoEjecucionSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requidinadefejecsug(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoEjecucionSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoEjecucionSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoEjecucionSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarDinamicoEjecucionExtra(RequisitoExtra nuevoRequisitoEjecucionExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requidinadefejecext(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";

        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoEjecucionExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoEjecucionExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoEjecucionExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarDinamicoFinalizacionSugerido(RequisitoObligatorio nuevoRequisitoFinalizacionSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requidinadeffinalsug (idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoFinalizacionSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoFinalizacionSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoFinalizacionSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    public void insertarDinamicoFinalizacionExtra(RequisitoExtra nuevoRequisitoFinalizacionExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requidinadeffinalext(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoFinalizacionExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoFinalizacionExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoFinalizacionExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }

    public List<RequisitoObligatorio>requisitosDinamicosPreviosDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito,r.apodo from requidinadefpresug as ro inner join requidinapresug as r where ro.idRequisito=r.id and ro.idContratante= ? and ro.idCategoria= ? ; ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("id"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            ro.setApodo(rs.getString("apodo"));
            requisitoObligatorioList.add(ro);
        }

        ps.close();
        return requisitoObligatorioList;

    }
    public List<RequisitoObligatorio>requisitosDinamicosEjecucionDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from requidinadefejecsug as ro inner join requidinaejecsug as r where ro.idRequisito=r.id and ro.idContratante= ? and ro.idCategoria= ? ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("id"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoObligatorioList.add(ro);
        }

        ps.close();
        return requisitoObligatorioList;

    }
    public List<RequisitoObligatorio>requisitosDinamicosFinalizacionDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from requidinadeffinalsug as ro inner join requidinafinalsug as r where ro.idRequisito=r.id and ro.idContratante= ? and ro.idCategoria= ? ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("id"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoObligatorioList.add(ro);
        }

        ps.close();
        return requisitoObligatorioList;

    }
    public List<RequisitoExtra>requisitosDinamicosPreviosDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  from requidinadefpreext as ro inner join requidinapreex as r where ro.idRequisito=r.id  and ro.idContratante= ? and ro.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("id"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }

        ps.close();
        return requisitoExtrasList;

    }
    public List<RequisitoExtra>requisitosDinamicosEjecucionDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  from requidinadefejecext as ro inner join requidinaejecext as r where ro.idRequisito=r.id  and ro.idContratante= ? and ro.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("id"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }

        ps.close();
        return requisitoExtrasList;

    }
    public List<RequisitoExtra>requisitosDinamicosFinalizacionDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  from requidinadeffinalext as ro inner join requidinafinalext as r where ro.idRequisito=r.id  and ro.idContratante= ? and ro.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("id"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }

        ps.close();
        return requisitoExtrasList;

    }
    public List<RequisitoObligatorio>estadoPreviosSugeridosDinamicos(int idfinalista ,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rdps.id,rps.requisito,rdps.idCategoria,rps.apodo from finalista as f  inner join contratista as c inner join usuarios as u inner join requidinadefpresug as rdps inner join requidinapresug as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=? and f.idFinalista=? and rdps.idContratante= ? ;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idfinalista);
        ps.setInt(3,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("id"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdCategoria(rs.getInt("idCategoria"));
            requisitoObligatorio.setApodo(rs.getString("apodo"));
            requisitoObligatorio.setTipo("previoSugerido");

            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }
    public List<RequisitoObligatorio>estadoEjecucionSugeridosDinamicos(int idfinalista ,int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rdps.id,rps.requisito,rdps.idCategoria from finalista as f  inner join contratista as c inner join usuarios as u inner join requidinadefejecsug as rdps inner join requidinaejecsug as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria= ? and f.idFinalista= ? and rdps.idContratante= ? ;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idfinalista);
        ps.setInt(3,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("id"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdCategoria(rs.getInt("idCategoria"));
            requisitoObligatorio.setTipo("ejecucionSugerido");
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }
    public List<RequisitoObligatorio>estadoFinalizacionSugeridosDinamicos(int idfinalista ,int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rdps.id,rps.requisito,rdps.idCategoria from finalista as f  inner join contratista as c inner join usuarios as u inner join requidinadeffinalsug as rdps inner join requidinafinalsug as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria= ? and f.idFinalista= ? and rdps.idContratante= ?;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idfinalista);
        ps.setInt(3,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("id"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdCategoria(rs.getInt("idCategoria"));
            requisitoObligatorio.setTipo("finalizacionSugerido");
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoExtra>estadoPreviosExtrasDinamicos(int idfinalista ,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rdps.id,rps.requisito,rdps.idCategoria from finalista as f  inner join contratista as c inner join usuarios as u inner join requidinadefpreext as rdps inner join requidinapreex as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria= ? and f.idFinalista= ? and rdps.idContratante= ? ;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idfinalista);
        ps.setInt(3,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoObligatorio= new RequisitoExtra();
            requisitoObligatorio.setId(rs.getInt("id"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdCategoria(rs.getInt("idCategoria"));
            requisitoObligatorio.setTipo("previoExtra");
            requisitoObligatorio.setApodo("apodo");
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoExtra>estadoEjecucionExtrasDinamicos(int idfinalista ,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rdps.id,rps.requisito,rdps.idCategoria from finalista as f  inner join contratista as c inner join usuarios as u inner join requidinadefejecext as rdps inner join requidinaejecext as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria= ? and f.idFinalista= ? and rdps.idContratante= ? ;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idfinalista);
        ps.setInt(3,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoObligatorio= new RequisitoExtra();
            requisitoObligatorio.setId(rs.getInt("id"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdCategoria(rs.getInt("idCategoria"));
            requisitoObligatorio.setTipo("ejecucionExtra");
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }
    public List<RequisitoExtra>estadoFinalizacionExtrasDinamicos(int idfinalista ,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rdps.id,rps.requisito,rdps.idCategoria from finalista as f  inner join contratista as c inner join usuarios as u inner join requidinadeffinalext as rdps inner join requidinafinalext as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria= ? and f.idFinalista= ? and rdps.idContratante= ? ; ";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idfinalista);
        ps.setInt(3,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoObligatorio= new RequisitoExtra();
            requisitoObligatorio.setId(rs.getInt("id"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdCategoria(rs.getInt("idCategoria"));
            requisitoObligatorio.setTipo("finalizacionExtra");
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }


}
