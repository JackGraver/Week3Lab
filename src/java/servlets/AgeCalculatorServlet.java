/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 815138 - Jack Graver
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String age = request.getParameter("age");
       
        if(age == null || age.equals("")) {
            request.setAttribute("message", "You must give your current age. <br>");
                
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);    
        } else {
            try{
                int ageInt = Integer.parseInt(age);
                ageInt++;
                request.setAttribute("message", "Your age next birthday will be " + ageInt + "<br>");
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            }catch(NumberFormatException e) {
                request.setAttribute("message", "You must enter a number<br>");
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            }
        }
        
    
    }
}
