package shoppingList.console;

import org.springframework.stereotype.Component;

@Component
public class ExitAction implements Action {
    @Override
    public void execute (){
        System.exit(0);
    }
    @Override
    public String toString(){
        return "Exit";
    }
}
