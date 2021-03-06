package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Database;
/**
 *
 * @author Niklas Sarup-Lytzen ID: 18036644
 *
 */
public class Login extends HttpServlet {

    private int currentUserID;
    private HttpSession session;
    private Database database;
    private Refresh refresh;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // This servlet only redirects to the correct dashboard, actual authentication
    // Is handled in the authentication filter
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        database = (Database) request.getServletContext().getAttribute("database");

        try {
            // The userID will have been set by the authentication filter
            currentUserID = (int) request.getAttribute("userID");
            session = request.getSession();
            session.setAttribute("userID", currentUserID);
            
            // Run the initialise method in the refresh servlet for populating
            // The dashboard with data from the database
            refresh = new Refresh();
            refresh.initialise(currentUserID, session, request);

            // Dashboard redirection
            if (database.isAdmin(currentUserID)) {
                response.sendRedirect(request.getContextPath() + "/protected/adminDashboard.do");
                
            } else if (database.isEmployee(currentUserID)) {
                response.sendRedirect(request.getContextPath() + "/protected/employeeDashboard.do");
                
            } else if (database.isPatient(currentUserID)) {
                response.sendRedirect(request.getContextPath() + "/protected/patientDashboard.do");
                
            } else {
                throw new Exception();
            }

        } catch (Exception e) {

            response.sendRedirect(request.getContextPath() + "/logout.do");

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
