package ru.job4j.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EditItemActionTest {

    @Test
    void whenReplace() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItemAction rep = new EditItemAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===="
                + ln + "Заявка изменена успешно." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenNotReplace() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        EditItemAction rep = new EditItemAction(out);

        Input input = mock(Input.class);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===="
                + ln + "Ошибка замены заявки." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Replaced item");
    }
}