import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FormPrevisionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                RequestDispatcher dispat = req.getRequestDispatcher("prevision.html");
                dispat.forward(req, resp);
    }

}