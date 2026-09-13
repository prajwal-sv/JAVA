package classWork;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Employee{

        private int empid ;
        private String name ;
        private int age ;

        private static  int nextEmpId = 100 ;


        public Employee(int empid , String name , int age ){
            this.empid = ++nextEmpId;
            this.name =  name;
            this.age = age;
        }

        public int getEmpId() {
        return empid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setEmpId(int empId) {
        this.empid = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public  void display(){
        System.out.println("in employe class display ");
        System.out.println(
             "ID: " + empid +
            " | Name: " + name +
            " | Age: " + age
        );

    }

    class EmployeeManagement{
        private  ArrayList<Employee> employeesList = new ArrayList<>();
        private Scanner sc = new Scanner(System.in);


        public  void addEmployee(){
          try{
            System.out.println("enter employe ID ");
            int id =  sc.nextInt();
            System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
            System.out.println("Enter Employee Age: ");
            int age =  sc.nextInt();

            Employee e = new Employee(id, name, age);

            employeesList.add(e);

            System.out.println("Employee added successfully!");
          }catch (InputMismatchException e) {

            System.out.println(
                "Invalid input! Please enter a number for age."
            );

            sc.nextLine();
        }
        
            
        }

        public  void displayEmployees(){

            if(employeesList.isEmpty()){
                System.out.println("No employees found!");
                return ;

            }

            for(Employee e : employeesList){
                System.out.println(
                "ID: " + e.getEmpId() +
                " | Name: " + e.getName() +
                " | Age: " + e.getAge()
            );
            }
        }

        public  void updateEmployee(){

                    System.out.print("Enter Employee ID to update: ");
                    int id  = sc.nextInt();

                    boolean found = false;


                    for (Employee e : employeesList){
                        if(e.getEmpId()==id){
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter new age: ");
                            int age = sc.nextInt();  
                            
                            e.setName(name);
                            e.setAge(age);

                            System.out.println(
                    "Employee updated successfully!"
                );

                 found = true;
                 break;

                        }
                    }

                    if (!found){
                        System.out.println("employe not found ");
                    }
        }

        public void  deleteEmployee(){

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;


        for (Employee e : employeesList){

            if(e.getEmpId()== id){
                employeesList.remove(e);
                System.out.println(
                    "Employee deleted successfully!"
                );

                found = true;

                break;
            }

            
            
        }
        if(!found){
            System.out.println("employee not found ");
        }


    }

    }

    




    }
public class Q1self {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        EmployeeManagement em = new EmployeeManagement();

        boolean flag = true ;


        while (flag) {

            System.out.println(
                "\n**************************************"
            );

            System.out.println(
                "      EMPLOYEE MANAGEMENT SYSTEM"
            );

            System.out.println(
                "**************************************"
            );

            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");


            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {


                case 1:

                    em.addEmployee();

                    /*
                     * BREAK stops the current case.
                     */
                    break;


                case 2:

                    em.displayEmployees();

                    break;


                case 3:

                    em.updateEmployee();

                    break;
                    


                case 4:

                    em.deleteEmployee();

                    break;


                case 5:

                    System.out.println(
                        "Exiting program..."
                    );


                    /*
                     * FLAG becomes false.
                     *
                     * After the switch finishes,
                     * while(flag) becomes false
                     * and the program stops.
                     */
                    flag = false;

                    break;


                default:

                    System.out.println(
                        "Invalid choice!"
                    );

                    break;
            }

            
        }
        sc.close();

    }
    
    
}
