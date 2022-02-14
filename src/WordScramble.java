import java.lang.reflect.Array;
import java.util.ArrayList;

public class WordScramble {
    /**
     * Scrambles a given word.
     *
     * @param word the word to be scrambled
     * @return the scrambled word (possibly equal to word)
     * <p>
     * Precondition: word is either an empty string or contains only uppercase letters.
     * Postcondition: the string returned was created from word as follows:
     * - the word was scrambled, beginning at the first letter and continuing from left to right
     * - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     * - letters were swapped at most once
     */
    public static String scrambleWord(String word) {
        /* to be implemented in part (a) */
        String newWord = "";
        if (word.equals("") || word.equals("A")) {
            return word;
        } else {
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.charAt(i) == 'A') {
                    if (word.charAt(i + 1) != 'A') {
                        newWord += word.charAt(i + 1);
                        newWord += word.charAt(i);
                        i++;
                    } else {
                        newWord += word.charAt(i);
                    }
                } else {
                    newWord += word.charAt(i);

                }
            }
        }
        if (newWord.length() < word.length()) {
            newWord += word.substring(newWord.length());
        }

        return newWord;
    }

    /**
     * Modifies wordList by replacing each word with its scrambled
     * version, removing any words that are unchanged as a result of scrambling.
     *
     * @param wordList the list of words
     *                 <p>
     *                 Precondition: wordList contains only non-null objects
     *                 Postcondition:
     *                 - all words unchanged by scrambling have been removed from wordList
     *                 - each of the remaining words has been replaced by its scrambled version
     *                 - the relative ordering of the entries in wordList is the same as it was
     *                 before the method was called
     */
    public static void scrambleOrRemove(ArrayList<String> wordList) {
        /* to be implemented in part (b) */
        for (int i = 0; i < wordList.size(); i++)
            if (scrambleWord(wordList.get(i)).equals(wordList.get(i))) {
                wordList.remove(i);
                i--;
            }
            else{
                wordList.set(i, scrambleWord(wordList.get(i)));
            }

    }

}