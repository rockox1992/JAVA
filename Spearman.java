import java.util.List;

public class Spearman extends BaseHero {
    public Spearman(List<BaseHero> band, int x, int y){
        super(String.format("Spearman#%d", ++Spearman.number), 10, 4, 5, 0,
                new int[]{1, 3}, 4);
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;

        float tmpH = side.get(0).health, index = 0;
        for (int i = 1; i < side.size(); i++) {
            if (tmpH > side.get(i).health) {
                tmpH = side.get(i).health;
                index = i;
            }
        }
        side.get(cnt).getDamaged((damage.x + damage.y)/2);
        System.out.println(band.get(cnt).getName() + " GreenMDD " + ((damage.x + damage.y)/2) + " " + getName());
    }
}