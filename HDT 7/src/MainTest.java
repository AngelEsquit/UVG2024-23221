import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;
import static org.junit.Assert.assertEquals;

public class MainTest {

    private BinarySearchTree<String, ArrayList<String>> tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<String, ArrayList<String>>(Comparator.naturalOrder());
    }

    @Test
    public void testInsertInTree() {
        ArrayList<ArrayList<String>> dictionaryPrevious = new ArrayList<>();
        ArrayList<String> englishWords = new ArrayList<>();
        englishWords.add("house");
        englishWords.add("dog");
        ArrayList<String> spanishWords = new ArrayList<>();
        spanishWords.add("casa");
        spanishWords.add("perro");
        ArrayList<String> frenchWords = new ArrayList<>();
        frenchWords.add("loger");
        frenchWords.add("chien");
        dictionaryPrevious.add(englishWords);
        dictionaryPrevious.add(spanishWords);
        dictionaryPrevious.add(frenchWords);

        Main.insertInTree(tree, dictionaryPrevious, 0);

        assertEquals(tree.find("house"), tree.find("house"));
        assertEquals(tree.find("dog"), tree.find("dog"));
    }

    @Test
    public void testTranslateText() {
        ArrayList<ArrayList<String>> text = new ArrayList<>();
        ArrayList<String> sentence1 = new ArrayList<>();
        sentence1.add("house");
        sentence1.add("casa");
        ArrayList<String> sentence2 = new ArrayList<>();
        sentence2.add("dog");
        sentence2.add("perro");
        text.add(sentence1);
        text.add(sentence2);

        ArrayList<ArrayList<String>> dictionaryPrevious = new ArrayList<>();
        ArrayList<String> englishWords = new ArrayList<>();
        englishWords.add("house");
        englishWords.add("dog");
        ArrayList<String> spanishWords = new ArrayList<>();
        spanishWords.add("casa");
        spanishWords.add("perro");
        ArrayList<String> frenchWords = new ArrayList<>();
        frenchWords.add("loger");
        frenchWords.add("chien");
        dictionaryPrevious.add(englishWords);
        dictionaryPrevious.add(spanishWords);
        dictionaryPrevious.add(frenchWords);

        Main.insertInTree(tree, dictionaryPrevious, 0);
        Main.insertInTree(tree, dictionaryPrevious, 1);
        Main.insertInTree(tree, dictionaryPrevious, 2);

        String translatedText = Main.translateText(text, tree, tree);

        assertEquals(translatedText, translatedText);
    }
}
