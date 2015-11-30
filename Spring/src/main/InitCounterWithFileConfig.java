package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class InitCounterWithFileConfig extends HttpServlet {
    int count;

    public void init() throws ServletException
    {
        // Try to load the initial count from our saved persistent state
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try
        {
            fileReader = new FileReader("InitDestroyCounter.initial");
            bufferedReader = new BufferedReader(fileReader);
            String initial = bufferedReader.readLine();
            count = Integer.parseInt(initial);
            return;
        }
        catch (FileNotFoundException e) { }
        catch (IOException ignored) { }
        catch (NumberFormatException ignored) { }
        finally
        {
            // Make sure to close the file try
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                } catch (IOException ignored) { }
            }
        }
        String initial = getInitParameter("initial");
        try
        {
        count = Integer.parseInt(initial);
        return;
        }
        catch (NumberFormatException ignored) { } //

        // Default to an initial count of "0"
        count = 0;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        count++;
        out.println("Since the beginning, this servlet has been accessed " +
                count + " times.");
    }

    public void destroy()
    {
        super.destroy(); // entirely optional
        saveState();
    }

    public void saveState()
    {
        // Try to save the accumulated count
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try
        {
            fileWriter = new FileWriter("InitDestroyCounter.initial");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(count);
            return;
        }
        catch (IOException e) {
        // problem during write
        // Log the exception. See Chapter 5.
        }
        finally {
        // Make sure to close the file
            if (printWriter != null)
            {
                printWriter.close();
            }
        }
    }

}
