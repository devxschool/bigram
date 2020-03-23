import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class BigramTest {


    @Test
    public void testBigram1(){

        Bigram bigram = new Bigram();

        Map<String, Integer> results = bigram.parse(new File(getClass().getClassLoader().getResource("testFile.txt").getFile()));

        Assert.assertEquals("our greatest occurrence mismatch", 1, (int)results.get("our greatest"));

        Assert.assertEquals("just pursuits. occurrence mismatch", 1, (int)results.get("just pursuits"));


    }

    @Test
    public void testBigramFile2(){
        Bigram bigram = new Bigram();

        Map<String, Integer> results = bigram.parse(new File(getClass().getClassLoader().getResource("testFile2.txt").getFile()));

        Assert.assertEquals("our greatest occurrence mismatch", 2, (int)results.get("body great"));

        Assert.assertEquals("great great. occurrence mismatch", 1, (int)results.get("great great"));

        Assert.assertEquals("great great. occurrence mismatch", 2, (int)results.get("body body"));
    }


    @Test
    public void testBigramFile2Negative(){
        Bigram bigram = new Bigram();

        Map<String, Integer> results = bigram.parse(new File(getClass().getClassLoader().getResource("testFile2.txt").getFile()));


        Assert.assertNull("NO such word exists in the file",results.get("Bodybuilder"));

    }

}
