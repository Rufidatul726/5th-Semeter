public class Main {
    public static void main(String[] args) {
        double length = 15.0;
        double width = 10.0;

        Rectangle rectangle = new Rectangle(length, width);
        rectangle.draw();
        System.out.println(rectangle.setColor());
        System.out.println(rectangle.getArea());

        Square square = new Square(length);
        square.draw();
        System.out.println(square.setColor());
        System.out.println(square.getArea());



    }
}