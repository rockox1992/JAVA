public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkPlace(Vector2 place){
        if (place.x == x && place.y == y)
            return true;
        return false;
    }
}