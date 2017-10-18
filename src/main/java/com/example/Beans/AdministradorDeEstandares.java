package com.example.Beans;

import com.example.Models.EstandarMinimo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HSEQ on 18/10/2017.
 */
public interface AdministradorDeEstandares {
public void insertarEstandar(EstandarMinimo estandarMinimo)throws ClassNotFoundException,SQLException;
public List<EstandarMinimo>consultarEstandarMinimoPorContratista(int idContratista,int idContratante)throws ClassNotFoundException,SQLException;


}
