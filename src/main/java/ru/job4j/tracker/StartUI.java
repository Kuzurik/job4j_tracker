package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {

        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }


    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new FindAllAction(), new EditItemAction(),
                new DeleteItemsAction(), new FindItemByIdAction(), new FindItemByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
