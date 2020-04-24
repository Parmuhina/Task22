package shoppingList.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.service.Service;

import java.util.Scanner;

@Component
public class FindProductIdAction implements Action {
    private final Service service;

    @Autowired
    public FindProductIdAction(Service service) {
        this.service = service;
    }
    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = service.findProductById(id);
        System.out.println(product);
    }
    @Override
    public String toString(){
        return "Find product by Id";
    }
}
