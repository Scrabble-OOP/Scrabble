import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class DictionaryReader {

    private TrieTree diccionario;


    public DictionaryReader() {

        this.diccionario = readDictionary();

    }

    public TrieTree readDictionary() {

        TrieTree diccionario = new TrieTree();
        String line = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"))) {

            while ((line = reader.readLine()) != null) {
                diccionario.add(line);
            }

            return diccionario;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public TrieTree getDiccionario() {
        return diccionario;
    }

}


