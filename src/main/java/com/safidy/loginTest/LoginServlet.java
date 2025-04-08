
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String nom = req.getParameter("name");
        String password = req.getParameter("password");

        if (nom.equals("safidy") && password.equals("safidy")) {
            HttpSession session = req.getSession();
            String idSessionUser = (String) session.getAttribute("idSessionUser");

            if (idSessionUser == null || idSessionUser.isEmpty()) {
                String idUser = "idUtilisateur";
                session.setAttribute("idSessionUser", idUser);
            } else {
                out.println("Vous êtes déjà connecté");
            }
            RequestDispatcher dispat = req.getRequestDispatcher("acceuil.html");
            dispat.forward(req, resp);
        } else {
            String[] messages = new String[2];
            messages[0] = "Veillez verifier votre nom ou votre mot de passe";
            messages[1] = "error";

            req.setAttribute("messages", messages);

            RequestDispatcher dispat = req.getRequestDispatcher("/index.jsp");

            dispat.forward(req, resp);
        }
    }

}