import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
V = 17
C3 = String
C17 = Знайти найбільшу кількість речень заданого тексту, в яких є однакові
слова.

1.
    Модифікувати лабораторну роботу №3 наступним чином: для літер, слів, речень,
    розділових знаків та тексту створити окремі класи.
    Слово повинно складатися з масиву літер, речення з масиву слів та розділових знаків,
    текст з масиву речень.
    Замінити послідовність табуляцій та пробілів одним пробілом.

2.
    Створити клас, який складається з виконавчого методу, що виконує описану
    дію з лабораторної роботи №3, але в якості типів використовує створені класи.
    Необхідно обробити всі виключні ситуації, що можуть виникнути під час
    виконання програмного коду.
    Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
    Код повинен відповідати стандартам JCC та бути детально задокументований.
*/

public class Main {

    public static void main(String[] args) {

        // Створюю слова з літер
        Word hello = new Word(new Letter[]{ new Letter('H'),new Letter('e'),new Letter('l'),new Letter('l'),new Letter('o') });
        Word world = new Word(new Letter[]{new Letter('w'),new Letter('o'), new Letter('r'),new Letter('l'),new Letter('d')});
        Word good = new Word(new Letter[]{new Letter('g'),new Letter('o'),new Letter('o'),new Letter('d')});
        Word day = new Word(new Letter[]{ new Letter('d'),new Letter('a'), new Letter('y')});
        Word today = new Word(new Letter[]{ new Letter('T'),new Letter('o'),  new Letter('d'), new Letter('a'), new Letter('y') });
        Word is = new Word(new Letter[]{ new Letter('i'), new Letter('s') });
        Word a = new Word(new Letter[]{ new Letter('a') });

        //Створюю розділові знаки
        Punctuation space = new Punctuation(' ');
        Punctuation dot = new Punctuation('.');
        Punctuation comma = new Punctuation(',');
        Punctuation exclamationMark = new Punctuation('!');
        Punctuation questionMark = new Punctuation('?');
        Punctuation tabulation = new Punctuation('\t');

        // Створюю речення зі слів та розділових знаків
        Sentence sentence1 = new Sentence(
                hello, space, world, tabulation, tabulation, comma, space, world, dot );
        Sentence sentence2 = new Sentence(
                today, space, is, space, a, space, space, good, space, good, space, day, exclamationMark );
        Sentence sentence3 = new Sentence( hello,space,space, space, questionMark);

        // Створюємо текст з речень
        Text text = new Text(new Sentence[]{sentence1,sentence2,sentence3});

        // Вивід речення
        System.out.println(text.getValue());
        // Вивід відформатованого речення
        System.out.println(text.getValueWithoutWhiteSpaces());
        System.out.println("Кількість речень заданого тексту, в яких є однакові слова: "
                + CounterSentencesWithSameWords(text));
    }
    //Метод, для знаходження кількість речень заданого тексту, в яких є однакова слова
    public static int CounterSentencesWithSameWords(Text text) {
        int Counter = 0;

        Sentence[] sentences = text.getSentences(); // масив речень в тексті
        for (Sentence sentence : sentences) {
            Word[] wordsInSentence = sentence.getWords();  //масив слів в речені

            int CounterWordsInString = 0;
            for(int i = 0; i < wordsInSentence.length; i++){
                for(int j =i+1; j < wordsInSentence.length; j++){
                    if(wordsInSentence[i].equals(wordsInSentence[j])) {
                        CounterWordsInString++;
                    }
                }
            }
            if(CounterWordsInString>0) Counter++;

        }
        return Counter;
    }
}
