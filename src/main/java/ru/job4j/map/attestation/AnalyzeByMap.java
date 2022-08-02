package ru.job4j.map.attestation;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double result = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.getSubjects();
            double score = sumScores(subjects);
            result += score / subjects.size();
        }
        result = result / pupils.size();
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.getSubjects();
            double scores = sumScores(subjects) / subjects.size();
            labels.add(new Label(pupil.getName(), scores));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                temp.computeIfPresent(subject.getName(), (a, b) -> b + subject.getScore());
                temp.putIfAbsent(subject.getName(), subject.getScore());
            }
         }
        for (String key : temp.keySet()) {
            rsl.add(new Label(key, temp.get(key) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.getSubjects();
            double scores = sumScores(subjects);
            labels.add(new Label(pupil.getName(), scores));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                temp.computeIfPresent(subject.getName(), (a, b) -> b + subject.getScore());
                temp.putIfAbsent(subject.getName(), subject.getScore());
            }
        }
        for (String key : temp.keySet()) {
            rsl.add(new Label(key, temp.get(key)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static double sumScores(List<Subject> subjects) {
        double score = 0;
        for (Subject subject : subjects) {
            score += subject.getScore();
        }
        return score;
    }
}
