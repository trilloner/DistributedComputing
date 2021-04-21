import dao.BookDaoImpl;
import dao.Connector;
import models.Author;
import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    BookDaoImpl bookDao = new BookDaoImpl(Connector.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookDao.findAll());
        req.setAttribute("bookTitle", "Books:");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        int year = Integer.parseInt(req.getParameter("year"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        bookDao.save(new Book(year, name,genre,authorId));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
