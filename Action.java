public interface Action {
    void strike(BaseHero hero);
    void getDamaged(int damagePower);
    boolean changePosition();
    String indicateStatus();
    String getInfo();
    String getName();
}
