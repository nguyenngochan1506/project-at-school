package lesson5;

import java.util.LinkedList;

class Class {
    private  int id;
    private String name;
    private LinkedList<Student> sortedList = new LinkedList<>();
    
    public Class(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void addStudent(Student s){
        if(sortedList.isEmpty()){
            sortedList.add(s);
        }else{
            if(sortedList.getFirst().getAverageMark() <= s.getAverageMark()){
                sortedList.addFirst(s);
            }else if(s.getAverageMark() <= sortedList.getLast().getAverageMark()){
                sortedList.addLast(s);
            }else{
                sortedList.add(s);
            }
        }
    }
    public Student getTopStudent(){
        return sortedList.getFirst();
    }
    public Student getBottomStudent(){
        return sortedList.getLast();
    }
    public double getAverageMarkByName(String name){
        for(Student student: sortedList){
            if(student.getFullName().equalsIgnoreCase(name)){
                return student.getAverageMark();
            }
        }
        return -1;
    }

    public double getAverageMarkOfClass(){
        double totalAverage = sortedList.stream().mapToDouble(Student::getAverageMark).sum();
        return totalAverage/sortedList.size();
    }

    public void removeAllStudentHasAverageMarkLessClass(){
        double averageOfClass = this.getAverageMarkOfClass();
        sortedList.removeIf(student -> student.getAverageMark() < averageOfClass);
    }

    public void createData(){
        Student s1 =new Student (1, "Nguyen Van A", 6.3);
        Student s2 =new Student (2, "Nguyen Van B", 7);
        Student s3 =new Student (3, "Nguyen Van C", 3.3);
        Student s4 =new Student (4, "Nguyen Van D", 2);
        Student s5 =new Student (5, "Nguyen Van E", 9.3);

        Student[] arr = {s1,s2,s3,s4,s5};
        for (int i = 0; i < arr.length; i++) {
            this.addStudent(arr[i]);
        }
    }

    @Override
    public String toString() {
        return "Class{" +
                "\n id=" + id +
                "\n name='" + name + '\'' +
                "\n Student List=" + sortedList +
                "\n}";
    }
}