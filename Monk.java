import java.util.List;

public class Monk extends BaseHero {
    private boolean magic;

    public Monk(List<BaseHero> band, int x, int y) {
        super(String.format("Monk#%d", ++Monk.number), 30, 12, 7, 0, new int[]{-4, 0}, 5);
        magic = true;
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public String getInfo() {
        return String.format("%s magic: %b", super.getInfo(), magic);
    }

    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;
        float hp = 4;
        while (flag) {
            if (band.get(cnt).health < band.get(cnt).maxHealth) {
                band.get(cnt).health = band.get(cnt).health - band.get(cnt).damage.x;
                if (band.get(cnt).health > band.get(cnt).maxHealth) {
                    hp = - band.get(cnt).damage.x - (band.get(cnt).health - band.get(cnt).maxHealth);
                    band.get(cnt).health = band.get(cnt).maxHealth;
                }

                flag = false;
                System.out.println(band.get(cnt).getName() + " healed on " + hp + " " + getName());
                cnt = 0;
            }
            if (++cnt == band.size())
                flag = false;
            System.out.println(getName() + " Nobody to heal");
        }

    }
}
