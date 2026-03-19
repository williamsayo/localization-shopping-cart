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
        shoppingCart.addToCart(20);
        assertEquals(80.0,shoppingCart.getCartTotalPrice());
        shoppingCart.addToCart(200);
        assertEquals(280.0,shoppingCart.getCartTotalPrice());
    }

}