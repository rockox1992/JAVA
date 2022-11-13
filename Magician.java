import java.util.List;

public class Magician extends BaseHero {
    private boolean magic;
    public Magician(List<BaseHero> band, int x, int y){
        super(String.format("Magician#%d", ++Magician.number), 30, 17, 12, 0, new int[]{-5, 0}, 9);
        magic = true;
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public String getInfo() {return String.format("%s magic: %b", super.getInfo(), magic);}

    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;
        float hp = 5;
        while (flag){
            if (band.get(cnt).health < band.get(cnt).maxHealth){
                band.get(cnt).health = band.get(cnt).health - band.get(cnt).damage.x;
                if (band.get(cnt).health > band.get(cnt).maxHealth) {
                    hp = - band.get(cnt).damage.x - (band.get(cnt).health - band.get(cnt).maxHealth);
                    band.get(cnt).health = band.get(cnt).maxHealth;
                }

                flag = false;
                System.out.println(band.get(cnt).getName() + " healed on " + hp + " " + getName());
                cnt = 0;
            }
            if(++cnt == band.size())
                flag = false;
            System.out.println(getName() + " Nobody to heal");
        }
    } // сделать метод повреждения, нельзя писать в action, добавить еще одну банду чужих. поле 10 на 10 и степ для монка

}