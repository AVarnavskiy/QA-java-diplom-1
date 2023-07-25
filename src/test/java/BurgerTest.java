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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Ingredient ingredientFirst;
    @Mock
    Ingredient ingredientSecond;
    @Mock
    Bun bun;
    public static final float BUN_PRICE = 150f;
    public static final float INGREDIENT_FIRST_PRICE = 100f;
    public static final float INGREDIENT_SECOND_PRICE = 50f;
    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientFirst);
        Assert.assertEquals(ingredientFirst, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientFirst, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        createTestDataForGetPriceTest();
        float expectedPrice = (2 * BUN_PRICE) + INGREDIENT_FIRST_PRICE + INGREDIENT_SECOND_PRICE;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    private void createTestDataForGetPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(INGREDIENT_FIRST_PRICE);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(INGREDIENT_SECOND_PRICE);
    }

}
