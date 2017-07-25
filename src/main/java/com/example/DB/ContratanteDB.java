package com.example.DB;

import com.example.Models.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by HSEQ on 29/03/2017.
 */
@Service
public class ContratanteDB {
    public  int tamañoTabla;
    public  DepartamentoDB departamentoDB;
    public UsersDB usersDB;
    public List<Contrato>contratoList;

    @Autowired
    public  ContratistasBD contratistasBD;
    public List<Contratante>contratantes;
    public   ActividadEconomicaBD actividadEconomicaBD;

    public ActividadEconomicaBD getActividadEconomicaBD() {
        return actividadEconomicaBD;
    }
    @Autowired
    public void setActividadEconomicaBD(ActividadEconomicaBD actividadEconomicaBD) {
        this.actividadEconomicaBD = actividadEconomicaBD;
    }

    public List<Contratante> getContratantes() {
        return contratantes;
    }

    public void setContratantes(List<Contratante> contratantes) {
        this.contratantes = contratantes;
    }

    public ContratistasBD getContratistasBD() {
        return contratistasBD;
    }

    public void setContratistasBD(ContratistasBD contratistasBD) {
        this.contratistasBD = contratistasBD;
    }

    /**
     *
     * @param contratante contratante que se va agregar a la base de Datos
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public   void nuevaContratante(Contratante contratante)throws ClassNotFoundException,SQLException {
        int a;
        Usuario nuevoUsuario=new Usuario();
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        consultarContratantes();
        usersDB=new UsersDB();
        departamentoDB=new DepartamentoDB();
        String sql = "INSERT INTO  contratante VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        contratante.setId(tamañoTabla + 1);
        a=tamañoTabla + 1;
        contratante.setDepartamento(String.valueOf(departamentoDB.findAactivdad(contratante.getDepartamento())));
        contratante.setCodigoCIIU(Integer.valueOf(actividadEconomicaBD.findAactivdad(Integer.valueOf(contratante.codigoCIIU))));
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,contratante.getId());
        ps.setString(2,contratante.getNombreEmpresa());
        ps.setString(3,contratante.getTelefono());
        ps.setString(4,contratante.getEmail());
        ps.setString(5,contratante.getPassword());
        ps.setInt(6,Integer.valueOf(contratante.getDepartamento()));
        ps.setDate(7, date);
        ps.setDate(8, date);
        ps.setInt(9,contratante.getCodigoCIIU());
        ps.setString(10,contratante.getDireccion());
        ps.setString(11,contratante.getRepresentanteLegal());

        nuevoUsuario.setIdContratante(contratante.getId());
        File file = new File("src/main/resources/static/app/Repository/Contratante/"+ a);
        if(!file.canWrite()){ // check if user have write permissions
            if(!(file.exists() && file.isDirectory())){
                if(file.mkdirs())
                    System.out.println("Success ! Folders created.");
                else
                    System.out.println("Failure ! Folders not created.");
            }
        }else{
            System.out.println("PERMISSION DENIED");
        }

        ps.execute();
        ps.close();
        con.close();
        usersDB.nuevoUsuarioContratante(nuevoUsuario);

    }

    /**
     *
     * @return una lista con todos los contratantes
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  List<Contratante> consultarContratantes() throws ClassNotFoundException, SQLException{
        contratantes = new LinkedList<>();
        String sql ="SELECT * FROM  contratante";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contratante contratante=new Contratante();
            contratante.setId(rs.getInt("idContratante"));
            contratante.setNombreEmpresa(rs.getString("nombreEmpresa"));
            contratante.setTelefono(rs.getString("telefono"));
            contratante.setEmail(rs.getString("email"));
            contratante.setPassword(rs.getString("password"));
            contratante.setDepartamento(String.valueOf(rs.getInt("departamento")));
            contratante.setCodigoCIIU(rs.getInt("codigoCIIU"));
            contratante.setDireccion(rs.getString("direccion"));
            contratante.setRepresentanteLegal(rs.getString("representanteLegal"));

            contratantes.add(contratante);
        }
        ps.close();
        tamañoTabla=contratantes.size();
        return contratantes;
    }
    public  void nuevoContrato(Contrato contrato)throws ClassNotFoundException,SQLException{
        String sql = "INSERT INTO  contrato(nombreContrato,fechaInicio,fechaFin,idContratante,tipoContrato) VALUES(?,?,?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,contrato.getNombreContrato());
        ps.setDate(2,contrato.getFechaInicio());
        ps.setDate(3,contrato.getFechaFin());
        ps.setInt(4,contrato.getIdContratante());
        ps.setString(5,contrato.getTipoContrato());
        ps.execute();
        ps.close();
        con.close();


    }
    public List<Contrato> consultarContratos( int idContratante ) throws ClassNotFoundException, SQLException{
        List<Contrato> contratos = new LinkedList<>();
        String sql ="SELECT * FROM  contrato where idContratante= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contrato nuevoContrato=new Contrato();
            nuevoContrato.setIdContrato(rs.getInt("idContrato"));
            nuevoContrato.setNombreContrato(rs.getString("nombreContrato"));
            nuevoContrato.setFechaInicio(rs.getDate("fechaInicio"));
            nuevoContrato.setFechaFin(rs.getDate("fechaFin"));
            nuevoContrato.setIdContratante(rs.getInt("idContratante"));
            nuevoContrato.setTipoContrato(rs.getString("tipoContrato"));
            contratos.add(nuevoContrato);
        }
        ps.close();

        return contratos;
    }
    public List<Contrato> consultarContratosCompletos( ) throws ClassNotFoundException, SQLException{
        List<Contrato> contratos = new LinkedList<>();
        String sql ="SELECT * FROM  contrato ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contrato nuevoContrato=new Contrato();
            nuevoContrato.setIdContrato(rs.getInt("idContrato"));
            nuevoContrato.setNombreContrato(rs.getString("nombreContrato"));
            nuevoContrato.setFechaInicio(rs.getDate("fechaInicio"));
            nuevoContrato.setFechaFin(rs.getDate("fechaFin"));
            nuevoContrato.setIdContratante(rs.getInt("idContratante"));
            nuevoContrato.setTipoContrato(rs.getString("tipoContrato"));
            contratos.add(nuevoContrato);
        }
        ps.close();

        return contratos;
    }

    public List<Contrato> consultarContratosEjecucion( ) throws ClassNotFoundException, SQLException{
        List<Contrato> contratos = new LinkedList<>();
        String sql ="select contrato.idContrato,contrato.nombreContrato,contrato.fechaInicio,contrato.fechaFin,contrato.idContratante,contrato.tipoContrato from  contrato left join  finalista on finalista.idContrato=contrato.idContrato where finalista.idContrato is  null;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contrato nuevoContrato=new Contrato();
            nuevoContrato.setIdContrato(rs.getInt("idContrato"));
            nuevoContrato.setNombreContrato(rs.getString("nombreContrato"));
            nuevoContrato.setFechaInicio(rs.getDate("fechaInicio"));
            nuevoContrato.setFechaFin(rs.getDate("fechaFin"));
            nuevoContrato.setIdContratante(rs.getInt("idContratante"));
            nuevoContrato.setTipoContrato(rs.getString("tipoContrato"));
            contratos.add(nuevoContrato);
        }
        ps.close();
        return contratos;
    }
    public List<Contrato> consultarDocumentosDeContrato(){
        List<Contrato >contratoList=new LinkedList<>();

        return contratoList;
    }



    public Contrato contratoporNombre(int nombreContrato)throws SQLException,ClassNotFoundException{
        contratoList=consultarContratosCompletos();
        Contrato contratoQueDevuelvo=new Contrato();
        for (Contrato contrato:contratoList){

            if (contrato.getIdContrato()==nombreContrato){
                contratoQueDevuelvo=contrato;
            }

        }
        return contratoQueDevuelvo;

    }
    public List<Contrato>contratosPorFecha(java.sql.Date fechaInicio, java.sql.Date fechaFin)throws SQLException,ClassNotFoundException{
     List<Contrato>contratosPorFecha=new LinkedList<>();
        System.out.println(fechaInicio);
        System.out.println(fechaFin);
        String sql ="SELECT * FROM  contrato \n" +
                "WHERE NOT (fechaInicio > ? OR fechaFin < ?);";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setDate(1,fechaInicio);
        ps.setDate(2,fechaFin);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contrato nuevoContrato=new Contrato();
            nuevoContrato.setIdContrato(rs.getInt("idContrato"));
            nuevoContrato.setNombreContrato(rs.getString("nombreContrato"));
            nuevoContrato.setFechaInicio(rs.getDate("fechaInicio"));
            nuevoContrato.setFechaFin(rs.getDate("fechaFin"));
            nuevoContrato.setIdContratante(rs.getInt("idContratante"));
            nuevoContrato.setTipoContrato(rs.getString("tipoContrato"));
            contratosPorFecha.add(nuevoContrato);
        }
        ps.close();
        return contratosPorFecha;
    }
    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


    public void insertarDocumentoContrato(Imagenes imagen) throws SQLException, ClassNotFoundException, IOException {
        System.out.println(imagen.getFile());
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(imagen.getFile());
        imagen.setTipo(fileType);
        String sql = "INSERT INTO documentosdecontrato (idContrato,contenido,fechaCreacion,fechaActualizacion,tipo,estado,nombreDeDocumento) VALUES(?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        imagen.setContenido("src/main/resources/static/app/Repository/Contratante/"+imagen.getIdContratante());
        File f=imagen.getFile();
        System.out.println(f.getName());
        PreparedStatement ps=con.prepareStatement("SHOW TABLE STATUS WHERE Name = contrato ");
        ResultSet rs=ps.executeQuery();
        rs.next();
        String nextid = rs.getString("Auto_increment");
        ps = con.prepareStatement(sql);

        ps.setInt(1,Integer.parseInt(nextid));
        ps.setString(2,imagen.getContenido());
        ps.setDate(3,date);
        ps.setDate(4,date);
        ps.setString(5,imagen.getTipo());
        ps.setString(6,"s");
        ps.setString(7,f.getName());
        ps.execute();

        ps.close();
        con.close();
        File q=new File("src/main/resources/static/app/Repository/Contratante/"+imagen.getIdContratante()+"/"+nextid+"."+imagen.getTipo());

        FileUtils.moveFile(f,q);
    }






    /**
     *
     * @param idContratante al cual pertenecen los contratistas
     * @return una lista con los contratistas que pertenecen al contratista con el id de parametro
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>contratistasPorContratante(int idContratante , int idContrato) throws SQLException, ClassNotFoundException {
        contratistasBD=new ContratistasBD();
        return contratistasBD.contratistasPorContrante(idContratante, idContrato);
    }

    /**
     *
     * @param idContrato
     * @param idCategoria
     * @return Lista con los contratistas pertenecientes al contrato y la categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Contratista>contratistasPorCategoria(int idContrato,int idCategoria)throws SQLException,ClassNotFoundException{
        contratistasBD=new ContratistasBD();
        return  contratistasBD.contratistasPorCategoria(idContrato, idCategoria);
    }

    /**
     *
     * @param idContratista
     * @param idCategoria
     * @param idContrato
     * @return Lista con los requisitos cumplidos de ese contratista , contrato y categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>requisitosCumplidos(int idContratista,int idCategoria,int idContrato)throws SQLException, ClassNotFoundException{
        contratistasBD=new ContratistasBD();
        return contratistasBD.requisitosCumplidos(idContratista, idCategoria, idContrato);

    }

    /**
     *
     * @param idContratista
     * @param idCategoria
     * @param idContrato
     * @return  Lista con los requisitos No cumplidos de ese contratista , contrato y categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>requisitosNoCumplidos(int idContratista,int idCategoria,int idContrato)throws SQLException, ClassNotFoundException{
        contratistasBD=new ContratistasBD();
        return contratistasBD.requisitosNoCumplidos(idContratista,idCategoria,idContrato);

    }

    /**
     *
     * @param idContratista
     * @param idCategoria
     * @param idContrato
     * @return Lista con  los requisitos Extras cumplidos por el contratistata pertenecientes a ese contrato y categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasCumplidos(int idContratista,int idCategoria,int idContrato)throws SQLException, ClassNotFoundException{
        contratistasBD=new ContratistasBD();
        return contratistasBD.requisitosExtrasCumplidos(idContratista, idCategoria, idContrato);

    }

    /**
     *
     * @param idContratista
     * @param idCategoria
     * @param idContrato
     * @return Lista con  los requisitos Extras no cumplidos por el contratistata pertenecientes a ese contrato y categoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasNoCumplidos(int idContratista,int idCategoria,int idContrato)throws SQLException, ClassNotFoundException{
        contratistasBD=new ContratistasBD();
        return contratistasBD.requisitosExtrasNoCumplidos(idContratista, idCategoria, idContrato);
    }




}
