package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
       ImageEditor imageEditor = new ImageEditor();
       List<Graphic> graphics = new ArrayList<Graphic>();

       imageEditor.load();

       imageEditor.groupSelected(graphics);
       imageEditor.draw();


    }
}
