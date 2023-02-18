package ru.job4j.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemByNameActionTest {

    @Test
    void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("item");
        tracker.add(item);
        FindItemByNameAction find = new FindItemByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ====" + ln + item + ln);
    }

    @Test
    void whenNotFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "item";
        FindItemByNameAction find = new FindItemByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===="
                + ln + "Заявки с именем: " + name + " не найдены." + ln);
    }
}