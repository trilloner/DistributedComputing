import dao.AuthorDaoImpl;
import dao.Connector;
import models.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {

    AuthorDaoImpl authorDao = new AuthorDaoImpl(Connector.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", authorDao.findAll());
        req.setAttribute("authorTitle", "Authors: ");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String pseudonym = req.getParameter("pseudonym");
        authorDao.save(new Author(name, pseudonym));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
