import java.util.Date;

public class Souvenir {
    int id;
    String name;
    int cardNumber;
    Date date;
    int price;
    int producerId;

    public Souvenir(int id, String name, int cardNumber, Date date, int price, int producerId) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
        this.date = date;
        this.price = price;
        this.producerId = producerId;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNumber=" + cardNumber +
                ", date=" + date +
                ", price=" + price +
                ", producerId=" + producerId +
                '}';
    }

    public Souvenir() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public Date getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public int getProducerId() {
        return producerId;
    }
}
