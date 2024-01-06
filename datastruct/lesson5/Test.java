package lesson5;

public class Test {
    public static void main(String[] args) {
        Class classStudent = new Class(1, "Cau Truc Du Lieu");
        classStudent.createData();
        //Test GetTop
        System.out.println("Gettop method:");
        System.out.println(classStudent.getTopStudent());
        //Test Getbottom
        System.out.println("Getbottom method:");
        System.out.println(classStudent.getBottomStudent());
        //Get Average by name
        System.out.println("Get Average By Name method: ");
        System.out.println(classStudent.getAverageMarkByName("Nguyen Van c"));
        //Get Average Of the Class
        System.out.println("Get Average Of Class");
        System.out.println(classStudent.getAverageMarkOfClass());
        //Remove All Student has average mark less than average mark of class
        System.out.println("Remove Student");
        classStudent.removeAllStudentHasAverageMarkLessClass();
        System.out.println(classStudent);
    }
}
