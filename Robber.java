public class Robber extends BaseHero {

    public Robber(){
        super(String.format("Robber#%d", ++Robber.number), 10, 8, 3, 0,
                new int[]{2, 4}, 6); // super вызывает конструктор обстрактного класса
    }

}


