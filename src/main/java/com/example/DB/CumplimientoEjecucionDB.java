package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.RequisitoExtra;
import com.example.Models.RequisitoObligatorio;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 06/07/2017.
 */

@Service
public class CumplimientoEjecucionDB {



    public List<RequisitoObligatorio> requisitosCumplidosPreviosSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosprevio as rs inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r on rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and rs.idCategoria= ? and rs.idContratante= ?) left join sys.documentosestaticospreviosobli as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito where i.idFinalista is not  null;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosprevio"));
            requisitoObligatorio.setIdFinalista(rs.getInt("idFinalista"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosEstaticosPrevio"));
            requisitoObligatorio.setTipo(rs.getString("tipo"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoObligatorio> requisitosNoCumplidosSugeridosPrevios(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosprevio as rs inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r on rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and rs.idCategoria= ? and rs.idContratante= ?) left join sys.documentosestaticospreviosobli as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito where i.idFinalista is   null;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosprevio"));
            requisitoObligatorio.setIdFinalista(rs.getInt("idFinalista"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosEstaticosPrevio"));
            requisitoObligatorio.setTipo(rs.getString("tipo"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }
    public List<RequisitoObligatorio> requisitosCumplidosEjecucionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as rs inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and rs.idCategoria= ? and rs.idContratante= ?) left join sys.documentosestaticosejecsug as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=i.idRequisito where i.idFinalista is not  null;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades"));
            requisitoObligatorio.setIdFinalista(rs.getInt("idFinalista"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitosdeejecuionsugeridosestaticosEjecucionActividades"));
            requisitoObligatorio.setTipo(rs.getString("tipo"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoObligatorio> requisitosNoCumplidosEjecucionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as rs inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and rs.idCategoria= ? and rs.idContratante= ?) left join sys.documentosestaticosejecsug as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=i.idRequisito where i.idFinalista is  null;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades"));
            requisitoObligatorio.setIdFinalista(rs.getInt("idFinalista"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitosdeejecuionsugeridosestaticosEjecucionActividades"));
            requisitoObligatorio.setTipo(rs.getString("tipo"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }
    public List<RequisitoObligatorio> requisitosCumplidosFinalizacionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.defFinalizaactiv,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,i.tipo from (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as rs inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and rs.idCategoria= ? and rs.idContratante= ?) left join sys.documentosestaticosfinalisug as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.defFinalizaactiv=i.idRequisito where i.idFinalista is not  null;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("defFinalizaactiv"));
            requisitoObligatorio.setIdFinalista(rs.getInt("idFinalista"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades"));
            requisitoObligatorio.setTipo(rs.getString("tipo"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    public List<RequisitoObligatorio> requisitosNoCumplidosFinalizacionSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.defFinalizaactiv,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,i.tipo from (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as rs inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and rs.idCategoria= ? and rs.idContratante= ?) left join sys.documentosestaticosfinalisug as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.defFinalizaactiv=i.idRequisito where i.idFinalista is null;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("defFinalizaactiv"));
            requisitoObligatorio.setIdFinalista(rs.getInt("idFinalista"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades"));
            requisitoObligatorio.setTipo(rs.getString("tipo"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }
    public List<RequisitoExtra>requisitosExtrasPreviosCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idrequisitosdeejecuiondefextrasestaticosprevio,d.idFinalista,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.tipo from (sys.requisitosdeejecuiondefextrasestaticosprevio as re inner join sys.requisitosdeejecuionextrasestaticosprevio as r on re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria=? and re.idContratante=?) left join sys.documentosestaticospreviosextras as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito\n" +
                "where d.idFinalista is not  null;\n";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuiondefextrasestaticosprevio"));
            requisitoExtra.setIdFinalista(rs.getInt("idFinalista"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosextrasPrevio"));
            requisitoExtra.setTipo(rs.getString("tipo"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>requisitosExtrasPreviosNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idrequisitosdeejecuiondefextrasestaticosprevio,d.idFinalista,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito from (sys.requisitosdeejecuiondefextrasestaticosprevio as re inner join sys.requisitosdeejecuionextrasestaticosprevio as r on re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria=? and re.idContratante=?) left join sys.documentosestaticospreviosextras as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito\n" +
                "where d.idFinalista is  null;\n";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuiondefextrasestaticosprevio"));
            requisitoExtra.setIdFinalista(rs.getInt("idFinalista"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosextrasPrevio"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>requisitosExtrasEjecucionCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idrequisitosdeejecuionextrasestaticosejecucionactividades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito, d.tipo from (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as re inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and re.idCategoria=? and re.idContratante=?) left join sys.documentosestaticosejecext as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito\n" +
                "where d.idFinalista is not  null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuionextrasestaticosejecucionactividades"));
            requisitoExtra.setIdFinalista(rs.getInt("idFinalista"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idrequisitosdeejecuionextrasestaticosEjecucionActividades"));
            requisitoExtra.setTipo(rs.getString("tipo"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>requisitosExtrasEjecucionNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idrequisitosdeejecuionextrasestaticosejecucionactividades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito from (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as re inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and re.idCategoria=? and re.idContratante=?) left join sys.documentosestaticosejecext as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito\n" +
                "where d.idFinalista is null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuionextrasestaticosejecucionactividades"));
            requisitoExtra.setIdFinalista(rs.getInt("idFinalista"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idrequisitosdeejecuionextrasestaticosEjecucionActividades"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>requisitosExtrasFinalizacionCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idejecuionextrassestaticosdeffinalizaciondeactivdades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito,d.tipo from (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and re.idCategoria=? and re.idContratante=?) left join sys.documentosestaticosfinaliext as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito\n" +
                "where d.idFinalista is not  null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idejecuionextrassestaticosdeffinalizaciondeactivdades"));
            requisitoExtra.setIdFinalista(rs.getInt("idFinalista"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }
    public List<RequisitoExtra>requisitosExtrasFinalizacionNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idejecuionextrassestaticosdeffinalizaciondeactivdades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito,d.tipo from (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and re.idCategoria=? and re.idContratante=?) left join sys.documentosestaticosfinaliext as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito\n" +
                "where d.idFinalista is  null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idejecuionextrassestaticosdeffinalizaciondeactivdades"));
            requisitoExtra.setIdFinalista(rs.getInt("idFinalista"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }





}
