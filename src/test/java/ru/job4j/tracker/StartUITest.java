package ru.job4j.tracker;


import org.junit.Test;
import ru.job4j.tracker.actions.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final UserAction[] actions = {
            new CreateAction(), new FindAllAction(), new EditItemAction(),
            new DeleteItemsAction(), new FindItemByIdAction(), new FindItemByNameAction(),
            new ExitAction()
    };

    @Test
    public void whenAddItem() {
        String[] answers = {"0", "Fix PC", "6"};
        Tracker tracker = new Tracker();
        new StartUI().init(new StubInput(answers), tracker, this.actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"2",
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item", "6"
        };
        new StartUI().init(new StubInput(answers), tracker, this.actions);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"3",
                String.valueOf(item.getId()), "6"};
        new StartUI().init(new StubInput(answers), tracker, this.actions);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
}