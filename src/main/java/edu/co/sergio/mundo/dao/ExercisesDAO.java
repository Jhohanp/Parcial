/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import Modelo.EXERCISES;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhopi
 */
public class ExercisesDAO {
    public List<EXERCISES> findAll() {
		List<EXERCISES> Tareas= null;
	    String query = "SELECT * FROM EXERCISES";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    String cat;
	    String topic;
            int eno,max;
	
	    while (rs.next()){
	    	if(Tareas == null){
	    		Tareas= new ArrayList<EXERCISES>();
	    	}
	      
	        EXERCISES registro= new EXERCISES();
	        cat = rs.getString("CAT");
                registro.setCAT(cat);
	        
                eno=rs.getInt("ENO");
                registro.setENO(eno);
                
	        topic = rs.getString("TOPIC");
	        registro.setTOPIC(topic) ;
	        
                max=rs.getInt("MAXPT");
                registro.setMAXPT(max);
                
	        Tareas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Tareas");
			e.printStackTrace();
		}
	    
	    return Tareas;
	}
    public boolean insert(EXERCISES t) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into EXERCISES values (?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, t.getCAT());
                        preparedStmt.setInt (2,t.getENO());
                        preparedStmt.setString(3, t.getTOPIC());
                        preparedStmt.setInt(4,t.getMAXPT());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
