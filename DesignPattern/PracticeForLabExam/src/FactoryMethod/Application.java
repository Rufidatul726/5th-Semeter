package FactoryMethod;

import java.util.Scanner;

public class Application {
    private Dialog dialog;

    public Application(Dialog dialog) {
        this.dialog = dialog;
    }

    public void render() {
        dialog.render();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String osName = scanner.nextLine();

        Dialog dialog;
        if (osName.equals("Windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HTMLdialog();
        }

        Application app = new Application(dialog);
        app.render();
    }
}
