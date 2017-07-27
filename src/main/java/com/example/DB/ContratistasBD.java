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
import java.util.concurrent.TimeUnit;

/**
 * Created by HSEQ on 24/03/2017.
 */
@Service
public class ContratistasBD {
    public int tamañoTablaRequisitosObligatorios;
    public   int tamañoTabla;
    public int tamañoTablaImagenes;
    public int tamañoTablaDocumentos;
    public int tamañoTablaFechaLimite;
    @Autowired
    public UsersDB usersDB;
    public   ActividadEconomicaBD actividadEconomicaBD;

    public UsersDB getUsersDB() {
        return usersDB;
    }

    public void setUsersDB(UsersDB usersDB) {
        this.usersDB = usersDB;
    }

    public   DepartamentoDB departamentoDB;
    public   ArlBD arlBD;
    public ContratistasBD() throws SQLException, ClassNotFoundException {
    }

    public  int getTamañoTabla() {
        return tamañoTabla;
    }

    public  void setTamañoTabla(int tamañoTabla) {
        this.tamañoTabla = tamañoTabla;
    }

    public  ActividadEconomicaBD getActividadEconomicaBD() {
        return actividadEconomicaBD;
    }

    public  void setActividadEconomicaBD(ActividadEconomicaBD actividadEconomicaBD) {
        this.actividadEconomicaBD = actividadEconomicaBD;
    }

    public  DepartamentoDB getDepartamentoDB() {
        return departamentoDB;
    }

    public  void setDepartamentoDB(DepartamentoDB departamentoDB) {
        this.departamentoDB = departamentoDB;
    }

    public  ArlBD getArlBD() {
        return arlBD;
    }

    public  void setArlBD(ArlBD arlBD) {
        this.arlBD = arlBD;
    }


    /**
     *
     * @param nuevoContratista contratista que se va agregar en la base de datos
     * @throws ClassNotFoundException puede arrojoar excepcion si se le pone otro tipo de dyos
     * @throws SQLException ouede arrojar excepción si no está bien configurada la base de datos
     */
    public   void nuevoContratista(Contratista nuevoContratista)throws ClassNotFoundException,SQLException,IOException {
        int nivelDeRiesgo=obtenerNivelDeRiesgo(nuevoContratista.getCodigoCIIU());
        Usuario nuevoUsuario =new Usuario();
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        actividadEconomicaBD=new ActividadEconomicaBD();
        departamentoDB=new DepartamentoDB();
        arlBD=new ArlBD();
        consultarContratistas();
        String sql = "INSERT INTO contratista VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        nuevoContratista.setId(tamañoTabla + 1);
        nuevoContratista.setCodigoCIIU(String.valueOf(Integer.valueOf(actividadEconomicaBD.findAactivdad(Integer.valueOf(nuevoContratista.codigoCIIU)))));
        nuevoContratista.setDepartamento(String.valueOf(departamentoDB.findAactivdad(nuevoContratista.getDepartamento())));
        nuevoContratista.setArl(String.valueOf(arlBD.findArl(nuevoContratista.getArl())));
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoContratista.getId());
        ps.setString(2,nuevoContratista.getNombreEmpresa());
        ps.setString(3,nuevoContratista.getNit());
        ps.setString(4,nuevoContratista.getCodigoCIIU());
        ps.setString(5,nuevoContratista.getNombreDeGerenteGeneral());
        ps.setString(6,nuevoContratista.getEmail());
        ps.setInt(7,Integer.valueOf(nuevoContratista.getArl()));
        ps.setString(8,nuevoContratista.getDireccion());
        ps.setString(9,nuevoContratista.getTelefono());
        ps.setString(10,String.valueOf(nuevoContratista.getDuracionContrato()));
        ps.setInt(11,Integer.valueOf(nuevoContratista.getDepartamento()));
        ps.setDate(12, date);
        ps.setDate(13, date);
        ps.setString(14,nuevoContratista.getPassword());
        ps.setInt(15,nuevoContratista.getContratante());
        ps.setString(16,nuevoContratista.getPersonContacto());
        ps.setString(17,nuevoContratista.getCargoPersonaContacto());
        ps.setString(18,nuevoContratista.getTelefonoPersonaContacto());
        ps.setString(19,nuevoContratista.getEmailContacto());
        ps.setInt(20,nuevoContratista.getIdContrato());
        nuevoUsuario.setIdContratista(nuevoContratista.getId());

