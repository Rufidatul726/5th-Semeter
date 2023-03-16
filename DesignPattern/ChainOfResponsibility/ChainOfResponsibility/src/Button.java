public class Button extends Widget {
    public Button(Widget w, Topic t) {
        super(w, t);
    }

    public void handleHelp() {
        if(hasHelp()) {
            // show help
        } else {
            super.handleHelp();
        }
    }
}

