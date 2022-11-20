import java.util.List;

public class Sniper extends BaseHero {
    
    public Sniper(List<BaseHero> band, int x, int y) {
        super("Sniper", 15, 12, 10, 10, new int[]{4, 6}, 9);
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
            side.get(index).getDamaged((damage.x+damage.y)/2);
            for (BaseHero p: band) {
                if (p.getName().equals("Peasant")) shot++;
            }
            return;
        }
        setStatus("stand");
    }
}
