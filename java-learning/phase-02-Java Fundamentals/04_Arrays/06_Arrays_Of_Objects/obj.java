public class obj {
    public static void main(String[] args) {
        
        class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    
}
Student[] students = new Student[3];
    students[0] = new Student("Rahul", 85);
students[1] = new Student("Priya", 92);
students[2] = new Student("Amit", 78);

System.out.println(students[0].name);
System.out.println(students[0].marks);
    }
}
