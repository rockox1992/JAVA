import java.util.List;

public class Magician extends BaseHero {
   
    private boolean magic;

    public Magician(List<BaseHero> band, int x, int y) {
        super("Magician", 30, 17, 12, 0, new int[]{-2, 0}, 9);
        magic = true;
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side) {
        if (getStatus().equals("Die")) return;
        boolean flag = true;
        int cnt = 0;
        while (flag){
            if (!band.get(cnt).getStatus().equals("Die") && band.get(cnt).health < band.get(cnt).maxHealth){
                band.get(cnt).getDamaged(damage.x);
                setStatus("heal: " + side.get(cnt).getName() + " " + (cnt + 1));
                if (band.get(cnt).health > band.get(cnt).maxHealth) band.get(cnt).health = band.get(cnt).maxHealth;
                // flag = false;
                // cnt = 0;
                return;
            }
            if (++cnt == band.size()) flag = false;
        }
        setStatus("stand");
    }
}
