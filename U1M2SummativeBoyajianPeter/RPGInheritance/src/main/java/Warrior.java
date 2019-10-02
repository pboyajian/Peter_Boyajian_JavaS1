public class Warrior extends baseClass {
    private int shieldStrength;

    public Warrior(String name) {
        super.name=name;
        strength=75;
        health=100;
        stamina=100;
        speed=50;
        attackPower=10;
        shieldStrength=100;
    }

    public Warrior() {
        strength=75;
        health=100;
        stamina=100;
        speed=50;
        attackPower=10;
        shieldStrength=100;
    }

    public void decreaseShieldStrength(){}

    @Override
    void run() {

    }

    @Override
    void attack() {

    }

    @Override
    void heal() {

    }

    @Override
    void decreaseHealth() {

    }

    @Override
    void increaseStamina() {

    }

    @Override
    void decreaseStamina() {

    }
}
