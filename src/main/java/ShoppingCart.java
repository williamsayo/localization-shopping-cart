public class ShoppingCart {
    double cartTotalPrice = 0.0;

    public double calculateItemCost(int quantity,double price){
        return quantity*price;
    }

    public void addToCart(double total){
        cartTotalPrice += total;
    }

    public double getCartTotalPrice(){
        return cartTotalPrice;
    }
}
