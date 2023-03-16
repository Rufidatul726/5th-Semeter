public class Topic {
    public static final Topic NO_HELP_TOPIC = new Topic("No help for this topic");
    public static final Topic PRINT_TOPIC = new Topic("Print topic");
    public static final Topic PAPER_ORIENTATION_TOPIC = new Topic("Paper orientation topic");
    public static final Topic APPLICATION_TOPIC = new Topic("HelpHandler.Application topic");
    private String topic;

    private Topic(String topic) {
        this.topic = topic;
    }

    public String toString() {
        return topic;
    }
}
