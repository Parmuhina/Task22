package shoppingList.console;

import org.springframework.stereotype.Component;
import shoppingList.service.ProductService;
import java.util.Scanner;

@Component
public class DeleteProductAction implements Action {
    private final ProductService service;

     DeleteProductAction(ProductService service){
        this.service = service;
    }
    @Override
    public void execute(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter product id to delete it: ");
        Long id = scanner1.nextLong();
        service.deleteProductById(id);
    }

    @Override
    public String toString(){
        return "Delete product";
    }
}
