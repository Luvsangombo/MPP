package lab2.prob2.prob2C;

public class GradeReport {
    private String grade;
    private Student student;

    GradeReport(String grade, Student student) {
        this.grade = grade;
        this.student = student;
    }

    public String getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }
}
