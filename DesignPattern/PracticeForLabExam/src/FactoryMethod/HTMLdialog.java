package FactoryMethod;

public class HTMLdialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLbutton();
    }

}
