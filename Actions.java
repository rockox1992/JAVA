import java.util.List;

public interface Actions {
    void step(List<BaseHero> side);
    String returnCondition();
}
