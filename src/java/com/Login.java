/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Genius
 */
@WebServlet("/login")

public class Login extends HttpServlet {

    private String message;
    private User currentUser;

    private int currentUserID;
    private String currentUserPassword;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // start password management
        String bt = request.getParameter("bt");
        
        if (bt != null) { 
            request.getRequestDispatcher("/employeeDashboard_password_management.jsp").forward(request, response);
            
        }
       // end password management 
       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String update_password = request.getParameter("update_password");

        HttpSession session = null;
        Cookie cookie = null;

        String forwardTo = "login.jsp";

        Database database = (Database) getServletContext().getAttribute("database");

        try {

            currentUserID = database.getUserID(username, password);

            // username  password validation 
            if (20000 <= currentUserID && currentUserID <= 39999) {
                session = request.getSession();

                session.setAttribute("username", username);
                session.setAttribute("userID", currentUserID);
                request.getRequestDispatcher("/employeeDashboard.do").forward(request, response);
               /* @note author - genius 
                *lazy approach to change user password. 
                * User is transfered to second login page at which they should enter username, password.
                * And NEW_PASSWORD. if username,password are correct then NEW_PASSWORD will be saved,
                * and user is logged in right away.
                * If the user tries to log in again, they must use thier new password.
                */
                currentUserPassword= database.setPassword(currentUserID,update_password);
            }
            else {
                 throw new Exception();
            }
            
           
        } catch (Exception e) {
            response.sendRedirect("login.jsp");

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
