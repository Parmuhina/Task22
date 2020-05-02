package shoppingList.console;

import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.service.ProductService;
import shoppingList.service.validation.ProductValidationException;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CreateProductAction implements Action {
    private final ProductService service;
    final int minLength=3;
    final int maxLength=32;
    final int minPricePercent=0;
    final int min=1;
    final int max=2;

    public CreateProductAction(ProductService service){
        this.service = service;
    }

    @Override
    public  void execute () {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        product.setName(name);

        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        product.setPrice(price);

        System.out.println("If you want to enter category, press 1, if you don`t want to enter category, press 2.");
        Integer userInput1 = Integer.valueOf(scanner.nextLine());
        if (userInput1 == min) {
            System.out.println("Enter product category: ");
            String category = scanner.nextLine();
            product.setCategory(category);
        }

        while (userInput1 != min && userInput1 != max) {
            System.out.println("You entered incorrect value. " +
                    "If you want to enter category, press 1, if you don`t want to enter category, press 2.");
            userInput1 = Integer.valueOf(scanner.nextLine());
            if (userInput1 == min) {
                System.out.println("Enter product category: ");
                String category = scanner.nextLine();
                product.setCategory(category);
            }
        }
        System.out.println("Enter product percents: ");
        BigDecimal percent = new BigDecimal(scanner.nextLine());
        product.setPercent(percent);

        try {
            Product product1 = service.createProduct(product);
            System.out.println("Created product: " + product1);
        } catch (ProductValidationException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String toString(){
        return "Create Product";
    }
}
