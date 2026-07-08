import model.User;
import service.UserDAO;


public class Main {
    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User u1 = new User("Vladmir");
        User u2 = new User("Laura");
        User u3 = new User("Don");

//        dao.save(u1);
//        dao.save(u2);
//        dao.save(u3);

        dao.delete("Don");
        
        /// listar cadastros
        for (User u : dao.list()) {
            System.out.println("Name: " + u.getName() + " | mail: " + u.getMail());
        }

    }

}
