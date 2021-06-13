import dao.AuthorDaoImpl;
import dao.Connector;
import models.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    AuthorDaoImpl authorDao = new AuthorDaoImpl(Connector.getConnection());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int code = Integer.parseInt(req.getParameter("code"));
        String name = req.getParameter("name");
        String pseudonym = req.getParameter("pseudonym");
        authorDao.update(new Author(code, name, pseudonym));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
