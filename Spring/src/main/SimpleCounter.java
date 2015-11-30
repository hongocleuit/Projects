package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

public class SimpleCounter extends HttpServlet
{
    static int classCount = 0;
    int count;
    static LinkedHashSet<HttpServlet> instances = new LinkedHashSet<HttpServlet>();


    @Override
    public void init() throws ServletException
    {
        String initial = getInitParameter("initial");
        try
        {
            count = Integer.parseInt(initial);
        }
        catch (NumberFormatException e)
        {
            count = 0;
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        count++;
        out.println("Since loading, this servlet instance has been accessed " +
                count + " times.");
        // Keep track of the instance count by putting a reference to this
        // instance in a hashtable. Duplicate entries are ignored.
        // The size() method returns the number of unique instances stored.
        instances.add(this);
        out.println("There are currently " + instances.size() + " instances.");
        classCount++;
        out.println("Across all instances, this servlet class has been " +"accessed " + classCount + " times.");

    }
}
