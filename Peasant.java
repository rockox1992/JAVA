import java.util.List;

public class Peasant extends BaseHero {

    private boolean delivery;

    public Peasant(List<BaseHero> side, int x, int y) {
        super("Peasant", 5, 1, 1, 0, new int[]{1, 0}, 3);
        delivery = true;
        position = new Vector2(x, y);
    }
}
