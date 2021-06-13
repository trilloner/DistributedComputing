package dao;

import models.Author;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements DAO<Book> {
    Connection connection;

    public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT  * FROM book");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setAuthorId(resultSet.getInt("author_id"));
                book.setYear(resultSet.getInt("year"));
                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book save(Book item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO book(name, genre, year, author_id) VALUES(?,?,?,?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getGenre());
            preparedStatement.setInt(3, item.getYear());
            preparedStatement.setInt(4, item.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE id=?");
            preparedStatement.setInt(1, item);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public void close() throws Exception {

    }
}
