import java.util.ArrayList;
import java.util.List;

// Клас, який представляє речення
class Sentence {
    private Object[] elements;

    public Sentence(Object... elements) {
        this.elements = elements;
    }

    public Word[] getWords() {
        List<Word> result = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                result.add((Word) element);
            }
        }
        return result.toArray(new Word[0]);
    }

    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Object element : elements) {
            if (element instanceof Word) {
                for (Letter letter : ((Word) element).getLetters()) {
                    result.append(letter.getValue());
                }
            } else if (element instanceof Punctuation) {
                result.append(((Punctuation) element).getValue());
            }
        }
        return result.toString().trim();
    }
}