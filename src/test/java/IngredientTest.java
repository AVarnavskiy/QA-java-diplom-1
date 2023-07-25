import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient;
    public static final IngredientType INGREDIENT_TYPE = IngredientType.SAUCE;
    public static final String INGREDIENT_NAME = "Котлета";
    public static final float INGREDIENT_PRICE = 200f;

    @Before
    public void createIngredientObject() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(INGREDIENT_PRICE, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(INGREDIENT_TYPE, ingredient.getType());
    }
}
