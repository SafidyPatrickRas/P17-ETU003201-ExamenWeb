
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import db.Connect;
import model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DepenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("ajout prevision");
        String id_prev = req.getParameter("id_prevision");
        String montant = req.getParameter("montant");

        out.println("libele : " + id_prev);
        out.println("montant : " + montant);

        if (id_prev != null && !id_prev.isEmpty() && montant != null && !montant.isEmpty()) {

            Depense dep = new Depense(Integer.valueOf(id_prev), Double.valueOf(montant));
            Prevision prevision = new Prevision();
            Connection c = null;

            try {
                prevision = (Prevision) new Prevision().getById(id_prev);
                c = Connect.getConnection();
                double montantPrevisionTotal = Prevision.sumMontantById(prevision.getLibele(), c);

                out.println("prevision name : " + prevision.getLibele());
                out.println("montant total : " + montantPrevisionTotal);

                if (montantPrevisionTotal - Double.valueOf(montant) >= 0) {
                    out.println("on peut ajout une depnese");
                    dep.save();
                    out.println("Ajout d une nouvelle depense reussi");

                    resp.sendRedirect(req.getContextPath() + "/formDepense");
                } else {
                    out.println("on ne peut pas ajout une depnse car le montant est bas");
                }

            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                String stackTrace = sw.toString();
                out.println("erreur : " + e.getMessage());
                out.println("<pre>" + stackTrace + "</pre>"); //
            } finally {
                try {
                    c.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        } else {
            out.println("il faut completer le formualire");
        }
    }

}
