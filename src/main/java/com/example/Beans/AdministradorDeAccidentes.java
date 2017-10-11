package com.example.Beans;

import com.example.Models.Accidente;

import java.sql.SQLException;

/**
 * Created by HSEQ on 11/10/2017.
 */
public interface AdministradorDeAccidentes {
    public void insertarAccidente (Accidente accidente)throws SQLException,ClassNotFoundException;
}
