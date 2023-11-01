package tikale.bot.help.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {

    @JsonProperty("message_id")
    private long id;

    private MessageFromDto from;
    private MessageChatDto chat;

    private long date;
    private String text;

    public MessageDto() {
        super();
    }

    public MessageDto(long id, MessageFromDto from, MessageChatDto chat, long date, String text) {
        super();
        this.id = id;
        this.from = from;
        this.chat = chat;
        this.date = date;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MessageFromDto getFrom() {
        return from;
    }

    public void setFrom(MessageFromDto from) {
        this.from = from;
    }

    public MessageChatDto getChat() {
        return chat;
    }

    public void setChat(MessageChatDto chat) {
        this.chat = chat;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessageDto [id=" + id + ", from=" + from + ", chat=" + chat + ", date=" + date + ", text=" + text + "]";
    }

}
