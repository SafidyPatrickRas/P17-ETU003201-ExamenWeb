import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FormLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // NE PAS APPELER super.doGet(req, resp) !!
        RequestDispatcher dispat = req.getRequestDispatcher("index.html");
        dispat.forward(req, resp);
    }

}