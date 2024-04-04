import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePathDictionary = "diccionario.txt";
        String filePathTxt = "texto.txt";
        
        ArrayList<ArrayList<String>> dictionary = dictionaryReader(filePathDictionary);
        for (ArrayList<String> line : dictionary) {
            System.out.println(line);
        }

        ArrayList<ArrayList<String>> text = txtReader(filePathTxt);
        for (ArrayList<String> line : text) {
            System.out.println(line);
        }

        printMenu();
        int option = 0;
        try {
            option = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida");
        }

        switch (option) {
            case 1:
                System.out.println("Hello World");
                break;
            case 2:
                System.out.println("Hola Mundo");
                break;
            case 3:
                System.out.println("Bonjour le monde");
                break;
            default:
                System.out.println("Opción no válida");
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
