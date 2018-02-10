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
    /**
     * Método que trae los requisitos con un documento asociado en la base de datos , cumplidos
     * @param idFinalista identificador del contratista
     * @param idCategoria identifcador de la categoria a la que pertenece el contratista
     * @param idContratante identificador del contratante
     * @return Listado con los requisitos que tenga un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio> requisitosCumplidosPreviosSugeridos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        //Setencia sql que compara dos tablas con left join y comparar que hay en unba tabla que otra no tiene
        String sql="select rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo from (requisitosdeejecuiondefsugeridosestaticosprevio as rs inner join requisitosdeejecuionsugeridosestaticosprevio as r on rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and rs.idCategoria= ? and rs.idContratante= ?) left join documentosestaticospreviosobli as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito where i.idFinalista is not  null;";
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

    /**
     * Método que trae los requisitos sin  un documento asociado en la base de datos ,no  cumplidos
     * @param idFinalista identificador del contratista
     * @param idCategoria identifcador de la categoria a la que pertenece el contratista
     * @param idContratante identificador del contratante
     * @return Listado con los requisitos que no  tenga un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio> requisitosNoCumplidosSugeridosPrevios(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo from (requisitosdeejecuiondefsugeridosestaticosprevio as rs inner join requisitosdeejecuionsugeridosestaticosprevio as r on rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and rs.idCategoria= ? and rs.idContratante= ?) left join documentosestaticospreviosobli as i  on  rs.idCategoria= ? and i.idFinalista= ? and rs.idContratante= ? and rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito where i.idFinalista is   null;";
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
    /**
     * Método que trae los requisitos extras con un documento asociado en la base de datos , cumplidos
     * @param idFinalista identificador del contratista
     * @param idCategoria identifcador de la categoria a la que pertenece el contratista
     * @param idContratante identificador del contratante
     * @return Listado con los requisitos extras  que tenga un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasPreviosCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idrequisitosdeejecuiondefextrasestaticosprevio,d.idFinalista,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.tipo from (requisitosdeejecuiondefextrasestaticosprevio as re inner join requisitosdeejecuionextrasestaticosprevio as r on re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria=? and re.idContratante=?) left join documentosestaticospreviosextras as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito\n" +
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
    /**
     * Método que trae los requisitos sin  un documento asociado en la base de datos ,no  cumplidos
     * @param idFinalista identificador del contratista
     * @param idCategoria identifcador de la categoria a la que pertenece el contratista
     * @param idContratante identificador del contratante
     * @return Listado con los requisitos que no  tenga un documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasPreviosNoCumplidos(int idFinalista, int idCategoria, int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idrequisitosdeejecuiondefextrasestaticosprevio,d.idFinalista,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito from (requisitosdeejecuiondefextrasestaticosprevio as re inner join requisitosdeejecuionextrasestaticosprevio as r on re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria=? and re.idContratante=?) left join documentosestaticospreviosextras as d  on re.idCategoria=? and d.idFinalista=? and re.idContratante= ? and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito\n" +
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

}
