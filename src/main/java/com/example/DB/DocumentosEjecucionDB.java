package com.example.DB;

import com.example.Models.Conexion;
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
    /**
     * Consulta un registro de un documento  en el repositorio y en la base de datos
     * @param requisito identificador del requerimiento con un documento asociado en el repositorio
     * @param idFinalista identificador del contratista a quien pertenece el documento
     * @return true / false si tiene documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean consultarRegistroDocumentoPrevioSugerido(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
    boolean flag=false;
        String sql ="select count(*) as registro from documentosestaticospreviosobli where idRequisito= ? and idFinalista=?;";
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
    /**
     * Consulta un registro de un documento  extra en el repositorio y en la base de datos
     * @param requisito identificador del requerimiento con un documento asociado en el repositorio extra
     * @param idFinalista identificador del contratista a quien pertenece el documento
     * @return true / false si tiene documento asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean consultarRegistroDocumentoPrevioExtra(int requisito,int idFinalista) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from documentosestaticospreviosextras where idRequisito= ? and idFinalista=?;";
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

    /**
     * Insertar Documentos en la base de datos ------>
     * @param documentoPrevio objeto con la informacion del documento
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarDocumentoPrevioSugerido(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {
        System.out.println(documentoPrevio.getFile());

        boolean flag=consultarRegistroDocumentoPrevioSugerido(documentoPrevio.getIdRequiPrevio(),documentoPrevio.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            String sql = "INSERT INTO documentosestaticospreviosobli (idRequisito,idFinalista,contenido,fechaCreacion,fechaActualizacion,tipo,estado) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoPrevio.setContenido("Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
            File f=documentoPrevio.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
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
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);

            }
            String sql = "UPDATE  documentosestaticospreviosobli set fechaActualizacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoPrevio.getIdRequiPrevio());
            ps.setInt(3,documentoPrevio.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoPrevio.getFile();
            System.out.println("idContratista "+documentoPrevio.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioSugerido" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,y);

        }

    }
    /**
     * Insertar Documentos  extras en la base de datos ------>
     * @param documentoPrevio objeto con la informacion del documento extra
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarDocumentoPrevioExtra(DocumentoPrevio documentoPrevio) throws SQLException, ClassNotFoundException, IOException {



        boolean flag=consultarRegistroDocumentoPrevioExtra(documentoPrevio.getIdRequiPrevio(),documentoPrevio.getIdFinalista());
        if (!flag){
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documentoPrevio.getFile());
            documentoPrevio.setTipo(fileType);
            String sql = "INSERT INTO documentosestaticospreviosextras (idRequisito,idFinalista,fechaCreacion,fechaModificacion,tipo,estado,contenido) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();
            documentoPrevio.setContenido("Repository/Contratista/" + documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
            File f=documentoPrevio.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
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
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  documentosestaticospreviosextras set fechaModificacion = ? where idRequisito = ? and idFinalista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documentoPrevio.getIdRequiPrevio());
            ps.setInt(3,documentoPrevio.getIdFinalista());
            ps.execute();
            con.close();
            File f=documentoPrevio.getFile();
            System.out.println("idContratista "+documentoPrevio.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documentoPrevio.getIdContratista()+"/estatico/"+documentoPrevio.getIdRequiPrevio()+"estaticoPrevioExtra" +"."+documentoPrevio.getTipo());
            FileUtils.moveFile(f,y);

        }


    }
    /**
     * Se obtiene la extensión del archivo
     * @param fullName archivo que se quiere saber la extensión
     * @return String con la extensión
     */
    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


}
