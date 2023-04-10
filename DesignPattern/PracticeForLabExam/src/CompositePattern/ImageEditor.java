package CompositePattern;

import java.util.List;

public class ImageEditor {
    // All of the graphics in the image.
    private CompoundGraphic allGraphics = new CompoundGraphic();

    // Loads the selected graphic.
    public void load() {
        allGraphics.add(new Dot(1, 2));
        allGraphics.add(new Circle(5, 3, 10));
        CompoundGraphic graphic = new CompoundGraphic();
        graphic.add(new Dot(10, 10));
        graphic.add(new Circle(10, 11, 5));
        allGraphics.add(graphic);
    }

    // Group the selected graphics.
    public void groupSelected(List<Graphic>selectedGraphics) {
        // Create a group that consists of the selected graphics.
        CompoundGraphic group = new CompoundGraphic();
        for (Graphic graphic : selectedGraphics) {
            group.add(graphic);
        }
        // Remove the selected graphics from the list and then add the group.
        for (Graphic graphic : selectedGraphics) {
            allGraphics.remove(graphic);
        }

        allGraphics.add(group);
    }

    // Draw the image.
    public void draw() {
        allGraphics.draw();
    }

}
