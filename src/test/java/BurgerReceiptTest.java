import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    public static final String BUN_NAME = "Тестовая булочка";
    public static final float BUN_PRICE = 150f;
    public static final String SAUCE = "Тысяча островов";
    public static final float SAUCE_PRICE = 100f;

    @Before
    public void createObjectsAndMocks() {
        burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(SAUCE_PRICE);
    }

    @Test
    public void getReceiptTest() {
        Assert.assertEquals(getExpectedReceipt(), burger.getReceipt());
    }

    private String getExpectedReceipt() {
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : burger.ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", (2 * BUN_PRICE) + SAUCE_PRICE));
        return expectedReceipt.toString();
    }
}
