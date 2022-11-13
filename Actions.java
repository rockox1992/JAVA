import java.util.List;

public interface Actions {
    void strike(BaseHero hero);
    void getDamaged(float damagePower);
    boolean changePosition();
    String indicateStatus();
    String getInfo();
    String getName();
    void step(List<BaseHero> side);

    String returnCondition();
}
