package FactoryMethod;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Render Windows Button");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }

}
