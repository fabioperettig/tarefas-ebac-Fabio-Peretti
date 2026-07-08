package model;

public class User {

    private String name;
    private String mail;

    public User(String name) {
        this.name = name;
        this.mail = name.toLowerCase() + "@mailUser.com";
    }

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
}
