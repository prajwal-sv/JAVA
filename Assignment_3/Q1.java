package Assignment_3;

class student {
    int rollNo ;
    String name ;
    int marks ;

    student(int rollNo, String name, int marks){

        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;


    }

    public void displayDetails(){
        System.out.println("namae " +name+"roll name "+rollNo+"marks : "+marks);

}
}

 
public class Q1 {
    public static void main(String[] args) {
        student s1 = new student(52,"prajwal",67);
        s1.displayDetails();
        
    }

}