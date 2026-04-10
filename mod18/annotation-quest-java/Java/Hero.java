
public class Hero {

    @MagicItem(name = "Excalibur", atkBonus = 15)
    private String sword;

    @MagicItem(name = "Oak Shield", defBonus = 20)
    private String shield;

    @MagicItem(name = "Dark ring", cursed = true)
    private String accessory;

    private int Strength;
    private int Constitution;

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getConstitution() {
        return Constitution;
    }

    public void setConstitution(int constitution) {
        Constitution = constitution;
    }

    @Skill(name = "Fury slash", manaCost = 10, baseDamage = 30)
    public void attack(){
        System.out.println("The hero attacks vigorously!");
    }
}
