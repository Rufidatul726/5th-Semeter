public class Widget extends HelpHandler {
    private Widget parent;

    Widget(Widget w, Topic t) {
        parent = w;
    }

    public Widget() {
    }

    public void handleHelp() {
        if(hasHelp()) {
            // show help
        } else {
            super.handleHelp();
        }
    }
}

