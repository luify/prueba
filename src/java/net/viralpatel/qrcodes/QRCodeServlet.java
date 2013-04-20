/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.viralpatel.qrcodes;
import Modelo.DocXml;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.glxn.qrgen.QRCode; 
import net.glxn.qrgen.image.ImageType; 
/**
 *
 * @author luify
 */

 @WebServlet(name = "QRCodeServlet", urlPatterns = {"/qrservlet", "/ServletXML"})
public class QRCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/qrservlet")) {
        String qrtext = request.getParameter("qrtext");
        System.out.println(qrtext);
        ByteArrayOutputStream out = QRCode.from(qrtext).to(
                ImageType.PNG).stream();
         
        response.setContentType("image/png");
        response.setContentLength(out.size());
         
        OutputStream outStream = response.getOutputStream();
 
        outStream.write(out.toByteArray());
 
        outStream.flush();
        outStream.close();
        
        
        }
        else if (userPath.equals("/ServletXML")) {
            String numeroOrden =request.getParameter("numeroOrden");
            String statusOrden =request.getParameter("StatusOrden");
            DocXml respuesta = new DocXml(numeroOrden,statusOrden);
            String nextJSP = "/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
       
        
    }
    
    
}