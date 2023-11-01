package tikale.bot.help.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageFromDto {

    private long id;

    @JsonProperty("is_bot")
    private boolean isBot;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("language_code")
    private String languageCode;

    public MessageFromDto() {
        super();
    }

    public MessageFromDto(long id, boolean isBot, String firstName, String userName, String languageCode) {
        super();
        this.id = id;
        this.isBot = isBot;
        this.firstName = firstName;
        this.userName = userName;
        this.languageCode = languageCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean isBot) {
        this.isBot = isBot;
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

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        return "MessageFromDto [id=" + id + ", isBot=" + isBot + ", firstName=" + firstName + ", userName=" + userName + ", languageCode=" + languageCode + "]";
    }

}
