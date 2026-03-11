package br.com.fabioperettig.goodburger;

public class GoodVeggie extends BurgerBuilder{

    @Override public void buildBun(){
        burger.setBun("white buns");
    }

    @Override
    public void buildMeat() {
        burger.setMeat("shimeji patties");
    }

    @Override
    public void buildSalad() {
        burger.setSalad("shredded lettuce, white onion, and tomato");
    }

    @Override
    public void buildCheese() {
        burger.setCheese("white cheese");
    }

    @Override
    public void buildSauce() {
        burger.setSauce("Ed's Special Sauce");
    }

}
