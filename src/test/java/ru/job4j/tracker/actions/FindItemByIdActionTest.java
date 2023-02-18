package ru.job4j.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemByIdActionTest {

    @Test
    void whenFindId() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemByIdAction find = new FindItemByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ====" + ln + item + ln);
    }

    @Test
    void whenNotFindId() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemByIdAction find = new FindItemByIdAction(out);

        Input input = mock(Input.class);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===="
                + ln + "Заявка с введенным id: 0 не найдена." + ln);
    }
}