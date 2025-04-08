import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.BaseObject;
import model.Stat;

public class EtaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        // NE PAS APPELER super.doGet(req, resp) !!
        Stat stat = new Stat();
        ArrayList<BaseObject> stats = new ArrayList<>();
        try {
            stats = stat.findAll();
            req.setAttribute("stats", stats);
            RequestDispatcher dispat = req.getRequestDispatcher("/etas.jsp");
            dispat.forward(req, resp);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            out.println("erreur : " + e.getMessage());
            out.println("<pre>" + stackTrace + "</pre>"); //
        }

    }

}