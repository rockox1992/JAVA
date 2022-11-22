import java.util.List;

public class Crossbowman extends BaseHero {
    
    public Crossbowman(List<BaseHero> band, int x, int y, int cnt) {
        super("Crossbowman", 20, 6, 3, 12, new int[]{2, 5}, 4);
        count = cnt;
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side) {
        if (getStatus().equals("Die")) return;
        float dist = Integer.MAX_VALUE;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < side.size(); i++) {
            float tmpDist = getDist(side.get(i).getPosition());
            if (!side.get(i).getStatus().equals("Die") && dist>tmpDist) {
                dist = tmpDist;
                index = i;
                flag = true;
            }
        }

        if (shot > 0 & flag) {
            setStatus("sh_attack: " + side.get(index).getName() + " " + (index + 1) );
            shot--;
            side.get(index).getDamaged((damage.x+damage.y) * count/2);
            for (BaseHero p: band) {
                if (p.getName().equals("Peasant")) shot++;
            }
            return;
        }
        setStatus("stand");
    }
}
