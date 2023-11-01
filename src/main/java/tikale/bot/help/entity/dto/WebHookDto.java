package tikale.bot.help.entity.dto;

public class WebHookDto {

    private long id;
    private String name;
    private long userId;
    private String url;
    private boolean isPutToQueue;
    private ConditionDto condition;

    public WebHookDto() {
        super();
    }

    public WebHookDto(long id, String name, long userId, String url, boolean isPutToQueue, ConditionDto condition) {
        super();
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.url = url;
        this.isPutToQueue = isPutToQueue;
        this.condition = condition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPutToQueue() {
        return isPutToQueue;
    }

    public void setPutToQueue(boolean isPutToQueue) {
        this.isPutToQueue = isPutToQueue;
    }

    public ConditionDto getCondition() {
        return condition;
    }

    public void setCondition(ConditionDto condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "WebHookDto [id=" + id + ", name=" + name + ", userId=" + userId + ", url=" + url + ", isPutToQueue=" + isPutToQueue + ", condition=" + condition
                + "]";
    }

}
