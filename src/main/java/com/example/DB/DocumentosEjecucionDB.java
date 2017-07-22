package com.example.DB;

import com.example.Models.Conexion;
import com.example.Models.DocumentoEjecucion;
import com.example.Models.DocumentoFinalizacion;
import com.example.Models.DocumentoPrevio;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by HSEQ on 05/07/2017.
 */
@Service
public class DocumentosEjecucionDB {
    public boolean consultarRegistroDocumentoPrevioSugerido(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
    boolean flag=false;
        String sql ="select count(*) as registro from sys.documentosestaticospreviosobli where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;
    }
    public boolean consultarRegistroDocumentoPrevioExtra(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from sys.documentosestaticospreviosextras where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;
    }

    public boolean consultarRegistroDocumentoEjecucionSugerido(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from sys.documentosestaticosejecsug where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;
    }
    public boolean consultarRegistroDocumentoEjecucionExtra(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from sys.documentosestaticosejecext where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;
    }
    public boolean consultarRegistroDocumentoFinalizacionSugerido(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from sys.documentosestaticosfinalisug where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;
    }
    public boolean consultarRegistroDocumentoFinalizacionExtra(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from sys.documentosestaticosfinaliext where idRequisito= ? and idFinalista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,requisito);
        ps.setInt(2,idFinalista);
        ResultSet rs = ps.executeQuery();
        int registro=0;
        while (rs.next()){
            registro=rs.getInt("registro");

        }
        if (registro==0){
            flag=false;
        }
        else{
            flag=true;
        }

