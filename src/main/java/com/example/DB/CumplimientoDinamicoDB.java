package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.DinamicoCumplido;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 30/08/2017.
 */
@Service
public class CumplimientoDinamicoDB {

    public List<DinamicoCumplido>dinamicosCumplidos(int idCategoria,int idContratante,int idFinalista) throws SQLException,ClassNotFoundException{
        List<DinamicoCumplido> dinamicoCumplidoList=new LinkedList<>();
        String sql="SELECT DISTINCT def.idContratante,re.idCategoria,re.requisito,re.apodo, d.idRequisito, d.idFinalista  FROM (requidinadefpresug AS def INNER JOIN requidinapresug AS re ON def.idRequisito=re.id AND re.idCategoria = ? AND def.idContratante= ?)LEFT JOIN documentosDinamicosPrevios AS d ON def.idCategoria= ? AND d.idFinalista= ?  AND def.id=d.idRequisito\n" +
                    "WHERE d.idFinalista IS NOT NULL\n" +
                    "GROUP BY d.idRequisito;";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            DinamicoCumplido cumplido = new DinamicoCumplido();
            cumplido.setIdContratante(rs.getInt("idContratante"));
            cumplido.setIdCategoria(rs.getInt("idCategoria"));
            cumplido.setRequisito(rs.getString("requisito"));
            cumplido.setApodo(rs.getString("apodo"));
            cumplido.setIdRequisito(rs.getInt("idRequisito"));
            cumplido.setIdFinalista(rs.getInt("idFinalista"));
            dinamicoCumplidoList.add(cumplido);

        }
        ps.close();
        return dinamicoCumplidoList;
    }
    public List<DinamicoCumplido>dinamicosNoCumplidos(int idCategoria,int idContratante,int idFinalista) throws SQLException,ClassNotFoundException{
        List<DinamicoCumplido> dinamicoCumplidoList=new LinkedList<>();
        String sql="SELECT DISTINCT def.idContratante,re.idCategoria,re.requisito,re.apodo, def.idRequisito, d.idFinalista  FROM (requidinadefpresug AS def INNER JOIN requidinapresug AS re ON def.idRequisito=re.id AND re.idCategoria = ? AND def.idContratante= ?)LEFT JOIN documentosDinamicosPrevios AS d ON def.idCategoria= ? AND d.idFinalista= ?  AND def.id=d.idRequisito\n" +
                "WHERE d.idFinalista IS NULL AND re.apodo != \"MATRIZ DE PELIGROS\"";
        PreparedStatement ps= Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            DinamicoCumplido cumplido = new DinamicoCumplido();
            cumplido.setIdContratante(rs.getInt("idContratante"));
            cumplido.setIdCategoria(rs.getInt("idCategoria"));
            cumplido.setRequisito(rs.getString("requisito"));
            cumplido.setApodo(rs.getString("apodo"));
            cumplido.setIdRequisito(rs.getInt("idRequisito"));
            cumplido.setIdFinalista(rs.getInt("idFinalista"));
            dinamicoCumplidoList.add(cumplido);

        }
        ps.close();
        return dinamicoCumplidoList;
    }






}
