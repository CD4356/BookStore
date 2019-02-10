package entiry;

public class Book {

    private String id;
    private String name;
    private Double price;
    private int number;

    public Book() {

    }

    public Book(String id, String name, Double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
