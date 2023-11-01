package tikale.bot.help.entity;

public enum HelpType {
    HELP("/help"),
    OTHER("");

    private String text;

    private HelpType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static HelpType find(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return OTHER;
        }

        for (HelpType ht : HelpType.values()) {
            if (ht.getText().equals(pattern)) {
                return ht;
            }
        }

        return OTHER;
    }

}
