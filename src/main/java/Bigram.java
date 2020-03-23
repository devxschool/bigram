import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Bigram {


    public Map<String, Integer> parse(File file) {


        Scanner input = null;
        Map<String,Integer> freq = new LinkedHashMap<String,Integer>();
        try {
            input = new Scanner(file);
            // s.useDelimiter("\\W"); // use with java.util.Scanner to skip all non-letters
            String content = "";
            while (input.hasNextLine()) {
                content+= input.nextLine();
            }
            String array[] = content.split(" ");
            // iterate through the words, maintaining a count in the Map
            for(int j=0;j<array.length-1;j++){
                String word1 = array[j].toLowerCase().replaceAll("[^a-zA-Z]+","");
                String word2 = array[j+1].toLowerCase().replaceAll("[^a-zA-Z]+","");
                String word = word1+" "+word2;
                if (freq.containsKey(word)) {
                    // only need to bump up the count
                    Integer i = freq.get(word);
                    freq.put(word, i + 1);
                } else {
                    // insert a new binding
                    freq.put(word, 1);
                }
            }
            // iterate through the key-value bindings, printing them out
            for (Map.Entry<String, Integer> kv : freq.entrySet()) {
                System.out.printf("\"%s\" %d\n", kv.getKey(), kv.getValue().intValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return freq;
    }
}
