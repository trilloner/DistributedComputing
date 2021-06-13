import dao.AuthorDaoImpl;
import dao.BookDaoImpl;
import dao.Connector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    BookDaoImpl bookDao = new BookDaoImpl(Connector.getConnection());
    AuthorDaoImpl authorDao = new AuthorDaoImpl(Connector.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String book =Optional.ofNullable(req.getParameter("id")).orElse("empty");
        String author =Optional.ofNullable(req.getParameter("authorId")).orElse("empty");
        if (!book.equals("empty")){
            bookDao.deleteById(Integer.parseInt(book));
        }
        else{
            authorDao.deleteById(Integer.parseInt(author));
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
