package Tracker;

import com.example.eurotier.TierList.TierList;
import com.example.eurotier.Tracker.Tracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackerTest {

    @Test
    public void constructorTest() {

        Tracker tracker = new Tracker();

        int expected = 2023 - 1959 + 1;
        int actual = tracker.getLists().size();

        assertEquals(expected, actual);

    }

    @Test
    public void findListTest() {
        Tracker tracker = new Tracker();

        String expected = "2023";
        String actual = tracker.findList(expected).getLabel();

        assertEquals(expected, actual);
    }

    @Test
    public void clearListTest() {
        Tracker tracker = new Tracker();

        TierList tierList = tracker.getLists().get(0);
        String label = tierList.getLabel();
        tierList.addItem(tierList.getRow("A"), "NLD");

        assertFalse(tierList.getRow("A").getCountries().isEmpty());

        tracker.clearList(label);

        assertTrue(tierList.getRow("A").getCountries().isEmpty());
    }

}
