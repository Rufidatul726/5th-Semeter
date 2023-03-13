public abstract class Decorator extends VisualComponent {
    protected VisualComponent component;
    public Decorator(VisualComponent component){}
    public void draw() {
        component.draw();
        System.out.println("Decorator.draw()");
    }
    public void resize() {
        component.resize();
    }
}

