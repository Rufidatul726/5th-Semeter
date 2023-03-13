public class BorderDecorator extends Decorator {
    private int _width;

    public BorderDecorator(VisualComponent component, int borderWidth) {
        super(component);
        _width = borderWidth;
    }

    public void draw() {
        super.draw();
        drawBorder(_width);
        System.out.println("BorderDecorator.draw()");
    }
    private void drawBorder(int borderWidth) {
        // ...
    }

}

