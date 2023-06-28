package Flagger;

import com.example.eurotier.Flagger.Flagger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

public class FlaggerTest {

    @Test
    public void createFlagSetTest() {

        //TODO: design these tests

    }

    @Test
    public void createFlagSetNotExistsTest() {

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
        Flagger flagger = new Flagger();
        flagger.getFlagSet().put("NLD", "FlagNLD.png");

        String key = "NLD";
        boolean result = flagger.hasKey(key);

        assertTrue(result);
    }

    @Test
    public void hasKeyNotExistsTest() {
        Flagger flagger = new Flagger();

        String key = "dasnll";
        boolean result = flagger.hasKey(key);

        assertFalse(result);
    }

    @Test
    public void getKeySetTest() {
        Flagger flagger = new Flagger();
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
