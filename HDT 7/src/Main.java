import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePathDictionary = "diccionario.txt";
        String filePathTxt = "texto.txt";
        
        ArrayList<ArrayList<String>> dictionaryPrevious = dictionaryReader(filePathDictionary);

        ArrayList<ArrayList<String>> text = txtReader(filePathTxt);

        BinarySearchTree<String, ArrayList<String>> englishTree = new BinarySearchTree<String, ArrayList<String>>(new StringComparator<String>());
        BinarySearchTree<String, ArrayList<String>> spanishTree = new BinarySearchTree<String, ArrayList<String>>(new StringComparator<String>());
        BinarySearchTree<String, ArrayList<String>> frenchTree = new BinarySearchTree<String, ArrayList<String>>(new StringComparator<String>());

        insertInTree(englishTree, dictionaryPrevious, 0);
        insertInTree(spanishTree, dictionaryPrevious, 1);
        insertInTree(frenchTree, dictionaryPrevious, 2);

        System.out.println("");
        System.out.println("Árbol en inglés:");
        englishTree.InOrderWalk(new IWalk<ArrayList<String>>() {
            @Override
            public void doWalk(ArrayList<String> value) {
                System.out.print(value + " ");
            }
        });

        System.out.println("\nÁrbol en español:");
        spanishTree.InOrderWalk(new IWalk<ArrayList<String>>() {
            @Override
            public void doWalk(ArrayList<String> value) {
                System.out.print(value + " ");
            }
        });

        System.out.println("\nÁrbol en francés:");
        frenchTree.InOrderWalk(new IWalk<ArrayList<String>>() {
            @Override
            public void doWalk(ArrayList<String> value) {
                System.out.print(value + " ");
            }
        });
        System.out.println("");
        System.out.println("");
        
        printMenu();
        int option = 0;
        try {
            option = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida");
        }

        String translatedText = "";

        switch (option) {
            case 1: // Traducir a inglés
                translatedText = translateText(text, spanishTree, frenchTree);
                System.out.println(translatedText);
                break;
            case 2: // Traducir a español
                translatedText = translateText(text, englishTree, frenchTree);
                System.out.println(translatedText);
                break;
            case 3: // Traducir a francés
                translatedText = translateText(text, englishTree, spanishTree);
                System.out.println(translatedText);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static String translateText(ArrayList<ArrayList<String>> text, BinarySearchTree<String, ArrayList<String>> tree1, BinarySearchTree<String, ArrayList<String>> tree2) {
        String translatedText = "";
        for (ArrayList<String> line : text) {
            for (String word : line) {
                ArrayList<String> translation1 = tree1.find(word.toLowerCase());
                ArrayList<String> translation2 = tree2.find(word.toLowerCase());
                if (translation1 != null) {
                    translatedText += translation1.get(0) + " ";
                } else if (translation2 != null) {
                    translatedText += translation2.get(1) + " ";
                } else {
                    translatedText += "*" + word + "* ";
                }
            }
            translatedText += "\n";
        }
        return translatedText;
    }

    public static void insertInTree(BinarySearchTree<String, ArrayList<String>> tree, ArrayList<ArrayList<String>> dictionaryPrevious, int type) {
        for (int i = 0; i < dictionaryPrevious.size(); i++) {
            ArrayList<String> arrayListTree = new ArrayList<String>();
            String key = "";
            for (String element : dictionaryPrevious.get(i)) {
                switch (type) {
                    case 0:
                        if (dictionaryPrevious.get(i).indexOf(element.toLowerCase()) == 0) {
                            key = element.toLowerCase();
                        } else {
                            arrayListTree.add(element.toLowerCase());
                            continue;
                        }
                        break;
                    case 1:
                        if (dictionaryPrevious.get(i).indexOf(element.toLowerCase()) == 1) {
                            key = element.toLowerCase();
                        } else {
                            arrayListTree.add(element.toLowerCase());
                            continue;
                        }
                        break;
                    case 2:
                        if (dictionaryPrevious.get(i).indexOf(element.toLowerCase()) == 2) {
                            key = element.toLowerCase();
                        } else {
                            arrayListTree.add(element.toLowerCase());
                            continue;
                        }
                        break;
                    default:
                        key = element.toLowerCase();
                }
            }

            if (key != "") {
                tree.insert(key, arrayListTree);
            }
        }
    }

    public static ArrayList<ArrayList<String>> dictionaryReader(String filePath) {
        ArrayList<ArrayList<String>> linesArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linesList = line.split(",");
                ArrayList<String> lines = new ArrayList<>();
                for (int i = 0; i < linesList.length; i++) {
                    lines.add(linesList[i]);
                }
                linesArrayList.add(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return linesArrayList;
    }
    
    public static ArrayList<ArrayList<String>> txtReader(String filePath) {
        ArrayList<ArrayList<String>> linesArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linesList = line.split(" ");
                ArrayList<String> lines = new ArrayList<>();
                for (int i = 0; i < linesList.length; i++) {
                    lines.add(linesList[i]);
                }
                linesArrayList.add(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesArrayList;
    }

    public static void printMenu() {
        System.out.println("Selecciona el idioma de salida:");
        System.out.println("1. Inglés");
        System.out.println("2. Español");
        System.out.println("3. Francés");
    }
}
