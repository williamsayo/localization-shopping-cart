import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Locale locale;

    public static void main(String[] args) {
        selectLanguage();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle", locale);
        System.out.println(resourceBundle.getString("prompt.welcomeMessage"));
        System.out.print("> ");
        int cartSize = scanner.nextInt();

        ShoppingCart shoppingCart = new ShoppingCart();

        for (int cartIndex = 1; cartIndex <= cartSize; cartIndex++) {
            System.out.println(resourceBundle.getString("prompt.itemQuantity"));
            System.out.printf("item %s > ",cartIndex);
            int itemQuantity = scanner.nextInt();
            System.out.println(resourceBundle.getString("prompt.itemPrice"));
            System.out.printf("item %s > ",cartIndex);
            double itemPrice = scanner.nextDouble();

            double itemTotal = shoppingCart.calculateItemCost(itemQuantity, itemPrice);
            shoppingCart.addToCart(itemTotal);
        }

        double cartTotal = shoppingCart.getCartTotalPrice();

        System.out.println("-------------------------------");
        System.out.println(resourceBundle.getString("prompt.total") +": " + NumberFormat.getCurrencyInstance(locale).format(cartTotal));
    }

    private static void selectLanguage() {
        System.out.println("Select a language: ");
        System.out.printf("1. %s 2. %s 3. %s\n", "English", "Finish", "Swedish");
        System.out.print("> ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
        }
    }

}
