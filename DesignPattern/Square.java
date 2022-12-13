public class Square extends Rectangle{
    public double side;
    public Square(double side){
        super(side, side);
        this.side= side;
    }

    public void draw(){
        System.out.println("Drawing Square...");
    }

    public String setColor(){
        return "red";
    }

}
