
// Клас, який представляє слово
class Word {
    private Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public Letter[] getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder wordString = new StringBuilder();
        for (Letter letter : letters) {
            wordString.append(letter.getValue());
        }
        return wordString.toString();
    }
}