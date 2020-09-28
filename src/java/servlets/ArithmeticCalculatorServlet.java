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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        
        if(first == null || first.equals("") || second == null || second.equals("")) {
            request.setAttribute("result", "Invalid");
        } else {
            try {
               int firstInt = Integer.parseInt(first);
               int secondInt = Integer.parseInt(second);
               String result = "";
               
               if(request.getParameter("add") != null) {
                   result =  Integer.toString(firstInt + secondInt);
               } else if (request.getParameter("minus") != null) {
                   result =  Integer.toString(firstInt - secondInt);
               } else if (request.getParameter("multiply") != null) {
                   result =  Integer.toString(firstInt * secondInt);
               } else if(request.getParameter("divise") != null) {
                   if(secondInt == 0) {
                       result = "Cannot divide by 0";
                   } else {
                        result = Integer.toString(firstInt/secondInt);
                   }
                  
               }
 
               request.setAttribute("result", result);
            } catch (NumberFormatException e) {
                request.setAttribute("result", "Invalid");
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }


}
