public class Dialog extends Widget{
    HelpHandler helpHandler;

    Dialog(HelpHandler h, Topic t) {
        super();
        helpHandler = h;
        helpHandler.setHandler(this, t);
    }

    Dialog(Widget w, Topic t) {
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
