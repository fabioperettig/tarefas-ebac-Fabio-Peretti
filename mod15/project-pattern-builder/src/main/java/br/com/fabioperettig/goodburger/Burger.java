package br.com.fabioperettig.goodburger;

/**
 * @author fabioperettiguimaraes
 */
public class Burger {

    private String bun = "no bun";
    private String meat = "no meat";
    private String salad = "no salad";
    private String cheese = "no cheese";
    private String sauce = "no sauce";


    //setters
    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void print(){
        System.out.printf("\n--- Your burger is finished! ---\nBun: %s | Meat: %s | Cheese: %s | Salad: %s | Sauce: %s\n",
                bun, meat, cheese, salad, sauce);
    }

}
