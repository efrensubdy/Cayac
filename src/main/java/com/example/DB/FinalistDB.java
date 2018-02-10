package com.example.DB;

import com.example.Models.*;
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
 * Created by HSEQ on 07/06/2017.
 */
@Service
public class FinalistDB {
    @Autowired
    public ContratistasBD contratistasBD;

    public ContratistasBD getContratistasBD() {
        return contratistasBD;
    }

    public void setContratistasBD(ContratistasBD contratistasBD) {
        this.contratistasBD = contratistasBD;
    }


    public FinalistDB()throws SQLException,ClassNotFoundException{

    }

    /**
     * Método que se encarga de insertar un finalista en la base de datos y crear las subcarpetas del repositorio se usa para pasar de selección a ejecución
     * @param finalista objeto con la información del finalista que se va registrar en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarFinalista2(Finalista finalista)throws SQLException,ClassNotFoundException,IOException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO finalista (idContratista,fechaCreacion, fechaModificacion, estado)   VALUES(?,?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, finalista.getIdContratista());
        ps.setDate(2,date);
        ps.setDate(3,date);
        ps.setString(4,"F");

        ps.execute();
        ps.close();
        con.close();
        File file = new File("src/main/resources/static/app/Repository/Contratista/"+ finalista.getIdContratista()+"/estatico");
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
        File file2 = new File("src/main/resources/static/app/Repository/Contratista/"+ finalista.getIdContratista()+"/dinamico");
        if(!file2.canWrite()){ // check if user have write permissions
            if(!(file2.exists() && file2.isDirectory())){
                if(file2.mkdirs())
                    System.out.println("Success ! Folders created.");
                else
                    System.out.println("Failure ! Folders not created.");
            }
        }else{
            System.out.println("PERMISSION DENIED");
        }

    }
    /**
     * Método que se encarga de insertar un finalista en la base de datos y crear las subcarpetas del repositorio se usa para pasar de selección a ejecución
     * @param finalista objeto con la información del finalista que se va registrar en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarFinalista(Finalista finalista)throws SQLException,ClassNotFoundException,IOException{
        java.util.Date utilDate = new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO finalista (idContratista,fechaCreacion, fechaModificacion, estado)   VALUES(?,?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, finalista.getIdContratista());
        ps.setDate(2,date);
        ps.setDate(3,date);
        ps.setString(4,"F");

        ps.execute();
        ps.close();
        con.close();
        File file = new File("src/main/resources/static/app/Repository/Contratista/"+ finalista.getIdContratista()+"/estatico");
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
        File file2 = new File("src/main/resources/static/app/Repository/Contratista/"+ finalista.getIdContratista()+"/dinamico");
        if(!file2.canWrite()){ // check if user have write permissions
            if(!(file2.exists() && file2.isDirectory())){
                if(file2.mkdirs())
                    System.out.println("Success ! Folders created.");
                else
                    System.out.println("Failure ! Folders not created.");
            }
        }else{
            System.out.println("PERMISSION DENIED");
        }

        int idFinalista=traerIdFinalista(finalista.getIdContratista());
        updateContrato(idFinalista,finalista.getIdContrato());
    }

    /**
     * Método que se encarga de insertar un finalista en la base de datos y crear las subcarpetas del repositorio se usa para pasar de selección a ejecución
     * @param finalista objeto con la información del finalista que se va registrar en la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertarFinalistaDeSeleccion(Finalista finalista)throws SQLException,ClassNotFoundException{
        updateContrato(finalista.getIdFinalista(),finalista.getIdContrato());


    }

    /**
     * Método que se encarga de actualizar un contrato con el dientificador del finalistaque paso de selección a ejecución
     * @param idFinalista identificador del contratista que ahora estará en ejecución
     * @param idContrato identificador del contrato
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void  updateContrato(int idFinalista,int idContrato)throws SQLException,ClassNotFoundException{
        String sql = "UPDATE  contrato set idFinalista = ? where idContrato =? ";
        System.out.println(idFinalista);
        System.out.println(idContrato);
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idFinalista);
        ps.setInt(2,idContrato);
        ps.execute();
        con.close();

    }

    /**
     * Método que se encarga de traer el identificador de un contratista
     * @param idContratista  idContratista de seleccion
     * @return int con el numero de finalista que se busca
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int traerIdFinalista(int idContratista)throws SQLException,ClassNotFoundException {
        int a =0;
        String sql ="select idFinalista from finalista where idContratista = ? ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratista);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){

            a=rs.getInt("idFinalista");

        }

        ps.close();
        Conexion.conection().close();
        return a;
    }

    /**
     * Método que se encargar de traer los no finalistas que se ecuentren en la base de datos
     * @param idContrante identificador del contratante a quien pertencen los candidatos
     * @param idContrato identificador del contrato alque pertenece el candidato
     * @return Listado con el contratista asociado
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  List<Contratista> consultarNoFinalistas(int idContrante,int idContrato) throws ClassNotFoundException, SQLException{
        List<Contratista> contratistas = new LinkedList<>();
        String sql ="select t1.idContratista,t1.nombreEmpresa,t1.nit,t1.codigoCIIU,t1.nombreGerente,t1.email,t1.password,t1.arl,t1.direccion,t1.telefono,t1.duracion,t1.departamento,t1.idContratante,t1.personaContacto,t1.cargoPer,t1.telefonoCon,t1.emailContacto,t1.idservicioAContratar  FROM  contratista as t1 left join finalista as t2 on t1.idContratista=t2.idContratista where t2.idContratista is null  and t1.idContratante = ? and t1.idservicioAContratar = ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContrante);
        ps.setInt(2,idContrato);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contratista con=new Contratista();
            con.setId(rs.getInt("idContratista"));
            con.setNombreEmpresa(rs.getString("nombreEmpresa"));
            con.setNit(rs.getString("nit"));
            con.setCodigoCIIU(rs.getString("codigoCIIU"));
            con.setNombreDeGerenteGeneral(rs.getString("nombreGerente"));
            con.setEmail(rs.getString("email"));
            con.setPassword(rs.getString("password"));
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
            con.setIdContrato(rs.getInt("idservicioAContratar"));
            con.setIdCategoria(contratistasBD.traerCategoria(rs.getInt("idContratista")));
            con.setCumplidos(0);
            contratistas.add(con);
        }
        ps.close();
        Conexion.conection().close();
        return contratistas;
    }

    /**
     * Método que se encargar de traer los no finalistas que se ecuentren en la base de datos
     * @param idContrante identificador del contratante a quien pertencen los Contratistas
     * @param idContrato identificador del contrato alque pertenece el Contratista
     * @return Listado con el contratista asociado
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  List<Contratista> consultarFinalistas(int idContrante,int idContrato) throws ClassNotFoundException, SQLException{
        List<Contratista> contratistas = new LinkedList<>();
        String sql ="SELECT t2.idFinalista, t1.idContratista,t1.nombreEmpresa,t1.nit,t1.codigoCIIU,t1.nombreGerente,t1.email,t1.password,t1.arl,t1.direccion,t1.telefono,t1.duracion,t1.departamento,t1.idContratante,t1.personaContacto,t1.cargoPer,t1.telefonoCon,t1.emailContacto,t3.idContrato  FROM  (contratista AS t1 LEFT JOIN finalista AS t2 ON t1.idContratista=t2.idContratista) INNER JOIN contrato AS t3 ON t3.idFinalista=t2.idFinalista  WHERE t2.idContratista IS NOT NULL AND t1.idContratante= ? AND t3.idContrato= ? ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContrante);
        ps.setInt(2,idContrato);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contratista con=new Contratista();
            con.setIdFinalista(rs.getInt("idFinalista"));
            con.setId(rs.getInt("idContratista"));
            con.setNombreEmpresa(rs.getString("nombreEmpresa"));
            con.setNit(rs.getString("nit"));
            con.setCodigoCIIU(rs.getString("codigoCIIU"));
            con.setNombreDeGerenteGeneral(rs.getString("nombreGerente"));
            con.setEmail(rs.getString("email"));
            con.setPassword(rs.getString("password"));
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
            con.setIdCategoria(contratistasBD.traerCategoria(rs.getInt("idContratista")));
            con.setCumplidos(contratistasBD.obtenerCumplidos(con.getId(),con.getIdCategoria(),con.getContratante()));

            contratistas.add(con);
        }
        ps.close();
        Conexion.conection().close();
        return contratistas;
    }

    /**
     * Metodo que consulta todos los finalistas de seleccion
     * @param idContrante ibdentificador delcontratante que requiere el reporte
     * @return Listado con objetos de tipo contratista ccon los finalistas de seleccion
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  List<Contratista> consultarFinalistasSeleccion(int idContrante) throws ClassNotFoundException, SQLException{
        List<Contratista> contratistas = new LinkedList<>();
        String sql ="SELECT t2.idFinalista, t1.idContratista,t1.nombreEmpresa,t1.nit,t1.codigoCIIU,t1.nombreGerente,t1.email,t1.arl,t1.direccion,t1.telefono,t1.duracion,t1.departamento,t1.idContratante,t1.personaContacto,t1.cargoPer,t1.telefonoCon,t1.emailContacto,t3.idContrato     FROM  (contratista AS t1 LEFT JOIN finalista AS t2 ON t1.idContratista=t2.idContratista) LEFT JOIN contrato AS t3 ON t3.idFinalista=t2.idFinalista WHERE t3.idFinalista IS NULL AND t1.idContratante = ? AND t2.idFinalista IS NOT NULL;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContrante);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contratista con=new Contratista();
            con.setIdFinalista(rs.getInt("idFinalista"));
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
            con.setIdCategoria(contratistasBD.traerCategoria(rs.getInt("idContratista")));
            con.setCumplidos(contratistasBD.obtenerCumplidos(con.getId(),con.getIdCategoria(),con.getContratante()));

            contratistas.add(con);
        }
        ps.close();
        Conexion.conection().close();
        return contratistas;
    }

    /**
     * Método que se encarga de llevar a un contratista directamnente a la parte de ejecución
     * @param contratista  objeto con la información del contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void registroManual(Contratista contratista) throws SQLException, ClassNotFoundException, IOException {
        contratistasBD.nuevoContratistaManual(contratista);
        Contratista contra=contratistasBD.getContratista(contratista.nombreEmpresa);
        Finalista finalistaManual= new Finalista();
        finalistaManual.setIdContratista(contra.getId());
        finalistaManual.setIdContrato(contratista.getIdContrato());
        insertarFinalista(finalistaManual);

    }
    public void actualizarContrato(int idFinalista )throws SQLException,ClassNotFoundException{


    }

    /**
     *
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria a la cual aplican los requisitos
     * @return Método que se encarga de llenar los requisitos que puede aplicar el contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Requisito> llenarRequisitosPrevios(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        List<Requisito> requisitos=new LinkedList<>();
        String sql ="select  t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio,t1.requisito from (requisitosdeejecuionsugeridosestaticosprevio as t1 ) left join requisitosdeejecuiondefsugeridosestaticosprevio as t2 on t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio=t2.idRequsito and t2.idContratante= ?\n" +
                "where t2.idrequisitosdeejecuiondefsugeridosestaticosprevio is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("idRequisitosDeEjecuionSugeridosEstaticosPrevio"));
            nuevoRequisito.setRequisito(rs.getString("requisito"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();
        Conexion.conection().close();
        return requisitos;


    }
    /**
     *
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria a la cual aplican los requisitos extras
     * @return Método que se encarga de llenar los requisitos extras que puede aplicar el contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
        public List<RequisitoExtra> llenarRequisitosExtrasPrevios(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        List <RequisitoExtra> requisitosExtras=new LinkedList<>();
        String sql ="select t1.idRequisitosDeEjecuionSugeridosextrasPrevio,t1.requisito from (requisitosdeejecuionextrasestaticosprevio as t1) left join requisitosdeejecuiondefextrasestaticosprevio as t2 on t1.idRequisitosDeEjecuionSugeridosextrasPrevio=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idrequisitosdeejecuiondefextrasestaticosprevio is null and t1.idCategoria= ? AND t1.idContratante = ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ps.setInt(3,idContratante);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("idRequisitosDeEjecuionSugeridosextrasPrevio"));
            nuevoRequisito.setDescripcion(rs.getString("requisito"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();
        Conexion.conection().close();
        return requisitosExtras;

    }

    /**
     * Método que se encarga de registrar un requisito en la base de datos
     * @param nuevoRequisitoPrevioSugerido objeto con la informacion del requisito que se va volver definitivo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarPrevioSugerido(RequisitoObligatorio nuevoRequisitoPrevioSugerido)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requisitosdeejecuiondefsugeridosestaticosprevio (idContratante,idCategoria,idRequsito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoPrevioSugerido.getIdContratante());
        ps.setInt(2,nuevoRequisitoPrevioSugerido.getIdCategoria());
        ps.setInt(3,nuevoRequisitoPrevioSugerido.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }
    /**
     * Método que se encarga de registrar un requisito extra en la base de datos
     * @param nuevoRequisitoPrevioExtra objeto con la informacion del requisito extra que se va volver definitivo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertarPrevioExtra(RequisitoExtra nuevoRequisitoPrevioExtra)throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO requisitosdeejecuiondefextrasestaticosprevio(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoPrevioExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoPrevioExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoPrevioExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();


    }

    /**
     * Método que trae los requisitos definitivos al contratante
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria a la cual pertenecen los requisitos
     * @return Listado con los requisitos definitivos aplicados por el contratante
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<RequisitoObligatorio>requisitosPreviosDefinitivosSugeridos(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select DISTINCT ro.idrequisitosdeejecuiondefsugeridosestaticosprevio,ro.idContratante,r.idCategoria, ro.idRequsito,r.requisito from requisitosdeejecuiondefsugeridosestaticosprevio as ro inner join requisitosdeejecuionsugeridosestaticosprevio as r where ro.idRequsito=r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and ro.idContratante= ? and ro.idCategoria= ?; ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosprevio"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequsito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoObligatorioList.add(ro);
        }
        ps.close();
        Conexion.conection().close();
        return requisitoObligatorioList;

    }
    /**
     * Método que trae los requisitos definitivos al contratante
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria a la cual pertenecen los requisitos extras
     * @return Listado con los requisitos definitivos extras aplicados por el contratante
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<RequisitoExtra>requisitosPreviosDefinitivosExtras(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select DISTINCT ro.idrequisitosdeejecuiondefextrasestaticosprevio, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from requisitosdeejecuiondefextrasestaticosprevio as ro inner join requisitosdeejecuionextrasestaticosprevio as r where ro.idRequisito=r.idRequisitosDeEjecuionSugeridosextrasPrevio and ro.idContratante= ? and ro.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("idrequisitosdeejecuiondefextrasestaticosprevio"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisito"));
            requisitoExtrasList.add(ro);
        }
        ps.close();
        Conexion.conection().close();
        return requisitoExtrasList;

    }

    /**
     * Método que trae el estado de los requisitos al contratista que fueron aplicados para el
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria a la que el contratista pertenece
     * @param idFinalista identificador del contratista
     * @return Listado con los requisitos aplicados al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<RequisitoObligatorio>estadoDeRequisitosPreviosSugeridos(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoObligatorio>requisitoObligatoriosLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosprevio,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,r.requisito,d.estado,d.contenido  from (requisitosdeejecuiondefsugeridosestaticosprevio as re inner join requisitosdeejecuionsugeridosestaticosprevio as r on  re.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and re.idCategoria= ? and re.idContratante= ?) left join documentosestaticospreviosobli as d  on re.idCategoria= ? and d.idFinalista= ? and re.idrequisitosdeejecuiondefsugeridosestaticosprevio=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio requisitoObligatorio= new RequisitoObligatorio();
            requisitoObligatorio.setId(rs.getInt("idrequisitosdeejecuiondefsugeridosestaticosprevio"));
            requisitoObligatorio.setDescripcion(rs.getString("requisito"));
            requisitoObligatorio.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosEstaticosPrevio"));
            if(rs.getString("estado")==null){
                requisitoObligatorio.setEstado(false);
            }
            else {
                requisitoObligatorio.setEstado(true);
            }
            requisitoObligatorio.setContenido(rs.getString("contenido"));
            requisitoObligatoriosLisT.add(requisitoObligatorio);
        }
        ps.close();
        Conexion.conection().close();
        return requisitoObligatoriosLisT;
    }
    /**
     * Método que trae el estado de los requisitos extras  al contratista que fueron aplicados para el
     * @param idContratante identificador del contratante
     * @param idCategoria identificador de la categoria a la que el contratista pertenece
     * @param idFinalista identificador del contratista
     * @return Listado con los requisitos extras  aplicados al contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public List<RequisitoExtra>estadoRequisitosPreviosExtras(int idContratante ,int idCategoria,int idFinalista)throws SQLException,ClassNotFoundException{
        List<RequisitoExtra>requisitosExtrasLisT=new LinkedList<>();
        String sql="select DISTINCT  re.idrequisitosdeejecuiondefextrasestaticosprevio,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.estado,d.contenido from (requisitosdeejecuiondefextrasestaticosprevio as re inner join requisitosdeejecuionextrasestaticosprevio as r on  re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria= ? and re.idContratante= ?) left join documentosestaticospreviosextras as d  on re.idCategoria= ? and d.idFinalista= ? and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito\n" +
                "where d.idFinalista is  null or d.idFinalista is not null;";
        PreparedStatement ps=Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idCategoria);
        ps.setInt(2,idContratante);
        ps.setInt(3,idCategoria);
        ps.setInt(4,idFinalista);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            RequisitoExtra requisitoExtra= new RequisitoExtra();
            requisitoExtra.setId(rs.getInt("idrequisitosdeejecuiondefextrasestaticosprevio"));
            requisitoExtra.setDescripcion(rs.getString("requisito"));
            requisitoExtra.setIdRequisito(rs.getInt("idRequisitosDeEjecuionSugeridosextrasPrevio"));
            if(rs.getString("estado")==null){
                requisitoExtra.setEstado(false);
            }
            else {
                requisitoExtra.setEstado(true);
            }
            requisitoExtra.setContenido(rs.getString("contenido"));
            requisitosExtrasLisT.add(requisitoExtra);

        }
        ps.close();
        Conexion.conection().close();
        return requisitosExtrasLisT;
    }


}
