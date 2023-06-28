package TierList;

import com.example.eurotier.TierList.Row;
import com.example.eurotier.TierList.TierList;
import com.example.eurotier.TierList.TierReturnType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TierListTest {

    @Test
    public void createRowsTest() {

        TierList tierList = new TierList("test"); //constructor calls createRows
        String expected = "SABCDEF";

        assertEquals(expected.length(), tierList.getRows().size());
        String actual = "";

        for (Row row:tierList.getRows()) {
            actual += row.getLabel();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void createRowsExistsTest() {

        TierList tierList = new TierList("test");

        TierReturnType result = tierList.createRows();
        assertEquals(TierReturnType.EXISTS, result);

        String expected = "SABCDEF";

        assertEquals(expected.length(), tierList.getRows().size());
        String actual = "";

        for (Row row:tierList.getRows()) {
            actual += row.getLabel();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void createRowsIsOrderedTest() { //uses addItem
        TierList tierList = new TierList("test");

        String expected = "NLDEFREN";
        Row firstRow = tierList.getRow("S");
        Row secondRow = tierList.getRow("A");

        tierList.addItem(firstRow, "NL");
        tierList.addItem(firstRow, "DE");
        tierList.addItem(firstRow, "FR");
        tierList.addItem(secondRow, "EN");

        String actual = "";
        for (Row row : tierList.getRows()) {
            for (String country : row.getCountries()) {
                actual += country;
            }
        }

        assertEquals(expected, actual);
    }

    @Test
    public void appendRowIsOrderedTest() { //uses addItem + removeItem
        TierList tierList = new TierList("test");

        String expected = "DEFRNLEN";
        Row firstRow = tierList.getRow("S");
        Row secondRow = tierList.getRow("A");

        tierList.addItem(firstRow, "NL");
        tierList.addItem(firstRow, "DE");
        tierList.addItem(firstRow, "FR");
        tierList.addItem(secondRow, "EN");
        tierList.removeItem(firstRow, "NL");
        tierList.addItem(firstRow, "NL");

        String actual = "";
        for (Row row : tierList.getRows()) {
            for (String country : row.getCountries()) {
                actual += country;
            }
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getTierReturnTypeTest() {
        TierList tierList = new TierList("test");

        assertEquals(TierReturnType.SUCCESS, tierList.getTierReturnType(true));
        assertEquals(TierReturnType.ERROR, tierList.getTierReturnType(false));

    }

    @Test
    public void getRowTest() {
        TierList tierList = new TierList("test");

        Row expected = tierList.getRows().get(0);
        Row actual = tierList.getRow("S");

        assertEquals(expected, actual);
    }

    @Test
    public void addRowTest() {
        TierList tierList = new TierList("test", true);

        Row row = new Row("test");

        TierReturnType result = tierList.addRow(row);
        assertEquals(TierReturnType.SUCCESS, result);

        result = tierList.addRow(row);
        assertEquals(TierReturnType.EXISTS, result);

        assertEquals(tierList.getRows().get(0), row);
    }

    @Test
    public void addItemNotExistsTest() {
        TierList tierList = new TierList("test");

        String expected = "NL";

        TierReturnType result = tierList.addItem(tierList.getRow("S"), expected);
        assertEquals(TierReturnType.SUCCESS, result);

        String actual = tierList.getRows().get(0).getCountries().get(0);

        assertEquals(actual, expected);
    }

    @Test
    public void addItemExistsTest() {
        TierList tierList = new TierList("test");

        String country = "NL";

        TierReturnType result = tierList.addItem(tierList.getRow("S"), country);
        assertEquals(TierReturnType.SUCCESS, result);

        result = tierList.addItem(tierList.getRow("S"), country);
        assertEquals(TierReturnType.EXISTS, result);

        assertEquals(1, tierList.getRows().get(0).getCountries().size());
    }

    @Test
    public void removeItemExistsTest() {
        TierList tierList = new TierList("test");

        String country = "NL";

        tierList.getRows().get(0).getCountries().add(0, country);

        TierReturnType result = tierList.removeItem(tierList.getRow("S"), country);
        assertEquals(TierReturnType.SUCCESS, result);

        assertEquals(0, tierList.getRows().get(0).getCountries().size());
    }

    @Test
    public void removeItemNotExistsTest() {
        TierList tierList = new TierList("test");

        String country = "NL";

        TierReturnType result = tierList.removeItem(tierList.getRow("S"), country);
        assertEquals(TierReturnType.NOTFOUND, result);

        assertEquals(0, tierList.getRows().get(0).getCountries().size());
    }

    @Test
    public void changeNameExistsTest() {
        TierList tierList = new TierList("test");

        Row row = new Row("S");
        String expected = "test";

        TierReturnType result = tierList.changeName(row, expected);
        assertEquals(TierReturnType.SUCCESS, result);

        String actual = tierList.getRows().get(0).getLabel();
        assertEquals(expected, actual);
    }

    @Test
    public void changeNameNotExistsTest() {
        TierList tierList = new TierList("test");

        Row row = new Row("test");

        TierReturnType result = tierList.changeName(row, "test");
        assertEquals(TierReturnType.NOTFOUND, result);

        assertEquals(7, tierList.getRows().size());
    }

}
