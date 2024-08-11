package baitapcolection.bai6;

import java.util.Objects;

public class ExamResult {
    private String subject;
    private double score;

    public ExamResult() {
    }

    public ExamResult(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamResult that = (ExamResult) o;
        return Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(subject);
    }
}
