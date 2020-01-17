package lu.pistache.callmelater;

public class GreetingReply {

    private final long id;
    private final String content;

    public GreetingReply(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}