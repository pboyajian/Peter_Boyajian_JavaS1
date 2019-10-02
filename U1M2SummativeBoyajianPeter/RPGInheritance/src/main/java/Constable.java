public class Constable extends baseClass {
    public String jurisdiction;

    public Constable(String name,String jurisdiction) {
        this.jurisdiction = jurisdiction;
        super.name=name;
        strength=60;
        health=100;
        stamina=60;
        speed=20;
        attackPower=5;
    }

    public Constable() {
        strength=60;
        health=100;
        stamina=60;
        speed=20;
        attackPower=5;
    }

    public void arrest(){}

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
