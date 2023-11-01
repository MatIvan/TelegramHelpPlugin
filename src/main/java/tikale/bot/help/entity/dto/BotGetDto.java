package tikale.bot.help.entity.dto;

public class BotGetDto {

    private WebHookDto hook;
    private MessageDto message;

    public BotGetDto() {
        super();
    }

    public BotGetDto(WebHookDto hook, MessageDto message) {
        super();
        this.hook = hook;
        this.message = message;
    }

    public WebHookDto getHook() {
        return hook;
    }

    public void setHook(WebHookDto hook) {
        this.hook = hook;
    }

    public MessageDto getMessage() {
        return message;
    }

    public void setMessage(MessageDto message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BotGetDto [hook=" + hook + ", message=" + message + "]";
    }

}
