package service.validation;

import console.ConsoleUI;

public class ProductValidationException extends RuntimeException {

    public ProductValidationException(String message) {
        super(message);
    }

    public static class ShoppingList {

            public static void main(String[] args) {
                ConsoleUI consoleUI = new ConsoleUI();
                consoleUI.execute();
            }

    }
}
