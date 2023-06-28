package Pushers;

import com.example.eurotier.Pushers.MockPusher;
import com.example.eurotier.TierList.TierList;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockPusherTest {

    @Test
    public void mockPushTest() {

        String label = "mock";

        TierList tierList = new TierList(label);
        tierList.getEventManager().addListener(new MockPusher(), label);

        String tag1 = "NLD";
        String tag2 = "ARM";
        String tag3 = "DEU";
        String tag4 = "BEL";

        tierList.addItem(tierList.getRow("S"), tag1);
        tierList.addItem(tierList.getRow("S"), tag2);
        tierList.addItem(tierList.getRow("A"), tag3);
        tierList.addItem(tierList.getRow("B"), tag4);

        String ent = System.lineSeparator();
        String expected = String.format("%s%sS: %s %s %sA: %s %sB: %s %sC: %sD: %sE: %sF: %s", label, ent, tag1, tag2, ent, tag3, ent, tag4, ent, ent, ent, ent, ent);

        PrintStream original = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        tierList.commit(label);
        String actual = baos.toString();

        assertEquals(expected, actual);

        System.setOut(original);

    }


}
