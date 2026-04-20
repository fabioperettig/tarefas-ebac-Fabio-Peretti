import java.util.List;

public class User {

    private String id;
    private String name;
    private String nationality;
    private int age;

    /// empty ctor
    public User() {}

    /// default ctor
    public User(String id, String name, String nationality, int age) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }
    public int getAge() {
        return age;
    }


    public List<User> userList(){
        User user1 = new User("u1", "Zeke", "USA", 19);
        User user2 = new User("u2", "Julie", "USA", 22);
        User user3 = new User("u3", "Zombie", "Brazil", 118);
        User user4 = new User("u4", "Mummy", "Egypt", 4800);
        User user5 = new User("u5", "Lagoon Monster", "Caribbean", 80);

        return List.of(user1, user2, user3, user4, user5);
    }

}
