package dao;

import models.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements DAO<Author> {

    Connection connection;

    public AuthorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authorList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT  * FROM author");
            while (resultSet.next()) {
                Author author = new Author();
                author.setCode(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setPseudonym(resultSet.getString("pseudonym"));
                authorList.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    @Override
    public Author save(Author author) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO author(name,pseudonym) VALUES(?,?)");
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getPseudonym());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public boolean update(Author author) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE author SET name= ?, pseudonym= ? WHERE id=?");
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getPseudonym());
            preparedStatement.setInt(3, author.getCode());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM author WHERE id=?");
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
