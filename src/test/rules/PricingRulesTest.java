package test.rules;
import com.datarock.rules.PricingRules;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PricingRulesTest {

    PricingRules pr = new PricingRules();

    @Test
    public void should3for2AppleTV() {
        assertTrue(249.0 == pr.getTotal(0, 0, 3, 1));
    }

    @Test
    public void shouldMoreThan4SalePriceForIpad() {
        assertTrue(2718.95 == pr.getTotal(5, 0, 2, 0));
    }

    @Test
    public void should1Mac1FreeVGA() {
        assertTrue(1949.98 == pr.getTotal(1, 1, 0, 1));
    }


}
