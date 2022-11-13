import java.util.List;

public class Robber extends BaseHero {

    public Robber(List<BaseHero> side, int x, int y){
        super(String.format("Robber#%d", ++Robber.number), 10, 8, 3, 0,
                new int[]{2, 4}, 6); // super вызывает конструктор обстрактного класса
        position = new Vector2(x, y);
        super.setBand(side);
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
        System.out.println(band.get(cnt).getName() + " BlueMDD " + ((damage.x + damage.y)/2) + " " + getName());
    }
}


