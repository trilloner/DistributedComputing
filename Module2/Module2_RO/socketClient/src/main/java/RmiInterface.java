import java.rmi.Remote;
import java.util.List;

public interface RmiInterface extends Remote {

    List<Souvenir> getAllSouvenirsByProducerId(int id);

    List<Souvenir> getAllSouvenirsByCountry(String country);

    List<Producer> getAllProducersBySouvenirPrice(int price);

    boolean deleteProducerById(int producerId);

    List<Producer> getAllProducersBySouvenirNameAndCountry(String souvenirName, String countryInput);
}
