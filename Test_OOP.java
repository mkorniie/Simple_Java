package OOPtest; /**
 * Created by Maria on 14/04/2018.
 */

import java.util.ArrayList;
import java.util.List;
//import java.lang.String;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class Test_OOP {

    public static void main(String[] argc){

        String text = "The Mole had been working very hard all the morning, spring- cleaning his little home. First with brooms, then with dusters; then on ladders and steps and chairs, with a brush and a pail of whitewash; till he had dust in his throat and eyes, and splashes of whitewash all over his black fur, and an aching back and weary arms. Spring was moving in the air above and in the earth below and around him, penetrating even his dark and lowly little house with its spirit of divine discontent and longing. ";

        //>>>>>>>>Разбить строку на предложения;
        //>>>>>>>>Split a String into sentences (w/o split);
        List<Sentence> text_sentences = new ArrayList();

        Character current;
        int sentence_start = 0;
        String sub;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '?' || text.charAt(i) == '!' || text.charAt(i) == '.'){
                sub = trim(text.substring(sentence_start, i));
                if (sub.length() != 0) {
                    text_sentences.add(new Sentence(sub));
                }
                sentence_start = i + 1;
            }
            else if (i == text.length() - 1){
                sub = trim(text.substring(sentence_start, i));
                if (sub.length() != 0) {
                    text_sentences.add(new Sentence(sub));
                }
            }
        }
        for (Sentence st : text_sentences)
        {
            System.out.println("OOPtest.Sentence: " + st.getMySentence());
        }

        //>>>>>>>>Разбить строку на слова и разделители;
        //>>>>>>>>Split a String into words and delimiters (w/o split);
        List<Word> words = new ArrayList();
        List<Delimiter> delimiters = new ArrayList();

        int wordStart = 0;
        boolean isWord = false;
        String delims = " ,.?!/\\'\":;()@#$%^&*_+-{}[]<>\t";
        for (int i = 0; i < text.length(); i++){
            current = text.charAt(i);
            if (current.isLetter(current) && !isWord){
                wordStart = i;
                isWord = true;
            }
            else if (delims.contains(current.toString())){
                delimiters.add(new Delimiter(text.charAt(i)));
                if (isWord){
                    isWord = false;
                    words.add(new Word((text.substring(wordStart, i))));
                }
            }
        }

        for (Word w : words)
        {
            System.out.println("Words: '" + w.getMyWord() + "'");
        }

        for (Delimiter d : delimiters)
        {
            System.out.println("Delimiters: '" + d.getMyDelimiter() + "'");
        }

        //>>>>>>>>Разбить на буквы;
        //>>>>>>>>Split a String into letters;
        List<Letter> letters = new ArrayList();
        for (int i = 0; i < text.length(); i++){
            current = text.charAt(i);
            if (current.isLetter(current)) {
                letters.add(new Letter(current));
            }
        }

        for (Letter l : letters)
        {
            System.out.println("Letters: '" + l.getMyLetter() + "'");
        }
    }
}
