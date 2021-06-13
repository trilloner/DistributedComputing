package models;

public class Author {
    private int code;
    private String name;
    private String pseudonym;

    public Author(String name, String pseudonym) {
        this.name = name;
        this.pseudonym = pseudonym;
    }

    public Author() {
    }

    public Author(int code, String name, String pseudonym) {
        this.code = code;
        this.name = name;
        this.pseudonym = pseudonym;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
}
