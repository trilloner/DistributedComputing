import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOTask5 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "admin";

    Connection conn = null;
    Statement stmt = null;

    public DAOTask5() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Souvenir> getAllSouvenirsByProducerId(int producerId) {
        List<Souvenir> souvenirList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *  FROM souvenir WHERE producer_id= ?");
            preparedStatement.setInt(1, producerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cardNumber = rs.getInt("cardNumber");
                Date date = rs.getDate("date");
                int price = rs.getInt("price");

                souvenirList.add(new Souvenir(id, name, cardNumber, date, price, producerId));
            }
            return souvenirList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirList;
    }


    public List<Souvenir> getAllSouvenirsByCountry(String country) {
        List<Souvenir> souvenirList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *  FROM souvenir JOIN producer WHERE country = " + "'" + country + "'");
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cardNumber = rs.getInt("cardNumber");
                Date date = rs.getDate("date");
                int price = rs.getInt("price");
                int producerId = rs.getInt("producer_id");
                souvenirList.add(new Souvenir(id, name, cardNumber, date, price, producerId));
            }
            return souvenirList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirList;
    }


    public List<Producer> getAllProducersBySouvenirPrice(int price) {
        List<Producer> souvenirList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT country, producer.name, producer.id  FROM souvenir join producer  where price < ? ");
            preparedStatement.setInt(1, price);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");

                souvenirList.add(new Producer(id, name, country));
            }
            return souvenirList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirList;
    }

    public boolean deleteProducerById(int producerId) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM producer WHERE id= ?");
            preparedStatement.setInt(1, producerId);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Producer> getAllProducersBySouvenirNameAndCountry(String souvenirName, String countryInput) {
        List<Producer> souvenirList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement
                    ("SELECT producer.id, country, producer.name from souvenir join producer where souvenir.name= "
                            + "'" + souvenirName + "'" + " AND producer.country = " + "'" + countryInput + "'");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");

                souvenirList.add(new Producer(id, name, country));
            }
            return souvenirList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirList;
    }


}
