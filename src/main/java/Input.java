public record Input(String value, int count) {

    public String getValue() {
        return value();
    }

    public int getWordCount() {
        return count();
    }
}