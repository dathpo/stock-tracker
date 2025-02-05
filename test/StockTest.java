import model.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quote.Quote;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void testQuantity() {
        Stock t1 = new Stock("GOOGL", 1);
        t1.setQuantity(100);
        assertTrue(t1.getQuantity() == 100);
    }

    @Test
    public void testGetPrice() {
        Stock t1 = new Stock("MSFT", 10);
        Quote q = new Quote(false);
        double price = 0;
        try {
            q.setValues("MSFT");
            price = q.getLatest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(price == t1.getPrice());
    }

    @Test
    public void tesRefreshPrice() {
        Stock t1 = new Stock("MSFT", 10);
        Quote q = new Quote(false);
        double price = 0;
        try {
            q.setValues("MSFT");
            t1.refreshPrice();
            price = q.getLatest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(price == t1.getPrice());
    }
}
