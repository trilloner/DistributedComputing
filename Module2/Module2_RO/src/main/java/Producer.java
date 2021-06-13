import java.util.Date;

public class Producer {
    int id;
    String name;
    String country;

    public Producer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Producer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
