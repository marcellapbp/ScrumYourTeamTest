package br.com.scrumyourteam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcella
 * Date: 02/06/2017
 * Objective: Create a Global Servlet to attend all Controllers
 */

@WebServlet(name = "SystemServlet", urlPatterns = {"/System"})
public class SystemServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        super.service(request, response);
        
       
        String actionRequested = request.getParameter("request");
        
        if (actionRequested.equals("addUser")) 
        {
            UserAdd userAdd = new UserAdd();
            userAdd.execute(request, response);
        }
    }

   

}
