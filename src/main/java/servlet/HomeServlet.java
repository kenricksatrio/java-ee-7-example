package servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
