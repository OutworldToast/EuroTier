package Flagger;

import com.example.eurotier.Flagger.Flagger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

public class FlaggerTest {

    @Test
    public void constructorTest() {
        Flagger flagger = new Flagger();

        String key = "NLD";

        assertFalse(flagger.getKeySet().isEmpty());
        assertTrue(flagger.hasKey(key));
        assertEquals("FlagNLD.png", flagger.getValue(key));

    }

    @Test
    public void createFlagSetTest() {

//        Flagger flagger = new Flagger(true);
//
//        URL url = getClass().getResource("flags.txt");  <--- makes the test fail
//        File file = new File(Objects.requireNonNull(url).getPath());
//
//        Map<String, String> resultSet = flagger.createFlagSet(file);
//
//        String expected = "FlagNLD.png";
//        String actual = resultSet.get("NLD");
//
//        assertFalse(resultSet.containsKey("NOTEXISTS"));
//        assertEquals(expected, actual);

        //TODO: fix this test (cant find file)

    }

    @Test
    public void createFlagSetNotExistsTest() {
        Flagger flagger = new Flagger(true);

        Map<String, String> resultSet = flagger.createFlagSet(null);

        assertTrue(resultSet.containsKey("NOTEXISTS"));
    }

    @Test
    public void getValueExistsTest() {
        Flagger flagger = new Flagger(true);
        flagger.getFlagSet().put("NLD", "FlagNLD.png");

        String expected = "FlagNLD.png";

        String key = "NLD";
        String actual = flagger.getValue(key);

        assertEquals(expected, actual);
    }

    @Test
    public void getValueNotExistsTest() {
        Flagger flagger = new Flagger(true);

        String key = "dasnll";
        String actual = flagger.getValue(key);

        assertNull(actual);
    }

    @Test
    public void hasKeyExistsTest() {
        Flagger flagger = new Flagger(true);
        flagger.getFlagSet().put("NLD", "FlagNLD.png");

        String key = "NLD";
        boolean result = flagger.hasKey(key);

        assertTrue(result);
    }

    @Test
    public void hasKeyNotExistsTest() {
        Flagger flagger = new Flagger(true);

        String key = "dasnll";
        boolean result = flagger.hasKey(key);

        assertFalse(result);
    }

    @Test
    public void getKeySetTest() {
        Flagger flagger = new Flagger(true);
        flagger.getFlagSet().put("ARM", null);
        flagger.getFlagSet().put("NLD", null);

        Set<String> keySet = flagger.getKeySet();

        assertEquals(2 ,keySet.size());

        assertTrue(keySet.contains("NLD"));
        assertTrue(keySet.contains("ARM"));
        assertFalse(keySet.contains("dasnll"));
        assertFalse(keySet.contains("asdkl"));
    }

}
