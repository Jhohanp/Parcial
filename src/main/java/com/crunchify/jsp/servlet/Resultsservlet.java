package com.crunchify.jsp.servlet;
 



import Modelo.RESULTS;
import edu.co.sergio.mundo.dao.ResultDAO;
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
 
public class Resultsservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String sid= request.getParameter("SID");
        String cat = request.getParameter("CAT");
        String eno= request.getParameter("ENO");
        String puntos= request.getParameter("POINT");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        ResultDAO dao = new ResultDAO();
        
        RESULTS resultados = new RESULTS();
        resultados.setSID(Integer.parseInt(sid));
        resultados.setCAT(cat);
        resultados.setENO(Integer.parseInt(eno));
        resultados.setPOINTS(Integer.parseInt(puntos));
        dao.insert(resultados);
        
        //Listando la informacion  
        List<RESULTS> tareas =  dao.findAll();
        request.setAttribute("departamentos", tareas);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        
        }
}
