/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;
import Modelo.EXERCISES;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.RESULTS;
import java.sql.PreparedStatement;
/**
 *
 * @author jhopi
 */
public class ResultDAO {
    
    public List<RESULTS> findAll() {
		List<RESULTS> Resultados= null;
	    String query = "SELECT * FROM RESULTS";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    String cat;
            int eno,puntos,sid;
	
	    while (rs.next()){
	    	if(Resultados == null){
	    		Resultados= new ArrayList<RESULTS>();
	    	}
	      
	        RESULTS registro= new RESULTS();
                
                sid=rs.getInt("SID");
                registro.setSID(sid);
                
	        cat = rs.getString("CAT");
                registro.setCAT(cat);
	        
                eno=rs.getInt("ENO");
                registro.setENO(eno);
                
	        
	        
                puntos=rs.getInt("POINTS");
                registro.setPOINTS(puntos);
                
	        Resultados.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Resultados");
			e.printStackTrace();
		}
	    
	    return Resultados;
	}
  public boolean insert(RESULTS t) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into RESULTS values (?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, t.getSID());
                        preparedStmt.setString(3, t.getCAT());
                        preparedStmt.setInt (2,t.getENO());
                        preparedStmt.setInt(4,t.getPOINTS());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