        return flag;
    }


    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        System.out.println(documentoPrevio.getFile());

        boolean flag=consultarRegistroDocumentoPrevioSugerido(documentoPrevio.getIdRequiPrevio(),documentoPrevio.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            String sql = "INSERT INTO sys.documentosestaticospreviosobli (idRequisito,idFinalista,contenido,fechaCreacion,fechaActualizacion,tipo,estado) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
            File f=documentoPrevio.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoPrevio.getIdRequiPrevio());
            ps.setInt(2, documentoPrevio.getIdFinalista());
            ps.setString(3, documentoPrevio.getContenido());
            ps.setDate(4, date);
            ps.setDate(5, date);
            ps.setString(6, documentoPrevio.getTipo());
            ps.setString(7,"s");
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  sys.documentosestaticospreviosobli set fechaActualizacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoPrevio.getIdRequiPrevio());
            ps.setInt(3,documentoPrevio.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoPrevio.getFile();
            System.out.println("idContratista "+documentoPrevio.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,y);

        }




    }
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {



        boolean flag=consultarRegistroDocumentoPrevioExtra(documentoPrevio.getIdRequiPrevio(),documentoPrevio.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            String sql = "INSERT INTO sys.documentosestaticospreviosextras (idRequisito,idFinalista,fechaCreacion,fechaModificacion,tipo,estado,contenido) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoPrevio.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoPrevio.getIdContratista());
            File f=documentoPrevio.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoPrevio.getIdRequiPrevio());
            ps.setInt(2, documentoPrevio.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoPrevio.getTipo());
            ps.setString(6,"s");
            ps.setString(7, documentoPrevio.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  sys.documentosestaticospreviosextras set fechaModificacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoPrevio.getIdRequiPrevio());
            ps.setInt(3,documentoPrevio.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoPrevio.getFile();
            System.out.println("idContratista "+documentoPrevio.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,y);

        }




    }
    public void insertarDocumentoEjecucionSugerido(DocumentoEjecucion documentoEjecucion) throws SQLException, ClassNotFoundException, IOException {
        boolean flag=consultarRegistroDocumentoEjecucionSugerido(documentoEjecucion.getIdRequiPrevio(),documentoEjecucion.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoEjecucion.getFile());
            documentoEjecucion.setTipo(fileType);
            String sql = "INSERT INTO sys.documentosestaticosejecsug (idRequisito,idFinalista,fechaCreacion,fechaActualiza,tipo,estado,contenido) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoEjecucion.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoEjecucion.getIdContratista());
            File f=documentoEjecucion.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoEjecucion.getIdContratista()+"/"+documentoEjecucion.getIdRequiPrevio()+"estaticoEjecucionSugerido" +"."+documentoEjecucion.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoEjecucion.getIdRequiPrevio());
            ps.setInt(2, documentoEjecucion.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoEjecucion.getTipo());
            ps.setString(6,"s");
            ps.setString(7, documentoEjecucion.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoEjecucion.getFile());
            documentoEjecucion.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoEjecucion.getIdContratista()+"/"+documentoEjecucion.getIdRequiPrevio()+"estaticoEjecucionSugerido" +"."+documentoEjecucion.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  sys.documentosestaticosejecsug set fechaActualiza = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoEjecucion.getIdRequiPrevio());
            ps.setInt(3,documentoEjecucion.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoEjecucion.getFile();
            System.out.println("idContratista "+documentoEjecucion.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoEjecucion.getIdContratista()+"/"+documentoEjecucion.getIdRequiPrevio()+"estaticoEjecucionSugerido" +"."+documentoEjecucion.getTipo());
            FileUtils.moveFile(f,y);

        }






    }
    public void insertarDocumentoEjecucionExtra(DocumentoEjecucion documentoEjecucion) throws SQLException, ClassNotFoundException, IOException {
        boolean flag=consultarRegistroDocumentoEjecucionExtra(documentoEjecucion.getIdRequiPrevio(),documentoEjecucion.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoEjecucion.getFile());
            documentoEjecucion.setTipo(fileType);
            String sql = "INSERT INTO sys.documentosestaticosejecext (idRequisito,idFinalista,fechaCreacion,fechaModificacion,tipo,estado,contenido) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoEjecucion.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoEjecucion.getIdContratista());
            File f=documentoEjecucion.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoEjecucion.getIdContratista()+"/"+documentoEjecucion.getIdRequiPrevio()+"estaticoEjecucionExtra" +"."+documentoEjecucion.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoEjecucion.getIdRequiPrevio());
            ps.setInt(2, documentoEjecucion.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoEjecucion.getTipo());
            ps.setString(6,"s");
            ps.setString(7, documentoEjecucion.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoEjecucion.getFile());
            documentoEjecucion.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoEjecucion.getIdContratista()+"/"+documentoEjecucion.getIdRequiPrevio()+"estaticoEjecucionExtra" +"."+documentoEjecucion.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  sys.documentosestaticosejecext set fechaModificacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoEjecucion.getIdRequiPrevio());
            ps.setInt(3,documentoEjecucion.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoEjecucion.getFile();
            System.out.println("idContratista "+documentoEjecucion.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoEjecucion.getIdContratista()+"/"+documentoEjecucion.getIdRequiPrevio()+"estaticoEjecucionExtra" +"."+documentoEjecucion.getTipo());
            FileUtils.moveFile(f,y);

        }


    }
    public void insertarDocumentoFinalizacionSugerido(DocumentoFinalizacion documentoFinalizacion) throws SQLException, ClassNotFoundException, IOException {
        boolean flag=consultarRegistroDocumentoFinalizacionSugerido(documentoFinalizacion.getIdRequiPrevio(),documentoFinalizacion.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoFinalizacion.getFile());
            documentoFinalizacion.setTipo(fileType);
            String sql = "INSERT INTO sys.documentosestaticosfinalisug (idRequisito,idFinalista,fechaCreacion,fechaModificacion,tipo,estado,contenido) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoFinalizacion.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoFinalizacion.getIdContratista());
            File f=documentoFinalizacion.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoFinalizacion.getIdContratista()+"/"+documentoFinalizacion.getIdRequiPrevio()+"estaticoFinalizacionSugerido" +"."+documentoFinalizacion.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoFinalizacion.getIdRequiPrevio());
            ps.setInt(2, documentoFinalizacion.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoFinalizacion.getTipo());
            ps.setString(6,"s");
            ps.setString(7, documentoFinalizacion.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoFinalizacion.getFile());
            documentoFinalizacion.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoFinalizacion.getIdContratista()+"/"+documentoFinalizacion.getIdRequiPrevio()+"estaticoFinalizacionSugerido" +"."+documentoFinalizacion.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  sys.documentosestaticosfinalisug set fechaModificacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoFinalizacion.getIdRequiPrevio());
            ps.setInt(3,documentoFinalizacion.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoFinalizacion.getFile();
            System.out.println("idContratista "+documentoFinalizacion.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoFinalizacion.getIdContratista()+"/"+documentoFinalizacion.getIdRequiPrevio()+"estaticoFinalizacionSugerido" +"."+documentoFinalizacion.getTipo());
            FileUtils.moveFile(f,y);

        }

    }
    public void insertarDocumentoFinalizacionExtra(DocumentoFinalizacion documentoFinalizacion) throws SQLException, ClassNotFoundException, IOException {
        boolean flag=consultarRegistroDocumentoFinalizacionExtra(documentoFinalizacion.getIdRequiPrevio(),documentoFinalizacion.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoFinalizacion.getFile());
            documentoFinalizacion.setTipo(fileType);
            String sql = "INSERT INTO sys.documentosestaticosfinaliext (idRequisito,idFinalista,fechaCreacion,fechaModificacion,tipo,estado,contenido) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoFinalizacion.setContenido("src/main/resources/static/app/Repository/Contratista/" + documentoFinalizacion.getIdContratista());
            File f=documentoFinalizacion.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoFinalizacion.getIdContratista()+"/"+documentoFinalizacion.getIdRequiPrevio()+"estaticoFinalizacionExtra" +"."+documentoFinalizacion.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoFinalizacion.getIdRequiPrevio());
            ps.setInt(2, documentoFinalizacion.getIdFinalista());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documentoFinalizacion.getTipo());
            ps.setString(6,"s");
            ps.setString(7, documentoFinalizacion.getContenido());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoFinalizacion.getFile());
            documentoFinalizacion.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoFinalizacion.getIdContratista()+"/"+documentoFinalizacion.getIdRequiPrevio()+"estaticoFinalizacionExtra" +"."+documentoFinalizacion.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  sys.documentosestaticosfinaliext set fechaModificacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoFinalizacion.getIdRequiPrevio());
            ps.setInt(3,documentoFinalizacion.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoFinalizacion.getFile();
            System.out.println("idContratista "+documentoFinalizacion.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoFinalizacion.getIdContratista()+"/"+documentoFinalizacion.getIdRequiPrevio()+"estaticoFinalizacionExtra" +"."+documentoFinalizacion.getTipo());
            FileUtils.moveFile(f,y);

        }




    }

    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


}
