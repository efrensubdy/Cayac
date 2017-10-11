package com.example.DB;

import com.example.Models.Accidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by HSEQ on 11/10/2017.
 */
@Service
public class AccidentesDB {
    public void insertarAccidente(Accidente accidente)throws SQLException,ClassNotFoundException{

        System.out.println(accidente.getDepa());

    }
}
