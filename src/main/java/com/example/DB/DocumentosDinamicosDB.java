package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.DocumentoPrevio;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by HSEQ on 12/07/2017.
 */
@Service
public class DocumentosDinamicosDB {

    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);

    }

    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {

            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadPrevioSugerido" +"."+documentoPrevio.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }

            String sql = "UPDATE  sys.actprevsuger set contenido = ? , fechaEjecutada = ? , tipo =? , estado = ? where idRequisito = ? and idFinalista= ? and id= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,documentoPrevio.getContenido());
            ps.setDate(2,date);
            ps.setString(3,documentoPrevio.getTipo());
            ps.setString(4,"scsp");
            ps.setInt(5,documentoPrevio.getIdRequisitoDeSubida());
            ps.setInt(6,documentoPrevio.getIdFinalista());
            ps.setInt(7,documentoPrevio.getIdRequiPrevio());
            ps.execute();
            con.close();
            File f=documentoPrevio.getFile();

            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadPrevioSugerido" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,y);

        }
    public void insertarDocumentoEjecucionSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {

        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(documentoPrevio.getFile());
        documentoPrevio.setTipo(fileType);
        documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadEjecucionSugerido" +"."+documentoPrevio.getTipo());
        if (q.isFile()) {
            FileUtils.deleteQuietly(q);
        }
        String sql = "UPDATE  sys.actejecsug set contenido = ? , fechaEjecutada = ? , tipo =?, estado= ?  where idRequisito = ? and idFinalista= ? and id=?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,documentoPrevio.getContenido());
        ps.setDate(2,date);
        ps.setString(3,documentoPrevio.getTipo());
        ps.setString(4,"scsp");
        ps.setInt(5,documentoPrevio.getIdRequisitoDeSubida());
        ps.setInt(6,documentoPrevio.getIdFinalista());
        ps.setInt(7,documentoPrevio.getIdRequiPrevio());
        ps.execute();
        con.close();
        File f=documentoPrevio.getFile();

        File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadEjecucionSugerido" +"."+documentoPrevio.getTipo());
        FileUtils.moveFile(f,y);

    }
    public void insertarDocumentoFinalizacionSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {

        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(documentoPrevio.getFile());
        documentoPrevio.setTipo(fileType);
        documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadFinalizacionSugerido" +"."+documentoPrevio.getTipo());
        if (q.isFile()) {
            FileUtils.deleteQuietly(q);
        }
        String sql = "UPDATE  sys.actfinsug set contenido = ? , fechaEjecutada = ? , tipo =?, estado=?  where idRequisito = ? and idFinalista= ? and id=?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,documentoPrevio.getContenido());
        ps.setDate(2,date);
        ps.setString(3,documentoPrevio.getTipo());
        ps.setString(4,"scsp");
        ps.setInt(5,documentoPrevio.getIdRequisitoDeSubida());
        ps.setInt(6,documentoPrevio.getIdFinalista());
        ps.setInt(7,documentoPrevio.getIdRequiPrevio());
        ps.execute();
        con.close();
        File f=documentoPrevio.getFile();

        File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadFinalizacionSugerido" +"."+documentoPrevio.getTipo());
        FileUtils.moveFile(f,y);

    }

    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {

        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(documentoPrevio.getFile());
        documentoPrevio.setTipo(fileType);
        documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadPrevioExtra" +"."+documentoPrevio.getTipo());
        if (q.isFile()) {
            FileUtils.deleteQuietly(q);
        }
        String sql = "UPDATE  sys.actprevext set contenido = ? , fechaEjecutada = ? , tipo =?, estado= ?  where idRequisito = ? and idFinalista= ? and id= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,documentoPrevio.getContenido());
        ps.setDate(2,date);
        ps.setString(3,documentoPrevio.getTipo());
        ps.setString(4,"scsp");
        ps.setInt(5,documentoPrevio.getIdRequisitoDeSubida());
        ps.setInt(6,documentoPrevio.getIdFinalista());
        ps.setInt(7,documentoPrevio.getIdRequiPrevio());
        ps.execute();
        con.close();
        File f=documentoPrevio.getFile();

        File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadPrevioExtra" +"."+documentoPrevio.getTipo());
        FileUtils.moveFile(f,y);

    }

    public void insertarDocumentoEjecucionExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {

        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(documentoPrevio.getFile());
        documentoPrevio.setTipo(fileType);
        documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadEjecucionExtra" +"."+documentoPrevio.getTipo());
        if (q.isFile()) {
            FileUtils.deleteQuietly(q);
        }
        String sql = "UPDATE  sys.actejecext set contenido = ? , fechaEjecutada = ? , tipo =? , estado =? where idRequisito = ? and idFinalista= ? and id= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,documentoPrevio.getContenido());
        ps.setDate(2,date);
        ps.setString(3,documentoPrevio.getTipo());
        ps.setString(4,"scsp");
        ps.setInt(5,documentoPrevio.getIdRequisitoDeSubida());
        ps.setInt(6,documentoPrevio.getIdFinalista());
        ps.setInt(7,documentoPrevio.getIdRequiPrevio());
        ps.execute();
        con.close();
        File f=documentoPrevio.getFile();

        File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadEjecucionExtra" +"."+documentoPrevio.getTipo());
        FileUtils.moveFile(f,y);

    }
    public void insertarDocumentoFinalizacionExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {

        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(documentoPrevio.getFile());
        documentoPrevio.setTipo(fileType);
        documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadFinalizacionExtra" +"."+documentoPrevio.getTipo());
        if (q.isFile()) {
            FileUtils.deleteQuietly(q);
        }
        String sql = "UPDATE  sys.actfinext set contenido = ? , fechaEjecutada = ? , tipo =?, estado= ?  where idRequisito = ? and idFinalista= ? and id=?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,documentoPrevio.getContenido());
        ps.setDate(2,date);
        ps.setString(3,documentoPrevio.getTipo());
        ps.setString(4,"scsp");
        ps.setInt(5,documentoPrevio.getIdRequisitoDeSubida());
        ps.setInt(6,documentoPrevio.getIdFinalista());
        ps.setInt(7,documentoPrevio.getIdRequiPrevio());
        ps.execute();
        con.close();
        File f=documentoPrevio.getFile();

        File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"ActividadFinalizacionExtra" +"."+documentoPrevio.getTipo());
        FileUtils.moveFile(f,y);

    }


}
