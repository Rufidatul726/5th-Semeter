public class HelpHandler {
    HelpHandler successor;
    static Topic NO_HELP_TOPIC;

    public HelpHandler() {
        HelpHandler h;
        Topic t;
    }

    public static boolean hasHelp() {
        Topic topic = NO_HELP_TOPIC;
        if(topic != NO_HELP_TOPIC)return true;
        return false;
    }

    public void setHandler(HelpHandler handler, Topic topic) {
        //
    }

    public void handleHelp() {
        if(successor != null)
            successor.handleHelp();
    }


    public static class Application extends HelpHandler{
        Application (Topic t){

        }

        public void handleHelp(){
            if(hasHelp()){
                //show help
            }else{
                super.handleHelp();
            }
        }

        public static void main(String[] args) {
            Application app = new Application(Topic.APPLICATION_TOPIC);
            Dialog dialog = new Dialog(app, Topic.PRINT_TOPIC);
            Button button = new Button(dialog, Topic.PAPER_ORIENTATION_TOPIC);
            button.handleHelp();
        }

    }
}
