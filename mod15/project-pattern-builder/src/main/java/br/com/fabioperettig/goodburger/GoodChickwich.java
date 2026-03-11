package br.com.fabioperettig.goodburger;

public class GoodChickwich extends BurgerBuilder{

    @Override public void buildBun(){
        burger.setBun("french bread");
    }

    @Override
    public void buildMeat() {
        burger.setMeat("crispy chicken patties");
    }

    @Override
    public void buildSalad() {
        burger.setSalad("shredded lettuce, white onion, and tomato");
    }

    @Override
    public void buildCheese() {
        burger.setCheese("american cheese");
    }

    @Override
    public void buildSauce() {
        burger.setSauce("Ed's Special Sauce ");
    }

}
