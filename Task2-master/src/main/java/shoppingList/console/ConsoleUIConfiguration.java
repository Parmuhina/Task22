package shoppingList.console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
 class ConsoleUIConfiguration {
    private final Action createProductAction;
    private final Action findProductIdAction;
    private final Action changeProductAction;
    private final Action deleteProductAction;
    private final Action exitAction;
@Autowired
    public ConsoleUIConfiguration (Action createProductAction,
                                   Action findProductIdAction,
                                   Action changeProductAction,
                                   Action deleteProductAction,
                                   Action exitAction){

        this.createProductAction = createProductAction;
        this.findProductIdAction = findProductIdAction;
        this.changeProductAction = changeProductAction;
        this.deleteProductAction = deleteProductAction;
        this.exitAction= exitAction;
    }

    @Bean
    ConsoleUI consoleUI(){
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductIdAction);
        actions.add(changeProductAction);
        actions.add(deleteProductAction);
        actions.add(exitAction);
        return new ConsoleUI(actions);
    }
}
