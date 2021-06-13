package models;

public class Book {
    private int id;
    private int year;
    private String name;
    private String genre;
    private int authorId;

    public Book(int year, String name, String genre, int authorId) {
        this.year = year;
        this.name = name;
        this.genre = genre;
        this.authorId = authorId;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
