import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import model.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FormDepenseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Prevision prev = new Prevision();
        ArrayList<BaseObject> previsions = new ArrayList<>();

        try {
            previsions = prev.findAllGrouped();
            req.setAttribute("previsions", previsions);

            RequestDispatcher dispat = req.getRequestDispatcher("/depense.jsp");

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