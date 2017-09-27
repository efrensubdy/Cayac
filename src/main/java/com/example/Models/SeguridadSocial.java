package com.example.Models;

import java.io.File;
import java.sql.Date;
import java.util.List;

/**
 * Created by HSEQ on 27/09/2017.
 */
public class SeguridadSocial {
public int id;
public int idContratista;
public int idContratante;
public List<File> archivos;
public String seguridadSocial;
public String personal;
public String cambios;
public String mes;
public Date fechaDeSubida;
}

