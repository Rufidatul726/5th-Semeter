public class Rectangle extends ShapeTest{
    public double length;
    public double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle....");
    }
    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public String setColor() {
        return "Blue";
    }
}
