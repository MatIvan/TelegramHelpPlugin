package tikale.bot.help.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageChatDto {

    private long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("username")
    private String userName;

    private String type;

    public MessageChatDto() {
        super();
    }

    public MessageChatDto(long id, String firstName, String userName, String type) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.userName = userName;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageChatDto [id=" + id + ", firstName=" + firstName + ", userName=" + userName + ", type=" + type + "]";
    }

}
