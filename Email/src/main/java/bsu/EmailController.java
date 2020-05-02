package bsu;

import bsu.emailUtils.EmailSender;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmailController", urlPatterns = {"/controller"})
public class EmailController extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String password;

    public void init() {
        ServletContext context = getServletContext();
        this.host = context.getInitParameter("host");
        this.port = context.getInitParameter("port");
        this.user = context.getInitParameter("user");
        this.password = context.getInitParameter("pass");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        String resultMessage = "";

        try {
            EmailSender.sendEmail(host, port, user, password, recipient, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            request.getRequestDispatcher("pages/main.jsp").forward(request, response);
        }
    }

}
