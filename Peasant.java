import java.util.List;

public class Peasant extends BaseHero {

    private boolean delivery;

    public Peasant(List<BaseHero> side, int x, int y, int cnt) {
        super("Peasant", 5, 1, 1, 0, new int[]{1, 0}, 3);
        count = cnt;
        delivery = true;
        position = new Vector2(x, y);
    }
}