        if (nuevoContratista.getDuracionContrato()>=1 && nivelDeRiesgo>=3){
            nuevoUsuario.setCategoria(1);
        }
        else if(nuevoContratista.getDuracionContrato()>=1 && nivelDeRiesgo<=2){
            nuevoUsuario.setCategoria(3);
        }
        else if (nuevoContratista.getDuracionContrato()<1 && nivelDeRiesgo>=3){
            nuevoUsuario.setCategoria(2);
        }
        else{
            nuevoUsuario.setCategoria(4);
        }
        ps.execute();
        ps.close();
        con.close();
        usersDB.nuevoUsuarioContratista(nuevoUsuario);
        int a=nuevoContratista.getId();
        File file = new File("src/main/resources/static/app/Repository/Contratista/"+ a);
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

    }
    public List<ActividadEconomica> actividadesEconomicas() throws SQLException, ClassNotFoundException {
        actividadEconomicaBD=new ActividadEconomicaBD();

        return actividadEconomicaBD.consultarActividadesEconomicas();

    }


    /**
     *
     * @return una lista con los contratistas de la base de datos
     * @throws ClassNotFoundException puede caer en la excepcion  si el objeto que recibe no es el correcto
     * @throws SQLException puede caer en la excepcion si está bien configurada la base de datos
     */
    public  List<Contratista> consultarContratistas() throws ClassNotFoundException, SQLException{

        List<Contratista> contratistas = new LinkedList<>();
        String sql ="SELECT * FROM contratista";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
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
            con.setIdCategoria(traerCategoria(rs.getInt("idContratista")));
            con.setCumplidos(obtenerCumplidos(rs.getInt("idContratista"),con.getIdCategoria(),con.getContratante()));
            contratistas.add(con);
        }


        tamañoTabla=contratistas.size();
        ps.close();
        return contratistas;
    }
    public Contratista getContratista(String nombreEmpresa)throws SQLException,ClassNotFoundException{
        Contratista contratista=new Contratista();
        List<Contratista>contratistaLinkedList=  consultarContratistas();
        for(Contratista contratista1:contratistaLinkedList){

            if (contratista1.getNombreEmpresa().equals(nombreEmpresa)){
                contratista=contratista1;
            }

        }


        return contratista;
    }


    public int obtenerCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
    int a=0;
    a= requisitosExtrasCumplidos(idContratista, idCategoria, idContratante).size()+requisitosCumplidos(idContratista, idCategoria, idContratante).size();
    return a;
    }
    public int traerCategoria(int idContratista)throws SQLException,ClassNotFoundException{
        int a=0;
        String sql ="select idCategoria from contratista as c inner join usuarios as u where c.idContratista=u.idContratista and c.idContratista= ? ; ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            a=rs.getInt("idCategoria");
        }
        ps.close();
        return a;
    }

    /**
     *
     * @param codigoCIIU actividad economica a la cual se le va sacar el riezgo
     * @return entero con el riezgo asociado
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public  int obtenerNivelDeRiesgo(String codigoCIIU) throws SQLException, ClassNotFoundException {
        int result=0;
        String sql ="select nivelDeRiesgo from activdadeconomica where codigoCIIU = "+ codigoCIIU ;
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            result=rs.getInt("nivelDeRiesgo");
        }
        ps.close();
      return result;
    }

    /**
     *
     * @param contratante id contratante al cual pertenece el contratista
     * @return Lista de contratistas asociados a ese id de Contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  List<Contratista>contratistasPorContrante(int contratante,int idContrato) throws SQLException, ClassNotFoundException {
        List<Contratista>contratistaList=consultarContratistas();
        List<Contratista>contra=new LinkedList<>();
        for (int i=0;i<contratistaList.size();i++){
            if(contratistaList.get(i).getContratante()==contratante && contratistaList.get(i).getIdContrato()==idContrato ){
                contra.add(contratistaList.get(i));
            }
        }
        return contra;
    } public  List<Contratista>contratistasPorCategoria(int idContrato, int idCategoria) throws SQLException, ClassNotFoundException {
        List<Contratista>contratistaList=new LinkedList<>();
        String sql ="SELECT * FROM contratista as c inner join usuarios as u where c.idContrato= ?  and u.idCategoria= ? and c.idContratista=u.idContratista; ;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContrato);
        ps.setInt(2,idCategoria);
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
            contratistaList.add(con);
        }
        ps.close();
        return contratistaList;
    }


    /**
     *
     * @return Consulta todas las imagenes de la base de datos :D
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */

    public List<Imagenes>consultarImagenes()throws SQLException, ClassNotFoundException, IOException{

        List<Imagenes>imagenesList=new LinkedList<>();
        String sql ="SELECT * FROM imagenes";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Imagenes imagenes=new Imagenes();
            imagenes.setId(rs.getInt("idImagenes"));
            imagenes.setIdRequisitoSugerido(rs.getInt("idRequisitoSugerido"));
            imagenes.setContenido(rs.getString("contenido"));
            imagenes.setTipo(rs.getString("tipo"));
            imagenes.setIdContratista(rs.getInt("idContratista"));
            imagenes.setEstado(rs.getString("estado"));
            imagenesList.add(imagenes);
        }
        tamañoTablaImagenes=imagenesList.size();
        ps.close();

        return imagenesList;


    }

    /**
     * Consulta las imagenes y documentos asociados a los extras
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public List<Documento>consultarDocumentos()throws SQLException, ClassNotFoundException, IOException{

        List<Documento>imagenesList=new LinkedList<>();
        String sql ="SELECT * FROM documentos";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Documento imagenes=new Documento();
            imagenes.setId(rs.getInt("idDocumentos"));
            imagenes.setIdRequisitoSugerido(rs.getInt("idRequisitoSugerido"));
            imagenes.setContenido(rs.getString("contenido"));
            imagenes.setTipo(rs.getString("tipo"));
            imagenes.setIdContratista(rs.getInt("idContratista"));
            imagenes.setEstado(rs.getString("estado"));
            imagenesList.add(imagenes);
        }
        tamañoTablaDocumentos=imagenesList.size();

        ps.close();
        return imagenesList;


    }

    /**
     * Consulta si una imagen tiene registro en la  base de Datos de requisitos sugeridos
     * @param idRequisitoSugerido
     * @param idContratista
     * @return falso / verdadero si la imagen ya esta en la base de datos y en el repositorio
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  boolean consultarRegistroDeImagen(int idRequisitoSugerido, int idContratista)throws SQLException,ClassNotFoundException {
        boolean flag=false;
        System.out.println(idRequisitoSugerido);
        String sql ="select count(*) as registro from imagenes where idRequisitoSugerido= ? and idContratista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idRequisitoSugerido);
        ps.setInt(2,idContratista);
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
        ps.close();
        return flag;


    }
    /**
     * Consulta si una imagen tiene registro en la  base de Datos de requisitos Extras
     * @param idRequisitoSugerido
     * @param idContratista
     * @return falso / verdadero si la imagen ya esta en la base de datos y en el repositorio
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  boolean consultarRegistroDeImagenExtra(int idRequisitoSugerido, int idContratista)throws SQLException,ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from documentos where idRequisitoSugerido= ? and idContratista=?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idRequisitoSugerido);
        ps.setInt(2,idContratista);
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
        ps.close();
        return flag;


    }

    /**
     * Conuslta el registro de fecha limite para un contratista ya existe
     * @param idContratante idCategoria
     * @return false/true si el registro existe o no
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  boolean consultarRegistroDeFecha(int idContratante,int idCategoria)throws SQLException,ClassNotFoundException {
        boolean flag=false;
        String sql ="select count(*) as registro from fechalimite where  idContratante= ? and idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
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
        ps.close();
        return flag;

    }

    /**
     * Registra la imagen del requisito sugerido en la base de datos y el repositorio
     * @param imagen
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public void registrarImagen(Imagenes imagen) throws SQLException, IOException, ClassNotFoundException {
        System.out.println(imagen.getFile());
        boolean flag=consultarRegistroDeImagen(imagen.getIdRequisitoSugerido(),imagen.getIdContratista());
        if(!flag){
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String fileType = getFileExtension(imagen.getFile());
        imagen.setTipo(fileType);
        String sql = "INSERT INTO imagenes (idRequisitoSugerido,contenido,fechaCreacion,fechaActualizacion,tipo,idContratista,estado) VALUES(?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        imagen.setContenido("src/main/resources/static/app/Repository/Contratista/"+imagen.getIdContratista());
        File f=imagen.getFile();
        File q=new File("src/main/resources/static/app/Repository/Contratista/"+imagen.getIdContratista()+"/"+imagen.getIdRequisitoSugerido()+"sugerido" +"."+imagen.getTipo());
        FileUtils.moveFile(f,q);
        System.out.println(f.getName());
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,imagen.getIdRequisitoSugerido());
        ps.setString(2,imagen.getContenido());
        ps.setDate(3,date);
        ps.setDate(4,date);
        ps.setString(5,imagen.getTipo());
        ps.setInt(6,imagen.getIdContratista());
        ps.setString(7,"s");
        ps.execute();
        ps.close();
        con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(imagen.getFile());
            imagen.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+imagen.getIdContratista()+"/"+imagen.getIdRequisitoSugerido()+"sugerido" +"."+imagen.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  imagenes set fechaActualizacion = ? where idRequisitoSugerido = ? and idContratista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,imagen.getIdRequisitoSugerido());
            ps.setInt(3,imagen.getIdContratista());
            ps.execute();
            con.close();
            File f=imagen.getFile();
            File y=new File("src/main/resources/static/app/Repository/Contratista"+imagen.getIdContratista()+"/"+imagen.getIdRequisitoSugerido()+"sugerido" +"."+imagen.getTipo());
            FileUtils.moveFile(f,y);



        }

    }

    /**
     * Registra El documento del requisito extra en la base de datos
     * @param documento
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void registrarDocumento(Documento documento) throws SQLException, IOException, ClassNotFoundException {
        System.out.println(documento.getFile());
        System.out.println(consultarRegistroDeImagen(documento.getIdRequisitoSugerido(),documento.getIdContratista()));
        boolean flag=consultarRegistroDeImagenExtra(documento.getIdRequisitoSugerido(),documento.getIdContratista());
        if (!flag){

            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documento.getFile());

            documento.setTipo(fileType);
            String sql = "INSERT INTO documentos(idRequisitoSugerido,contenido,fechaCreacion,fechaActualizacion,tipo,idContratista,estado) VALUES(?,?,?,?,?,?,?)";
            Connection con = Conexion.conection();

            documento.setContenido("src/main/resources/static/app/Repository/Contratista/" + documento.getIdContratista());
            File f=documento.getFile();
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documento.getIdContratista()+"/"+documento.getIdRequisitoSugerido()+"extra" +"."+documento.getTipo());
            FileUtils.moveFile(f,q);
            System.out.println(f.getName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documento.getIdRequisitoSugerido());
            ps.setString(2, documento.getContenido());
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setString(5, documento.getTipo());
            ps.setInt(6, documento.getIdContratista());
            ps.setString(7,"s");
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String fileType = getFileExtension(documento.getFile());
            documento.setTipo(fileType);
            File q=new File("src/main/resources/static/app/Repository/Contratista/"+documento.getIdContratista()+"/"+documento.getIdRequisitoSugerido()+"extra" +"."+documento.getTipo());
            if (q.isFile()) {
                FileUtils.deleteQuietly(q);
            }
            String sql = "UPDATE  documentos set fechaActualizacion = ? where idRequisitoSugerido = ? and idContratista= ?";
            Connection con =  Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ps.setInt(2,documento.getIdRequisitoSugerido());
            ps.setInt(3,documento.getIdContratista());
            ps.execute();
            con.close();
            File f=documento.getFile();
            System.out.println("idContratista "+documento.getIdContratista());
            File y=new File("src/main/resources/static/app/Repository/Contratista/"+documento.getIdContratista()+"/"+documento.getIdRequisitoSugerido()+"extra" +"."+documento.getTipo());
            FileUtils.moveFile(f,y);

        }

    }

    /**
     * Trae el tipo de documento que se haya guardado en la base de datos
     * @param idContratista
     * @param idRequisitoSugerido
     * @return extensión del documento según corresponda
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public String tipoDeImagenBD(int idContratista, int idRequisitoSugerido)throws SQLException,ClassNotFoundException {
        String sql ="select * from imagenes as i inner join requisitosobligatoriossugeridos as rs where rs.idRequisitosObligatorios=i.idRequisitoSugerido and idContratista=? and idRequisitoSugerido=?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ps.setInt(2,idRequisitoSugerido);
        ResultSet rs = ps.executeQuery();
        Imagenes imagenes=new Imagenes();

        while(rs.next()){
                       imagenes.setTipo(rs.getString("tipo"));


        }
        ps.close();
    return imagenes.getTipo() ;
    }

    /**
     *  ESTE METODO SE ENCARGA DE OBTENER LA EXTENSIÓN DE UN ARCHIVO
     * @param fullName
     * @return EL STRING CON EL TIPO DE ARCHIVO
     */

    private  String getFileExtension(File fullName) {
        String fileName = fullName.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    /**
     * TRAE LOS REQUISITOS CUMPLIDOS POR EL CONTRATISTA
     * @param idContratista
     * @return LISTA DE REQUISITOS QUE SE CUMPLIERON
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public List<RequisitoObligatorio>requisitosCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
       List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
       String sql="select rs.idRequisitosObligatorios,i.idContratista,r.requisisto,r.idrequisitos,i.tipo from (requisitosobligatoriossugeridos as rs inner join requisitos as r on rs.idRequisito =r.idrequisitos and rs.idCategoria= ? and rs.idContratante= ?) left join imagenes as i  on  rs.idCategoria= ? and i.idContratista= ? and rs.idContratante= ? and rs.idRequisitosObligatorios=i.idRequisitoSugerido where i.idContratista is not  null;";
       PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idContratista);
        ps.setInt(5,idContratante);
       ResultSet rs=ps.executeQuery();
       while(rs.next()){
           RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
           requisitoObligatorio.setId(rs.getInt("idRequisitosObligatorios"));
           requisitoObligatorio.setIdContratista(rs.getInt("idContratista"));
           requisitoObligatorio.setDescripcion(rs.getString("requisisto"));
           requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitos"));
           requisitoObligatorio.setTipo(rs.getString("tipo"));
           requisitoObligatoriosLisT.add(requisitoObligatorio);
       }
       ps.close();
       return requisitoObligatoriosLisT;
    }

    /**
     * TRAE LOS REQUISITOS NO CUMPLIDOS DURANTE LA EJECUCIÓN
     * @param idContratista
     * @return LISTA CON LOS REQUISITOS NO CUMPLIDOS POR EL CONTRATISTA
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>requisitosNoCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select rs.idRequisitosObligatorios,i.idContratista,r.requisisto,r.idrequisitos,i.tipo from (requisitosobligatoriossugeridos as rs inner join requisitos as r on rs.idRequisito =r.idrequisitos and rs.idCategoria= ? and rs.idContratante= ?) left join imagenes as i  on  rs.idCategoria= ? and i.idContratista= ? and rs.idContratante= ? and rs.idRequisitosObligatorios=i.idRequisitoSugerido where i.idContratista is  null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idContratista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idRequisitosObligatorios"));
            requisitoObligatorio.setIdContratista(idContratista);
            requisitoObligatorio.setDescripcion(rs.getString("requisisto"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitos"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        return requisitoObligatoriosLisT;
    }

    /**
     * sE ENRCARGA DE TRAER LOS REQUISITOS CUMPLIDOS Y POR CUMPLIR CON SU RESPECTIVO ESTADO
     * @param idContratante
     * @param  idCategoria
     * @return LISTA DE REQUISITOS CON SU ESTADO
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>estadoDeRequisitos(int idContratante ,int idCategoria,int idContratista)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select distinct rs.idRequisitosObligatorios,r.requisisto,r.idrequisitos,i.estado from (requisitosobligatoriossugeridos as rs inner join requisitos as r on rs.idRequisito =r.idrequisitos and rs.idCategoria= ? and rs.idContratante=?) left join imagenes as i  on rs.idCategoria= ? and i.idContratista= ?  and rs.idRequisitosObligatorios=i.idRequisitoSugerido\n" +
                "where i.idContratista is  null or i.idContratista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idContratista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idRequisitosObligatorios"));
            requisitoObligatorio.setDescripcion(rs.getString("requisisto"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idrequisitos"));
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

    /**
     * cONUSLTA LOS REQUISITOS EXTRAS CUMPLIDOS POR EL CONTRATISTA
     * @param idContratista
     * @return LISTA CON LOS REQUISITOS EXTRAS CUMPLIDOS SEGUN EL CONTRATISTA
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idRequisitosObligatoriosExtras,d.idContratista,r.idExtras,r.Extrascol,d.tipo from (requisitosobligatoriosextras as re inner join extras as r on re.idRequisito =r.idExtras and re.idCategoria=? and re.idContratante=?) left join documentos as d  on re.idCategoria=? and d.idContratista=? and re.idContratante= ? and re.idRequisitosObligatoriosExtras=d.idRequisitoSugerido\n" +
                "where d.idContratista is not  null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idContratista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idRequisitosObligatoriosExtras"));
            requisitoExtra.setIdContratista(rs.getInt("idContratista"));
            requisitoExtra.setDescripcion(rs.getString("Extrascol"));
            requisitoExtra.setIdRequisito(rs.getInt("idExtras"));
            requisitoExtra.setTipo(rs.getString("tipo"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }

    /**
     * SElECCIONA EL ESTADO DE LOS REQUISITOS EXTRAS
     * @param idContratante
     * @return LISTA DE REQUISITOS POR SU RESPECTIVO CONTRATISTA
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>estadoRequisitosExtras(int idContratante ,int idCategoria,int idContratista)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql=" select DISTINCT  re.idRequisitosObligatoriosExtras,r.idExtras,r.Extrascol,d.estado from (requisitosobligatoriosextras as re inner join extras as r on  re.idRequisito =r.idExtras and re.idCategoria= ? and re.idContratante= ?) left join documentos as d  on re.idCategoria= ? and d.idContratista= ? and re.idRequisitosObligatoriosExtras=d.idRequisitoSugerido\n" +
                " where d.idContratista is  null or d.idContratista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idContratista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idRequisitosObligatoriosExtras"));
            requisitoExtra.setDescripcion(rs.getString("Extrascol"));
            requisitoExtra.setIdRequisito(rs.getInt("idExtras"));
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

    /**
     * sELCCIONA LOS REQUISITOS NO CUMPLIDOS POR EL CONTRATISTA
     * @param idContratista
     * @return LISTA CON REQUISITOS NO CUMPLA EL CONTRATISTA CANDIDATO
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoExtra>requisitosExtrasNoCumplidos(int idContratista,int idCategoria,int idContratante)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select re.idRequisitosObligatoriosExtras,d.idContratista,r.idExtras,r.Extrascol,d.tipo from (requisitosobligatoriosextras as re inner join extras as r on re.idRequisito =r.idExtras and re.idCategoria=? and re.idContratante=?) left join documentos as d  on re.idCategoria=? and d.idContratista=? and re.idContratante= ? and re.idRequisitosObligatoriosExtras=d.idRequisitoSugerido\n" +
                "where d.idContratista is   null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idContratista);
        ps.setInt(5,idContratante);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idRequisitosObligatoriosExtras"));
            requisitoExtra.setIdContratista(idContratista);
            requisitoExtra.setDescripcion(rs.getString("Extrascol"));
            requisitoExtra.setIdRequisito(rs.getInt("idExtras"));
            requisitosExtrasLisT.add(requisitoExtra);
        }
        ps.close();
        return requisitosExtrasLisT;
    }

    /**
     * Consulta el numero de registro en la tabla de fecha limite
     * @return el tamaño actualizado y una lista con todas las fechas
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public  List<FechaLimite>registroTableFechaLimite()throws SQLException,ClassNotFoundException{
        List<FechaLimite>fechaLimiteList=new LinkedList<>();
        String sql ="SELECT * FROM fechalimite";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            FechaLimite fechaLimite=new FechaLimite();
            fechaLimite.setId(rs.getInt("idfechalimite"));
            fechaLimite.setFechaFin(rs.getDate("fechaLimite"));
            fechaLimite.setIdContratante(rs.getInt("idContratante"));
            fechaLimite.setIdCategoria(rs.getInt("idCategoria"));
            fechaLimiteList.add(fechaLimite);
        }
        tamañoTablaFechaLimite=fechaLimiteList.size();
        ps.close();
        return fechaLimiteList;
    }

    /**
     * OBTIENE LA FECHA DE SUBIR REPORTES
     * @param idContratante ,
     * @param idCategoria
     * @return LA FECHA CORRESPONDIENTE AL CONTRATISTA
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public FechaLimite obtenerFechaDeContratista(int idContratante, int idCategoria)throws SQLException,ClassNotFoundException{
     FechaLimite fecha=new FechaLimite();
     List<FechaLimite>fechaLimiteList=registroTableFechaLimite();
     for(FechaLimite fechaLimite: fechaLimiteList) {
         if (fechaLimite.getIdContratante()==idContratante && fechaLimite.getIdCategoria()==idCategoria){
             fecha= fechaLimite;
             if(consultarRegistroDeFecha(idContratante, idCategoria)){
                 fecha.setFlag(true);
                 java.util.Date utilDate = new Date();
                 java.sql.Date date = new java.sql.Date(utilDate.getTime());
                 fecha.setTiempoRestante(getTimeDiff(date,fecha.getFechaFin()));
                 if(date==fecha.getFechaFin()){
                     fecha.setEstado(false);
                 }
                 else{
                     fecha.setEstado(true);

                 }
             }
             else{
                 fecha.setFlag(false);
             }
         }
         else{
             fecha=new FechaLimite();

         }

     }

     return fecha;
    }

    /**
     *  SE ENRCAGA DE ALMACENAAR LA FECHA EN LA BASE DE DATOS
     * @param fechaLimite
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public void InsertarFechaLimite(FechaLimite fechaLimite)throws SQLException,ClassNotFoundException{
        registroTableFechaLimite();
        Boolean filtro=consultarRegistroDeFecha(fechaLimite.getIdContratante(),fechaLimite.getIdCategoria());
        if(!filtro) {
            String sql = "INSERT INTO fechalimite VALUES(?,?,?,?)";
            Connection con = Conexion.conection();
            fechaLimite.setId(tamañoTablaFechaLimite + 1);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, fechaLimite.getId());
            ps.setDate(2, fechaLimite.getFechaFin());
            ps.setInt(3, fechaLimite.getIdContratante());
            ps.setInt(4,fechaLimite.getIdCategoria());
            ps.execute();
            ps.close();
            con.close();
        }
        else{
            String sql = "UPDATE  fechalimite set fechaLimite = ? where idContratante = ? and idCategoria = ?";
            Connection con = Conexion.conection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,fechaLimite.getFechaFin());
            ps.setInt(2,fechaLimite.getIdContratante());
            ps.setInt(3,fechaLimite.getIdCategoria());
            ps.execute();
            ps.close();
            con.close();

        }
    }

    /**
     * COMPARA Y ENTREGA TIEMPO RESTANTE
     * @param dateOne
     * @param dateTwo
     * @return RETORNA EL NUMERO DE HORAS Y  MINUTOS QUE QUEDAN DE SUBIR LOS REPORTES
     */
    public String getTimeDiff(Date dateOne, Date dateTwo) {
        String diff = "";
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
        diff = String.format("%d HORAS %d MINUTOS", TimeUnit.MILLISECONDS.toHours(timeDiff),
                TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
        return diff;
    }



}

