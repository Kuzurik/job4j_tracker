package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAscSort() {
        List<String> input = Arrays.asList(
                "K1",
                "K2/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K2/SK1",
                "K1/SK2",
                "K2/SK1/SSK2",
                "K2"
        );
        List<String> expect = Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenDescSort() {
        List<String> input = Arrays.asList(
                "K2/SK1",
                "K1/SK1/SSK1",
                "K1/SK2",
                "K1/SK1",
                "K2/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK2",
                "K1"
        );
        List<String> expect = Arrays.asList(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2"
        );
        input.sort(new DepDescComp());
        assertThat(input, is(expect));
    }

}