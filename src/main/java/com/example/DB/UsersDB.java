package com.example.DB;

import com.example.Models.*;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 02/04/2017.
 */
@Service
public class UsersDB {
    public static int tamañoTablaRequisitosObligatorios;
    public static int tamañoTableRequisitosExtras;
    public  List<Requisito>requisitos=new LinkedList<>();
    public  List<RequisitoExtra>requisitosExtras=new LinkedList<>();
    public static int tamañoTablaContratista;
    public static int tamañoTablaContrante;
    public static int tamañotablaAdmin;
    /**
     * Inserta un nuevo usuario en la base de datos
     * @param usuario que se va agregar a la base de datos de tipo contratante
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  void nuevoUsuarioContratante(Usuario usuario)throws ClassNotFoundException,SQLException {
        consultarUsuariosContratante();
        consultarUsuariosContratista();
        consultarUsuariosAdiminstradores();
        String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        usuario.setId(tamañoTablaContrante+ tamañoTablaContratista + tamañotablaAdmin + 1);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,usuario.getId());
        ps.setInt(2, usuario.getIdContratante());
        ps.setNull(3,java.sql.Types.INTEGER);
        ps.setNull(4,java.sql.Types.INTEGER);
        ps.setString(5,"activo");
        ps.setString(6,"Contratante");
        ps.setNull(7,java.sql.Types.INTEGER);
        ps.execute();
        ps.close();
        con.close();


    }

    /**
     * Se Inserta un nuevo usuario en la base de datos
     * @param usuario de tipo Contratista
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  void nuevoUsuarioContratista(Usuario usuario)throws ClassNotFoundException,SQLException {
        consultarUsuariosContratista();
        consultarUsuariosContratante();
        consultarUsuariosAdiminstradores();
        String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?)";
        Connection con =  Conexion.conection();
        usuario.setId(tamañoTablaContrante+ tamañoTablaContratista + tamañotablaAdmin + 1);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,usuario.getId());
        ps.setNull(2,java.sql.Types.INTEGER);
        ps.setInt(3, usuario.getIdContratista());
        ps.setInt(4,usuario.getCategoria());
        ps.setString(5,"activo");
        ps.setString(6,"Contratista");
        ps.setNull(7,java.sql.Types.INTEGER);
        ps.execute();
        ps.close();
        con.close();

    }

    /**
     *
     * @return LISTA DE TODOS LOS USUARIOS QUE SON CONTRATISTAS
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Usuario> consultarUsuariosContratista() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new LinkedList<>();
        String sql ="select con.idContratista ,con.email, con.password, u.idUsuarios,u.idCategoria,con.idContratante,con.idservicioAContratar,u.estado, u.rol from usuarios as u inner join contratista as con where u.idContratista=con.idContratista";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario u=new Usuario();
            u.setIdContratista(rs.getInt("idContratista"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setId(rs.getInt("idUsuarios"));
            u.setCategoria(rs.getInt("idCategoria"));
            u.setIdContratante(rs.getInt("idContratante"));
            u.setIdContrato(rs.getInt("idservicioAContratar"));
            u.setIdFinalista(traerIdFinalista(rs.getInt("idContratista")));
            if(u.getIdFinalista()==0){
              u.setFinalista(false);
            }
            else{

                u.setFinalista(true);
            }
            u.setEstadoDatabase(rs.getString("estado"));
            u.setRol(rs.getString("rol"));
            usuarios.add(u);
        }

        tamañoTablaContratista=usuarios.size();
        ps.close();
        Conexion.conection().close();
        return usuarios;
    }
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

    return a;
    }

    /**
     *
     * @return RETORNA TODOS LOS USUARIOS QUE SON CONTRATANTES
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Usuario> consultarUsuariosContratante() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new LinkedList<>();
        String sql ="select con.idContratante ,con.email, con.password, u.idUsuarios, u.estado,u.rol from usuarios as u inner join contratante as con where u.idContratante=con.idContratante";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario u=new Usuario();
            u.setIdContratante(rs.getInt("idContratante"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setId(rs.getInt("idUsuarios"));
            u.setEstadoDatabase(rs.getString("estado"));
            u.setRol(rs.getString("rol"));
            usuarios.add(u);
        }
        tamañoTablaContrante=usuarios.size();
        ps.close();
        return usuarios;
    }
    public List<Usuario> consultarUsuariosAdiminstradores() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new LinkedList<>();
        String sql ="select con.idadministrador ,con.usuario, con.contraseña, u.idUsuarios, u.estado,u.rol from usuarios as u inner join administrador as con where u.idAdministrador=con.idadministrador";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario u=new Usuario();
            u.setIdAdministrador(rs.getInt("idadministrador"));
            u.setEmail(rs.getString("usuario"));
            u.setPassword(rs.getString("contraseña"));
            u.setId(rs.getInt("idUsuarios"));
            u.setEstadoDatabase(rs.getString("estado"));
            u.setRol(rs.getString("rol"));
            usuarios.add(u);
        }
        tamañotablaAdmin=usuarios.size();
        ps.close();
        return usuarios;
    }

    /**
     *
     * @param user email de usurio
     * @param password password de inicio de sesión
     * @return un entero con el id del usuario Contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getIdContratante(String  user , String password) throws SQLException, ClassNotFoundException {
        int idContratante=0;
        List<Usuario>usuarios=consultarUsuariosContratante();
        for(Usuario u :usuarios) {
            if (u.getEmail().equals(user) && u.getPassword().equals(password)&& u.getEstadoDatabase().equals("activo")) {
                idContratante = u.getIdContratante();
            }
        }
                return idContratante;

    }

    /**
     *
     * @param user email de usuario
     * @param password de usario
     * @return entero con el id del contratista que tiene ese usuario
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getIdContratista(String  user , String password) throws SQLException, ClassNotFoundException {
        int idContratatista=0;
        List<Usuario>usuarios=consultarUsuariosContratista();
        for(Usuario u :usuarios) {
            if (u.getEmail().equals(user) && u.getPassword().equals(password)) {
                idContratatista = u.getIdContratista();
            }
        }
        return idContratatista;

    }
    public Usuario getUsuario(String  user , String password) throws SQLException, ClassNotFoundException {
        Usuario usuarioLogeado=new Usuario();
        boolean isContratista=false;
        boolean isnotContratista=false;
        List<Usuario>usuarios=consultarUsuariosContratista();
        for(Usuario u :usuarios) {

            if (u.getEmail().equals(user) && u.getPassword().equals(password)&& u.getEstadoDatabase().equals("activo")) {
                usuarioLogeado=u;
                isContratista=true;
            }
            else{
               usuarioLogeado.setEstado(false);
               isnotContratista=false;
            }
        }
        usuarioLogeado.setEstado(isContratista||isnotContratista);
        return usuarioLogeado;

    }
    public Usuario getUsuario2(String  user , String password) throws SQLException, ClassNotFoundException {
            Usuario usuarioLogeado=new Usuario();
            boolean isAdmin=false;
            boolean isContratante=false;
            List<Usuario>usuarios=consultarUsuariosContratante();
            List<Usuario>administradores=consultarUsuariosAdiminstradores();
            for(Usuario u :usuarios) {

                if (u.getEmail().equals(user) && u.getPassword().equals(password)) {
                    usuarioLogeado = u;
                    isContratante = true;
                    System.out.println("sdjcfhksdfh");

                }

            }
        System.out.println(isContratante);
             for(Usuario admin :administradores){
                if (admin.getEmail().equals(user) && admin.getPassword().equals(password)) {
                            usuarioLogeado=admin;
                            isAdmin=true;

                }
             }


            usuarioLogeado.setEstado(isContratante|| isAdmin);

            return usuarioLogeado;

    }





    /**
     *
     * @param user
     * @param password
     * @return booleano con la autenticacion del contratista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean GetUsuarioContratista(String user , String password) throws SQLException, ClassNotFoundException {
        boolean a=false;
        List<Usuario>usuarios=consultarUsuariosContratista();
        for(Usuario u :usuarios){
            if(u.getEmail().equals(user)&&u.getPassword().equals(password)){
                a=true;
            }
        }


        return a;
    }

    /**
     *
     * @param user
     * @param password
     * @return booleano con la autenticacion del contratante
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean GetUsuarioContratante(String user , String password) throws SQLException, ClassNotFoundException {
        boolean a=false;
        List<Usuario>usuarios=consultarUsuariosContratante();
        for(Usuario u :usuarios){
            if(u.getEmail().equals(user)&&u.getPassword().equals(password)){
                a=true;
            }
        }


        return a;
    }

    /**
     * llena los requisitos sugeridos que no estan en los definitivos
     * @param idCategoria, idCategoria
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void llenarRequisitosPrimeravez(int idContratante,int idCategoria) throws SQLException, ClassNotFoundException {
        requisitos=new LinkedList<>();
        String sql ="select t1.idrequisitos, t1.requisisto from (requisitos as t1 ) left join requisitosobligatoriossugeridos as t2 on t1.idrequisitos=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idRequisitosObligatorios is null and t1.idCategoria= ?;";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Requisito nuevoRequisito=new Requisito();
            nuevoRequisito.setNumero(rs.getInt("idrequisitos"));
            nuevoRequisito.setRequisito(rs.getString("requisisto"));
            requisitos.add(nuevoRequisito);
        }
        ps.close();

    }

    /**
     * Llena los requisitos extras que aún no son obligatorios
     * @param idCategoria, idContrato
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void llenarRequisitosExtrasPrimeravez(int idContratante, int idCategoria) throws SQLException, ClassNotFoundException {
        requisitosExtras=new LinkedList<>();
        String sql ="select * from (extras as t1) left join requisitosobligatoriosextras as t2 on t1.idExtras=t2.idRequisito and t2.idContratante= ?\n" +
                "where t2.idRequisitosObligatoriosExtras is null and t1.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra nuevoRequisito=new RequisitoExtra();
            nuevoRequisito.setId(rs.getInt("idExtras"));
            nuevoRequisito.setDescripcion(rs.getString("Extrascol"));
            requisitosExtras.add(nuevoRequisito);
        }
        ps.close();

    }

    /**
     * Actualiza la contraseña del contratante
     * @param idContratante
     * @param newPassword
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizarContraseñaContratante(int idContratante, String newPassword) throws SQLException, ClassNotFoundException{
        String sql ="update contratante set password = ? where idContratante =" + idContratante;
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setString(1,newPassword);
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Actualiza la contraseña del contratista
     * @param idContratista
     * @param newPassword
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void actualizarContraseñaContratista(int idContratista, String newPassword) throws SQLException, ClassNotFoundException{
        String sql ="update contratista set password = ? where idContratista =" + idContratista;
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setString(1,newPassword);
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Agraga el requisito obligatorio a la base de datos
     * @param nuevoRequisitoObligatorio
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void agregarRequisitoObligatorios(RequisitoObligatorio nuevoRequisitoObligatorio) throws ClassNotFoundException, SQLException{
        obtenerRequisitosObligatorios();
        System.out.println();
        String sql = "INSERT INTO requisitosobligatoriossugeridos (idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,nuevoRequisitoObligatorio.getIdContratante());
        ps.setInt(2,nuevoRequisitoObligatorio.getIdCategoria());
        ps.setInt(3,nuevoRequisitoObligatorio.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();
    }
    public void EliminarRequisitoObligatorios(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM requisitosobligatoriossugeridos WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }
    /**
     * Agrega el requisito  extra a los obligatorios
     * @param nuevoRequisitoExtra
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void agregarRequisitoExtras(RequisitoExtra nuevoRequisitoExtra) throws ClassNotFoundException, SQLException{
        obtenerRequisitosExtras();
        String sql = "INSERT INTO requisitosobligatoriosextras(idContratante,idCategoria,idRequisito) VALUES(?,?,?)";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,nuevoRequisitoExtra.getIdContratante());
        ps.setInt(2,nuevoRequisitoExtra.getIdCategoria());
        ps.setInt(3,nuevoRequisitoExtra.getIdRequisito());

        ps.execute();
        ps.close();
        con.close();

    }


    public List<RequisitoObligatorio> obtenerRequisitosObligatorios()throws ClassNotFoundException,SQLException{
        List<RequisitoObligatorio>requisitoObligatorios=new LinkedList<>();
        String sql ="SELECT * FROM requisitosobligatoriossugeridos";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("idRequisitosObligatorios"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));

            requisitoObligatorios.add(ro);
        }
        tamañoTablaRequisitosObligatorios=requisitoObligatorios.size();
        ps.close();
        return requisitoObligatorios;
    }
    public void EliminarRequisitoObligatoriosExtra(int idRequisito , int idContratante) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM requisitosobligatoriosextras WHERE idRequisito= ? AND idContratante= ?";
        Connection con =  Conexion.conection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,idRequisito);
        ps.setInt(2,idContratante);
        ps.execute();
        ps.close();
        con.close();
    }

    /**
     *
     * @return lista con todos los requisitos obligatorios extras
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<RequisitoExtra> obtenerRequisitosExtras()throws ClassNotFoundException,SQLException{
        List<RequisitoExtra>requisitosExtras=new LinkedList<>();
        String sql ="SELECT * FROM requisitosobligatoriosextras";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("idRequisitosObligatoriosExtras"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));

            requisitosExtras.add(ro);
        }
        tamañoTableRequisitosExtras=requisitosExtras.size();
        ps.close();
        return requisitosExtras;
    }

    /**
     *
     * @param idContratante, idCategoria
     * @return lista de requisitos obligatorios que pertenecen al contratistas
      * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<RequisitoObligatorio>requisitosObligatoriosPorContratista(int idContratante,int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoObligatorio>requisitoObligatorioList=new LinkedList<>();
        String sql ="select ro.idRequisitosObligatorios,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisisto from requisitosobligatoriossugeridos as ro inner join requisitos as r where ro.idRequisito=r.idrequisitos and ro.idContratante= ? and ro.idCategoria= ?; ";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoObligatorio ro=new RequisitoObligatorio();
            ro.setId(rs.getInt("idRequisitosObligatorios"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("requisisto"));
            requisitoObligatorioList.add(ro);
        }
        ps.close();


        return requisitoObligatorioList;

    }

    /**
     *
     * @param idContratante, idCategoria
     * @return lista de requisitos extras pertenecientes al contratistas
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<RequisitoExtra>requisitosExtrasPorContratista(int idContratante, int idCategoria)throws ClassNotFoundException, SQLException{
        List<RequisitoExtra>requisitoExtrasList=new LinkedList<>();
        String sql ="select ro.idRequisitosObligatoriosExtras, ro.idContratante,ro.idCategoria, ro.idRequisito,r.Extrascol from requisitosobligatoriosextras as ro inner join extras as r where ro.idRequisito=r.idExtras and ro.idContratante= ? and ro.idCategoria= ?";
        PreparedStatement ps = Conexion.conection().prepareStatement(sql);
        ps.setInt(1,idContratante);
        ps.setInt(2,idCategoria);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequisitoExtra ro=new RequisitoExtra();
            ro.setId(rs.getInt("idRequisitosObligatoriosExtras"));
            ro.setIdContratante(rs.getInt("idContratante"));
            ro.setIdCategoria(rs.getInt("idCategoria"));
            ro.setIdRequisito(rs.getInt("idRequisito"));
            ro.setDescripcion(rs.getString("Extrascol"));
            requisitoExtrasList.add(ro);
        }

        ps.close();
        return requisitoExtrasList;

    }


    public void agregarRequisito(Requisito nuevoRequisito){
        requisitos.add(nuevoRequisito);

    }
    public void eliminarRequisitos(Requisito requisitoAEliminar){

        requisitos.remove(requisitoAEliminar);
    }

    public List<RequisitoExtra> getRequisitosExtras() {
        return requisitosExtras;
    }

    public void setRequisitosExtras(List<RequisitoExtra> requisitosExtras) {
        this.requisitosExtras = requisitosExtras;
    }

    public  List<Requisito> getRequisitosSugeridos(int idContrato,int idCategoria ) throws SQLException, ClassNotFoundException {
        llenarRequisitosPrimeravez(idContrato,idCategoria);
        return requisitos;
    }
    public  List<RequisitoExtra> getExtras(int idContrato, int idCategoria) throws SQLException, ClassNotFoundException {
        llenarRequisitosExtrasPrimeravez(idContrato, idCategoria);
        return requisitosExtras;
    }

    public void setRequisitos(List<Requisito> requisitos) {
        this.requisitos=requisitos;
    }
}

