package shoppingList.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingList.service.Service;

import java.util.Scanner;

@Component
public class DeleteProductAction implements Action {
    private final Service service;
    @Autowired
    public DeleteProductAction(Service service){
        this.service = service;
    }
    @Override
    public void execute(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter product id to change it: ");
        Long id = scanner1.nextLong();
        service.deleteProductById(id);
    }

    @Override
    public String toString(){
        return "Delete product";
    }
}
