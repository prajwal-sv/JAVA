package StudentMangementSystem;

import java.util.Scanner;




public class StudentMangementSystem {


    public static void validateStudent(
        int id ,
        String name ,
        int age ,
        String course,
        float maeks

    ) throws InvalidStudentException{

        if(id <=0){
            throw new InvalidStudentException("Id must be garter than 0 ")
        }
    }

    public static void deleteStudent(Student[] students , Scanner sc ) {
        System.out.println("Enter students Id to delete : ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < students.length; i++) {
        if ( students[i] !=null && students[i].getId()==id){

            students[i] = null;

            System.out.println("Student deleted successfully");

            sc.nextLine();

        }
    }


    }


    public static void updateStudents(Student[] students, Scanner sc) {


        System.out.println("Enter students Id to update : ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < students.length; i++) {
        if ( students[i] !=null && students[i].getId()==id){

            sc.nextLine();

         System.out.println("Enter new Name  :");

         String name = sc.nextLine();

         System.out.println("Enter new  Age  :");

         int age  = sc.nextInt();

         sc.nextLine();

         System.out.println("Enter new Course  :");

         String course  = sc.nextLine();

         System.out.println("Enter new Marks  :");

         float marks = sc.nextFloat();
                
         students[i] = new Student(id, name, age, course, marks);

         System.out.println("Student was updated Succesfuly");

         return ;


        }

         
                
            }
            
         }
        
    



public static boolean isIdExits(Student[] students , int id ) {

    for (int i = 0; i < students.length; i++) {
        
        if ( students[i] !=null && students[i].getId()==id) {

            return true;
            
        }
    }

    return false;
    
}
 
    
public static void searchStudent(Student[] students , Scanner sc){



System.out.println("enter student ID to search : ");
int id  = sc.nextInt();


boolean found = false ;

for (int i = 0; i < students.length; i++) {
    if (students[i] != null && students[i].getId()==id) {
        
        System.out.println("Student found ");

        students[i].displayStudent();

        found =  true ;
        break;
    }
    
}

if(!found){
    System.out.println("Student not found");
}


    
}

    public static void viewStudent(Student[] students) {
        boolean found = false;

        for (int i = 0; i < students.length; i++) {
            
            if (students[i]!=null) {

                students[i].displayStudent();
                System.out.println("________________________");

                found =  true ;
     
            }
        }
        if (!found) {

            System.out.printf("no students found");
            
        }
        

    }

    public static void addStudent(Student[] students, Scanner sc){
         

         for (int i = 0; i < students.length; i++) {
            if (students[i]==null) {
            System.out.println("Enter Id :");
         int id   = sc.nextInt();

         if (isIdExits(students, id)) {
            System.out.println("student Id already exits :");
            return ;
            
         }

         sc.nextLine();

         System.out.println("Enter Name  :");

         String name = sc.nextLine();

         System.out.println("Enter Age  :");

         int age  = sc.nextInt();

         sc.nextLine();

         System.out.println("Enter Course  :");

         String course  = sc.nextLine();

         System.out.println("Enter Marks  :");

         float marks = sc.nextFloat();
                
         students[i] = new Student(id, name, age, course, marks);

         System.out.println("Student was added Succesfuly");

         return ;
                
            }
            
         }


    }
    public static void main(String[] args) {

        Student[] student =  new Student[10];
         Scanner sc = new Scanner(System.in);



        for (int i = 0; i < student.length; i++) {
            if(student[i] != null ){
                student[i].displayStudent();
            }
        }


        

        int choise ;

        do{
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");


            System.out.println("Enter the Chosie");
            choise =  sc.nextInt();

            switch (choise) {
                case 1:
                    addStudent(student, sc);

                    break;

                case 2:
                    viewStudent(student);
                    break;

                case 3:
                    searchStudent(student, sc);
                    break;

                case 4:
                    updateStudents(student, sc);
                    break;

                case 5:
                    deleteStudent(student, sc);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }while (choise!=4);


        sc.close();
        


        
    }
}
