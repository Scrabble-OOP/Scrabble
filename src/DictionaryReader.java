import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class DictionaryReader {

    private TrieTree diccionario;


    public DictionaryReader() {

        readDictionary();

    }

    public void readDictionary() {

        TrieTree diccionario = new TrieTree();
        String line = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"))) {

            while ((line = reader.readLine()) != null) {
                diccionario.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public TrieTree getDiccionario() {
        return diccionario;
    }

}


