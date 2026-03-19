import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    ShoppingCart shoppingCart = new ShoppingCart();
    @Test
    void testCalculateItemCost() {
        assertEquals(60.0,shoppingCart.calculateItemCost(3,20));
    }

    @Test
    void testAddToCart() {
        shoppingCart.addToCart(60);
        assertEquals(60.0,shoppingCart.getCartTotalPrice());
    }

}