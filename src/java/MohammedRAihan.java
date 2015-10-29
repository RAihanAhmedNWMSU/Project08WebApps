/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raihan Ahmed Mohammed
 */
@WebServlet(name= "MohammedRAihan", urlPatterns = {"/MohammedRAihan"})
public class MohammedRAihan extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           
           String flavor=request.getParameter("flavor");
           String size=request.getParameter("size");
           String quantityValue=request.getParameter("quantity");
           double priceOfIceCream = 0;
            String finalMessage = "";
            boolean isEmptyField = false;
            double small = 6, medium = 9, large = 11;
            double chocolate = 1, mintChocolate = 1.25, strawberry = 1.50, vanilla = 1.50;
            double saltedCaramel = 0.50, sugarFreeStrawberry = 0.70;
            if (flavor.equals("Chocolate")) {
                priceOfIceCream = priceOfIceCream + chocolate;
            } else if (flavor.equals("Mint Chocolate Chip")) {
                priceOfIceCream = priceOfIceCream + mintChocolate;
            } else if (flavor.equals("Strawberry")) {
                priceOfIceCream = priceOfIceCream + strawberry;
            } else if (flavor.equals("Vanilla")) {
                priceOfIceCream = priceOfIceCream + vanilla;
            }
            
            if (size != null) {
                if (size.equals("small")) {
                    priceOfIceCream = priceOfIceCream + small;
                } else if (size.equals("medium")) {
                    priceOfIceCream = priceOfIceCream + medium;
                } else if (size.equals("large")) {
                    priceOfIceCream = priceOfIceCream + large;
                }
            }
            
            if(request.getParameter("topping")!=null){
            if (request.getParameter("topping").equals("saltedcaramel")) {
                priceOfIceCream = priceOfIceCream + saltedCaramel;
            }
            }
            if(request.getParameter("topping1")!=null){
            if (request.getParameter("topping1").equals("sugarfreestrawberry")) {
                priceOfIceCream = priceOfIceCream + sugarFreeStrawberry;
            }
            }
            
            
            int quantity=Integer.parseInt(quantityValue);
            priceOfIceCream = priceOfIceCream * quantity;
            
            Random randomNumbergenerator = new Random();
            int randomNumber = (randomNumbergenerator.nextInt((45 - 25) + 1) + 25);
            
            if (quantity == 1) {
                finalMessage = "The total cost of your order is $" + String.format("%.2f", priceOfIceCream)+"<br>"+
                "Your " + flavor + " ice cream will be delivered in about " + randomNumber + " minutes";
            } else {
                finalMessage = "The total cost of your order is $" + String.format("%.2f", priceOfIceCream)+"<br>"+
                "Your " + flavor + " ice creams will be delivered in about " + randomNumber + " minutes";
            }
            out.println("<h2 class=\"newHeading\" style=\"color : green\">Bearcat Ice Cream Order Confirmation</h2>");
           out.println("<h3>"+finalMessage+"</h3>");
            
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
        return "Using AJAX to calculate the ICE CREAM ORDER";
    }// </editor-fold>

}
