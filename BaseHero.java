
public abstract class BaseHero implements Action {
    protected static int number;
    private String name;
    private int attack;
    private int defence;
    private int shot;
    private int[] damage;
    private int health;
    private int speed;
    private boolean status;


    static {
        number = 0;
    }


    public int getArrows(){return shot;}

    public int setArrows(int shot){
        if (shot < 1) return -1;
        if (shot > 32) return -2;
        this.shot = shot;
        return shot;
    }

    public BaseHero(String name, int health){
        this.name = name;
        this.health = health;
        status = true;
    }

    public BaseHero(String name, int health, int attack, int defence, int shot, int[] damage, int speed) {
        this(name, health);
        this.attack = attack;
        this.defence = defence;
        this.shot = shot;
        this.damage = damage;
        this.speed = speed;
    }

    public String getInfo() {
        return String.format("%s: %s hlth: %d attk: %d protect: %d shot: %d dmg: %d-%d speed: %d",
                this.getClass().getSimpleName(), name, health, attack, defence, shot, damage[0], damage[1], speed);
    }

    public String getName() {return name;}
    public int getAttack() {return  attack;}
    public int getDefence() {return defence;}
    public int[] getDamage() {return damage;}
    public int getHealth() {return health;}
    public int getShot() {return shot;}
    public int getSpeed() {return speed;}
    public boolean getStatus() {return status;}

    public static  int getNumber(){return number;}

    public void strike(BaseHero hero) {}
    public void getDamaged(int damagePower) {}
    public boolean changePosition() {return false;}
    public String indicateStatus() {return null;}
}
