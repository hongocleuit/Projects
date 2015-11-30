package main;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Set the Content-Type header res.setContentType("text/html");
        // Return early if this is a HEAD
        if (req.getMethod().equals("HEAD")) return;
        // Proceed otherwise
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello, " + name + "</TITLE></HEAD>"); out.println("<BODY>");
        out.println("Hello, " + name);
        out.println("</BODY></HTML>");
    }
}
