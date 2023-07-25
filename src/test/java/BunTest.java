import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun;
    private static final String BUN_NAME = "Булочка для теста";
    private static final float BUN_PRICE = 134.50f;

    @Before
    public void creteObject() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(BUN_PRICE, bun.getPrice(), 0.0f);
    }
}
