public class Crossbowman extends BaseHero {

    public Crossbowman(){
        super(String.format("Crossbowman#%d", ++Crossbowman.number), 10, 6, 3, 16,
                new int[]{2, 3}, 4); // super вызывает конструктор обстрактного класса
    }
}

