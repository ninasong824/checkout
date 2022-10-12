package test;
import com.datarock.Checkout;
import com.datarock.rules.PricingRules;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutTest {

    PricingRules mockPricingRules = mock(PricingRules.class);

    @Test
    public void testScanWithInputIpd() {
        String input = String.format("ipd"+ System.lineSeparator());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Checkout checkout = new Checkout(mockPricingRules);

        assertTrue(checkout.scan());
        assertTrue(1 == checkout.getIpadCounter());
    }

    @Test
    public void testScanWithInputMbp() {
        String input = String.format("mbp"+ System.lineSeparator());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Checkout checkout = new Checkout(mockPricingRules);
        checkout.scan();

        assertTrue(1 == checkout.getMacbookCounter());
    }

    @Test
    public void testScanWithInputAtv() {
        String input = String.format("atv"+ System.lineSeparator());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Checkout checkout = new Checkout(mockPricingRules);
        checkout.scan();

        assertTrue(1 == checkout.getAppleTVCounter());
    }

    @Test
    public void testScanWithInputVga() {
        String input = String.format("vga"+ System.lineSeparator());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Checkout checkout = new Checkout(mockPricingRules);
        checkout.scan();

        assertTrue(1 == checkout.getVgaCounter());
    }

    @Test
    public void testTotal() {
        Checkout checkout = new Checkout(mockPricingRules);
        when(mockPricingRules.getTotal(1, 0, 0, 0)).thenReturn(100.01);
        checkout.setIpadCounter(1);
        assertTrue(100.01 == checkout.total().doubleValue());
    }
}
