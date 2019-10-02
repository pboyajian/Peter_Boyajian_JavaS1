public class Farmer extends baseClass {

    public Farmer(String name) {
        super.name=name;
        strength=75;
        health=100;
        stamina=75;
        speed=10;
        attackPower=1;
    }

    public Farmer() {
        strength=75;
        health=100;
        stamina=75;
        speed=10;
        attackPower=1;
    }
    public void plow(){}
    public void harvest(){}

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
