package test;
import com.datarock.Main;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;


public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintoutSuccess() {
        String input = String.format("pay", System.lineSeparator());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(null);
        String output = String.format("Please scan: "+ System.lineSeparator()+ "Total: $0.00" + System.lineSeparator() + "Thank you!" + System.lineSeparator());
        assertEquals(output, outContent.toString());
    }

    @Test
    public void shouldPrintoutWrongCode() {
        String input = String.format("eee", System.lineSeparator());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(null);
        String output = String.format("Please scan: "+ System.lineSeparator()+ "wrong code"+ System.lineSeparator());
        assertEquals(output, outContent.toString());
    }

}
