package TierList;

import com.example.eurotier.TierList.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RowTest {

    @Test
    public void addCountryTest(){
        Row row = new Row("test");
        String expected = "NL";

        assertTrue(row.addCountry(expected));

        String actual = row.getCountries().get(0);
        assertEquals(expected, actual);

    }

    @Test
    public void addCountryDoubleTest(){
        Row row = new Row("test");
        String country = "NL";

        row.addCountry(country);
        assertTrue(row.addCountry(country));

        String expected = row.getCountries().get(0);
        String actual = row.getCountries().get(1);
        assertEquals(expected, actual);

    }

    @Test
    public void removeCountryExistsTest(){
        Row row = new Row("test");
        String country = "NL";

        assertTrue(row.addCountry(country));
        assertTrue(row.removeCountry(country));
    }

    @Test
    public void removeCountryNotExistsTest(){
        Row row = new Row("test");
        String country = "NL";

        assertFalse(row.removeCountry(country));
    }

    @Test
    public void hasCountryTrueTest(){
        Row row = new Row("test");
        String country = "NL";

        boolean shouldBeTrue = row.addCountry(country);
        assertTrue(shouldBeTrue);

        assertTrue(row.hasCountry(country));
    }

    @Test
    public void hasCountryFalseTest(){
        Row row = new Row("test");
        String country = "NL";

        assertFalse(row.hasCountry(country));
    }

    @Test
    public void hasCountryLowercaseTest(){
        Row row = new Row("test");
        String countryLower = "nl";
        String countryUpper = "NL";

        boolean shouldBeTrue = row.addCountry(countryLower);
        assertTrue(shouldBeTrue);

        assertTrue(row.hasCountry(countryUpper));
    }

}
