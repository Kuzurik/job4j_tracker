package ru.job4j.tracker;


import org.junit.Test;
import ru.job4j.tracker.actions.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"0", "Fix PC", "1"};
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUI().init(new StubInput(answers), tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"0",
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item", "1"
        };
        UserAction[] actions = {new EditItemAction(), new ExitAction()};
        new StartUI().init(new StubInput(answers), tracker, actions);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"0",
                String.valueOf(item.getId()), "1"};
        UserAction[] actions = {new DeleteItemsAction(), new ExitAction()};
        new StartUI().init(new StubInput(answers), tracker, actions);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
}