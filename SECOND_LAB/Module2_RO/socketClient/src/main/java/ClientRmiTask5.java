import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientRmiTask5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            RmiInterface st = (RmiInterface) Naming.lookup("rmi://localhost:8080/souvenirs");

            System.out.println("1. Select all souvenirs by producer id \n" +
                    "2. Select all souvenirs by country  \n" +
                    "3. Select all producers by souvenir price  \n" +
                    "4. Select all producers by souvenir name and country  \n" +
                    "5. Delete producer by id  \n Select:");
            int variant = s.nextInt();

            switch (variant) {
                case 1 -> {
                    System.out.println("Input id:");
                    int id = s.nextInt();
                    System.out.println(st.getAllSouvenirsByProducerId(id));
                }
                case 2 -> {
                    System.out.println("Input country:");
                    String countryName = s.next();
                    System.out.println(st.getAllSouvenirsByCountry(countryName));
                }
                case 3 -> {
                    System.out.println("Input price:");
                    int price = s.nextInt();
                    System.out.println(st.getAllProducersBySouvenirPrice(price));
                }
                case 4 -> {
                    System.out.println("Input souvenir name:");
                    String souvenirName = s.next();
                    System.out.println("Input country: ");
                    String countryName = s.next();
                    System.out.println(st.getAllProducersBySouvenirNameAndCountry(souvenirName, countryName));
                }
                case 5 -> {
                    System.out.println("Input id:");
                    int id = s.nextInt();
                    System.out.println(st.deleteProducerById(id));
                }
                default -> {
                    return;
                }
            }
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
