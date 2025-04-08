
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PrevisionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("ajout prevision");
        String libele = req.getParameter("libele");
        String montant = req.getParameter("montant");

        out.println("libele : " + libele);
        out.println("montant : " + montant);

        if (libele != null && !libele.isEmpty() && montant != null && !montant.isEmpty()) {
            out.println("Ajouter");
            Prevision prevision = new Prevision(libele, Double.valueOf(montant));
            try {
                prevision.save();
                RequestDispatcher dispat = req.getRequestDispatcher("prevision.html");
                dispat.forward(req, resp);
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                String stackTrace = sw.toString();
                out.println("erreur : " + e.getMessage());
                out.println("<pre>" + stackTrace + "</pre>"); //
            }

        } else {
            out.println("il faut completer le formualire");
        }
    }

}
