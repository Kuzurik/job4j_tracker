package ru.job4j.map.attestation;

import java.util.Objects;

public class Label implements Comparable<Label> {

    private final String name;
    private final double score;

    public Label(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Label label = (Label) o;
        return Double.compare(label.score, score) == 0 && name.equals(label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
