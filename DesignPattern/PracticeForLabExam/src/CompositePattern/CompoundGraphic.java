package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class CompoundGraphic implements Graphic {
    // Collection of child graphics.
    private List<Graphic> childGraphics = new ArrayList<Graphic>();

    // Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    // Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }

    public void move(int x, int y) {
        for (Graphic graphic : childGraphics) {
            graphic.move(x, y);
        }
    }

    public void draw() {
        for (Graphic graphic : childGraphics) {
            graphic.draw();
        }
    }

}
