package com.crunchify.jsp.servlet;
 

import Modelo.EXERCISES;
import edu.co.sergio.mundo.dao.ExercisesDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class Exercisesservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String cat = request.getParameter("CAT");
        String eno= request.getParameter("ENO");
        String topic = request.getParameter("TOPIC");
        String max= request.getParameter("MAXPT");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        ExercisesDAO dao = new ExercisesDAO();
        
        EXERCISES tarea = new EXERCISES();
        tarea.setCAT(cat);
        tarea.setENO(Integer.parseInt(eno));
        tarea.setTOPIC(topic);
        tarea.setMAXPT(Integer.parseInt(max));
        dao.insert(tarea);
        
        //Listando la informacion  
        List<EXERCISES> tareas =  dao.findAll();
        request.setAttribute("departamentos", tareas);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        
        }
}
