// Клас, який представляє текст
class Text {
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.getValue()).append(" ");
        }
        return result.toString().trim();
    }
    public String getValueWithoutWhiteSpaces() {
        return this.getValue().replaceAll("[\t ]+", " ");
    }
    public Sentence[] getSentences() {
        return sentences;
    }
}
