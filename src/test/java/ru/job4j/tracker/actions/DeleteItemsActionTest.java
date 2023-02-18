package ru.job4j.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteItemsActionTest {

    @Test
    void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        DeleteItemsAction del = new  DeleteItemsAction(out);
        FindAllAction find = new FindAllAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ===="
                + ln + "Заявка удалена успешно." + ln);
        assertThat(tracker.findAll().size()).isEqualTo(0);
    }

    @Test
    void whenNotDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        DeleteItemsAction del = new  DeleteItemsAction(out);
        FindAllAction find = new FindAllAction(out);

        Input input = mock(Input.class);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ===="
                + ln + "Ошибка удаления заявки." + ln);
        assertThat(tracker.findAll().size()).isEqualTo(1);
    }
}