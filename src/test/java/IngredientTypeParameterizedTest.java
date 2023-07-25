import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    String type;

    public IngredientTypeParameterizedTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[] getData() {
        return new Object[] {
                "SAUCE",
                "FILLING"
        };
    }

    @Test
    public void getTypeTest() {
        assertThat(IngredientType.valueOf(type), isA(IngredientType.class));
    }

}
