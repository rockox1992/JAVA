import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        List<BaseHero> darkSide = new ArrayList<>();
        List<BaseHero> whiteSide = new ArrayList<>();

        darkSide.add(new Peasant());
        darkSide.add(new Robber());
        darkSide.add(new Sniper());
        darkSide.add(new Magician());

        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            switch (rnd.nextInt(4)) {
                case 0 -> darkSide.add(new Peasant());
                case 1 -> darkSide.add(new Robber());
                case 2 -> darkSide.add(new Sniper());
                default -> darkSide.add(new Magician());
            }
        }

        whiteSide.add(new Peasant());
        whiteSide.add(new Monk());
        whiteSide.add(new Crossbowman());
        whiteSide.add(new Spearman());
        for (int i = 0; i < 4; i++) {
            switch (rnd.nextInt(4)) {
                case 0 -> whiteSide.add(new Peasant());
                case 1 -> whiteSide.add(new Monk());
                case 2 -> whiteSide.add(new Crossbowman());
                default -> whiteSide.add(new Spearman());
            }
        }

        darkSide.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();
        whiteSide.forEach(n -> System.out.println(n.getInfo()));
    }

}
