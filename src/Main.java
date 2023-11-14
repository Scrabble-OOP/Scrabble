


public class Main {
    public static void main(String[] args) {

        DictionaryReader reader = new DictionaryReader();
        TrieTree dictionary = reader.readDictionary();
        Game game = new Game(2, dictionary);




    }
}