package CompositePattern;

public class Dot implements Graphic {
    public int x;
    public int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Dot at (" + x + "," + y + ")");
    }

}
