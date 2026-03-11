import br.com.fabioperettig.goodburger.*;
import br.com.fabioperettig.goodburger.messages.*;



public class main {
    static goodPrints prints = new goodPrints();

    public static void main(String[] args) {

        prints.printHeader();
        Order order = new Order();

        ////////

        order.setBuilder(new GoodBurger());
        Burger b1 = order.buildBurger();
        b1.print();

        order.setBuilder(new GoodChickwich());
        Burger b2 = order.buildBurger();
        b2.print();

    }

}