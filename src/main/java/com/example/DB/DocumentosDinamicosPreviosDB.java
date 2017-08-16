package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.DocumentoPrevio;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HSEQ on 16/08/2017.
 */
@Service
public class DocumentosDinamicosPreviosDB {

    public int consultarRegistroPrevio(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from documentosDinamicosPrevios where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        ps.close();
        return registro;
    }

    public void insertarDinamicoPrevioNormal(DocumentoPrevio documentoPrevio)throws SQLException,ClassNotFoundException,IOException{
        String fileType = getFileExtension(documentoPrevio.getFile());
        documentoPrevio.setTipo(fileType);
        File q = new File("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista() + "/dinamico/" + documentoPrevio.getIdRequiPrevio() + "dinamicoPrevioSugerido" + "." + documentoPrevio.getTipo());
        if (q.exists()) {
            System.out.println("repetido");
            int id=consultarRegistroPrevio(documentoPrevio.getIdRequiPrevio(),documentoPrevio.getIdFinalista());
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            String sql = "INSERT INTO documentosDinamicosPrevios (idRequisito,idFinalista,fechaCreacion,fechaActualizacion,tipo,estado,contenido ) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            File f = documentoPrevio.getFile();
            q = new File("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista() + "/dinamico/" + documentoPrevio.getIdRequiPrevio() + "dinamicoPrevioSugerido" + id + "." + documentoPrevio.getTipo());
            documentoPrevio.setContenido("Repository/Contratista/" + documentoPrevio.getIdContratista() + "/dinamico/" + documentoPrevio.getIdRequiPrevio() + "dinamicoPrevioSugerido"+ id + "." + documentoPrevio.getTipo());
            FileUtils.moveFile(f, q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoPrevio.getIdRequiPrevio());
            ps.setInt(2, documentoPrevio.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoPrevio.getTipo());
            ps.setString(6, "s");
            ps.setString(7, documentoPrevio.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }
        else {
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            String sql = "INSERT INTO documentosDinamicosPrevios (idRequisito,idFinalista,fechaCreacion,fechaActualizacion,tipo,estado,contenido ) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            File f = documentoPrevio.getFile();
            q = new File("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista() + "/dinamico/" + documentoPrevio.getIdRequiPrevio() + "dinamicoPrevioSugerido" + "." + documentoPrevio.getTipo());
            documentoPrevio.setContenido("Repository/Contratista/" + documentoPrevio.getIdContratista() + "/dinamico/" + documentoPrevio.getIdRequiPrevio() + "dinamicoPrevioSugerido" + "." + documentoPrevio.getTipo());
            FileUtils.moveFile(f, q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoPrevio.getIdRequiPrevio());
            ps.setInt(2, documentoPrevio.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoPrevio.getTipo());
            ps.setString(6, "s");
            ps.setString(7, documentoPrevio.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }


    }
    public List<DocumentoPrevio>traerHistorialDeDocumentos(int idRequisito,int idFinalista)throws SQLException,ClassNotFoundException{
       List<DocumentoPrevio>historialPrevios=new LinkedList<>();
       String sql ="SELECT * FROM documentosDinamicosPrevios WHERE idRequisito = ? and idFinalista = ?";
       PreparedStatement ps=Conexion.conection().prepareStatement(sql);
       ps.setInt(1,idRequisito);
       ps.setInt(2,idFinalista);
       ResultSet rs=ps.executeQuery();
       while (rs.next()){
            DocumentoPrevio historicoDoc=new DocumentoPrevio();
            historicoDoc.setId(rs.getInt("id"));
            historicoDoc.setIdRequiPrevio(rs.getInt("idRequisito"));
            historicoDoc.setIdFinalista(rs.getInt("idFinalista"));
            historicoDoc.setTipo(rs.getString("tipo"));
            historicoDoc.setEstado(rs.getString("estado"));
            historicoDoc.setContenido(rs.getString("contenido"));
           historialPrevios.add(historicoDoc);
       }
       ps.close();

        return historialPrevios;
    }
    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}
