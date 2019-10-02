public abstract class baseClass {
    public String name;
    public int strength;
    public int health;
    public int stamina;
    public int speed;
    public int attackPower;

    abstract void run();
    abstract void attack();
    abstract void heal();
    abstract void decreaseHealth();
    abstract void increaseStamina();
    abstract void decreaseStamina();

}
