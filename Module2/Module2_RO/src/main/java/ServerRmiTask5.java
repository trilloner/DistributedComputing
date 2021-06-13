import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerRmiTask5 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(8080);
            RmiInterface service = new Service();
            registry.rebind("souvenirs", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static class Service extends UnicastRemoteObject implements RmiInterface {
        DAOTask5 repository = new DAOTask5();

        Service() throws RemoteException {
            super();
        }

        @Override
        public List<Souvenir> getAllSouvenirsByProducerId(int id) {
            return repository.getAllSouvenirsByProducerId(id);
        }

        @Override
        public List<Souvenir> getAllSouvenirsByCountry(String country) {
            return repository.getAllSouvenirsByCountry(country);
        }

        @Override
        public List<Producer> getAllProducersBySouvenirPrice(int price) {
            return repository.getAllProducersBySouvenirPrice(price);
        }


        @Override
        public boolean deleteProducerById(int producerId) {
            return repository.deleteProducerById(producerId);
        }

        @Override
        public List<Producer> getAllProducersBySouvenirNameAndCountry(String souvenirName, String countryInput) {
            return repository.getAllProducersBySouvenirNameAndCountry(souvenirName, countryInput);
        }

    }
}
