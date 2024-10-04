package lab2.prob2.prob2C;

public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name, String grade) {
        this.name = name;
        gradeReport = new GradeReport(grade, this);
    }

    public String getName() {
        return name;
    }

    public GradeReport getGradeReport() {
        return gradeReport;
    }
}
