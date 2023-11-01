package tikale.bot.help.entity.dto;

import java.util.ArrayList;

public class ConditionDto {

    private String chatName;
    private ArrayList<String> contains;
    private ArrayList<String> startWith;
    private boolean caseSensitive;

    public ConditionDto() {
        super();
    }

    public ConditionDto(String chatName, ArrayList<String> contains, ArrayList<String> startWith, boolean caseSensitive) {
        super();
        this.chatName = chatName;
        this.contains = contains;
        this.startWith = startWith;
        this.caseSensitive = caseSensitive;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public ArrayList<String> getContains() {
        return contains;
    }

    public void setContains(ArrayList<String> contains) {
        this.contains = contains;
    }

    public ArrayList<String> getStartWith() {
        return startWith;
    }

    public void setStartWith(ArrayList<String> startWith) {
        this.startWith = startWith;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    @Override
    public String toString() {
        return "ConditionDto [chatName=" + chatName + ", contains=" + contains + ", startWith=" + startWith + ", caseSensitive=" + caseSensitive + "]";
    }

}
