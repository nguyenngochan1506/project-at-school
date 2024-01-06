package lesson5;

public class Student {
    private int id;
    private String fullName;
    private double averageMark;
    public Student(int id, String fullName, double averageMark){
        this.id = id;
        this.fullName = fullName;
        this.averageMark = averageMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                "- fullName='" + fullName + '\'' +
                "- averageMark=" + averageMark +
                "} \n";
    }
}
