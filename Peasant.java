public class Peasant extends BaseHero {
    private boolean delivery;
    public Peasant(){
        super(String.format("Peasant#%d", ++Peasant.number), 1, 1, 1, 0, new int[]{0, 1}, 3);
        delivery = true;

    }

    @Override
    public String getInfo() {return String.format("%s delivery: %b", super.getInfo(), delivery);}

}