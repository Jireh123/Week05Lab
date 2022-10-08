package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author Jireh
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String logout = request.getParameter("logout");
        
        if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (user != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);        
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("message", "Username/Password were invalid.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        AccountService as = new AccountService();
        User user = as.login(username, password);
        
        session = request.getSession();
        if (user != null) {
            session.setAttribute("user", user);
            response.sendRedirect("home");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Username/Password were invalid.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
