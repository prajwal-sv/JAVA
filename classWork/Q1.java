
package classWork;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
 * ==========================================
 * EMPLOYEE CLASS
 * ==========================================
 *
 * CONCEPTS:
 * 1. Class
 * 2. Encapsulation
 * 3. Static variable
 * 4. Constructor
 * 5. Getter and Setter
 */
class Employee {

    /*
     * Encapsulation:
     * Variables are private.
     */
    private int empId;
    private String name;
    private int age;


    /*
     * STATIC VARIABLE
     *
     * This variable belongs to the class,
     * not to an individual object.
     *
     * It is used to generate unique Employee IDs.
     *
     * First employee  -> 101
     * Second employee -> 102
     * Third employee  -> 103
     */
    private static int nextEmpId = 100;


    /*
     * CONSTRUCTOR
     *
     * Every time a new Employee object is created,
     * a unique ID is automatically generated.
     */
    public Employee(String name, int age) {

        /*
         * ++ increases the ID by 1
         * and assigns it to the employee.
         */
        this.empId = ++nextEmpId;

        this.name = name;
        this.age = age;
    }


    /*
     * GETTER
     */
    public int getEmpId() {
        return empId;
    }


    /*
     * GETTER
     */
    public String getName() {
        return name;
    }


    /*
     * SETTER
     */
    public void setName(String name) {
        this.name = name;
    }


    /*
     * GETTER
     */
    public int getAge() {
        return age;
    }


    /*
     * SETTER
     */
    public void setAge(int age) {
        this.age = age;
    }


    /*
     * DISPLAY METHOD
     */
    public void display() {

        System.out.println(
            "Employee ID : " + empId +
            " | Name : " + name +
            " | Age : " + age
        );
    }
}


/*
 * ==========================================
 * EMPLOYEE MANAGEMENT CLASS
 * ==========================================
 */
class EmployeeManagement {

    /*
     * ARRAYLIST
     *
     * Stores Employee objects.
     */
    private ArrayList<Employee> employeeList =
            new ArrayList<>();


    /*
     * SCANNER
     */
    private Scanner sc = new Scanner(System.in);


    /*
     * ==========================================
     * ADD EMPLOYEE
     * ==========================================
     */
    public void addEmployee() {

        /*
         * TRY BLOCK
         *
         * Code that may generate an exception
         * is placed inside try.
         */
        try {

            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();


            System.out.print("Enter Employee Age: ");
            int age = sc.nextInt();


            /*
             * Simple validation.
             */
            if (age <= 0) {

                throw new IllegalArgumentException(
                    "Age must be greater than 0."
                );
            }


            /*
             * OBJECT CREATION
             *
             * Employee ID is automatically generated.
             */
            Employee e = new Employee(name, age);


            /*
             * Add employee to ArrayList.
             */
            employeeList.add(e);


            System.out.println(
                "Employee added successfully!"
            );

            System.out.println(
                "Generated Employee ID: "
                + e.getEmpId()
            );


        }

        /*
         * EXCEPTION HANDLING
         *
         * Handles wrong input such as:
         * Age = abc
         */
        catch (InputMismatchException e) {

            System.out.println(
                "Invalid input! Please enter a number for age."
            );

            sc.nextLine();
        }


        /*
         * Handles our custom validation exception.
         */
        catch (IllegalArgumentException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }


        /*
         * FINALLY
         *
         * This block executes whether exception
         * occurs or not.
         */
        finally {

            System.out.println(
                "Add operation completed."
            );
        }
    }


    /*
     * ==========================================
     * DISPLAY EMPLOYEES
     * ==========================================
     */
    public void displayEmployees() {

        try {

            if (employeeList.isEmpty()) {

                System.out.println(
                    "No employees found!"
                );

                return;
            }


            System.out.println(
                "\n--------- EMPLOYEE LIST ---------"
            );


            /*
             * FOR-EACH LOOP
             */
            for (Employee e : employeeList) {

                /*
                 * Using getters.
                 */
                System.out.println(
                    "ID: " + e.getEmpId() +
                    " | Name: " + e.getName() +
                    " | Age: " + e.getAge()
                );
            }

        }

        catch (Exception e) {

            /*
             * General exception handling.
             */
            System.out.println(
                "Something went wrong while displaying employees."
            );
        }
    }


    /*
     * ==========================================
     * UPDATE EMPLOYEE
     * ==========================================
     */
    public void updateEmployee() {

        try {

            System.out.print(
                "Enter Employee ID to update: "
            );

            int id = sc.nextInt();

            boolean found = false;


            /*
             * SEARCH EMPLOYEE
             */
            for (Employee e : employeeList) {

                if (e.getEmpId() == id) {

                    sc.nextLine();

                    System.out.print(
                        "Enter new name: "
                    );

                    String name = sc.nextLine();


                    System.out.print(
                        "Enter new age: "
                    );

                    int age = sc.nextInt();


                    if (age <= 0) {

                        throw new IllegalArgumentException(
                            "Age must be greater than 0."
                        );
                    }


                    /*
                     * SETTERS
                     *
                     * Updating private variables.
                     */
                    e.setName(name);
                    e.setAge(age);


                    System.out.println(
                        "Employee updated successfully!"
                    );


                    found = true;


                    /*
                     * BREAK
                     *
                     * Stop searching after employee
                     * has been found.
                     */
                    break;
                }
            }


            /*
             * FLAG
             *
             * If employee was not found.
             */
            if (!found) {

                System.out.println(
                    "Employee not found!"
                );
            }

        }

        catch (InputMismatchException e) {

            System.out.println(
                "Invalid input! Please enter numbers correctly."
            );

            sc.nextLine();
        }

        catch (IllegalArgumentException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }


    /*
     * ==========================================
     * DELETE EMPLOYEE
     * ==========================================
     */
    public void deleteEmployee() {

        try {

            System.out.print(
                "Enter Employee ID to delete: "
            );

            int id = sc.nextInt();

            boolean found = false;


            /*
             * Instead of removing directly inside
             * for-each, first find the employee.
             */
            Employee employeeToDelete = null;


            for (Employee e : employeeList) {

                if (e.getEmpId() == id) {

                    employeeToDelete = e;

                    found = true;

                    break;
                }
            }


            if (found) {

                employeeList.remove(employeeToDelete);

                System.out.println(
                    "Employee deleted successfully!"
                );

            } else {

                System.out.println(
                    "Employee not found!"
                );
            }

        }

        catch (InputMismatchException e) {

            System.out.println(
                "Invalid input! Employee ID must be a number."
            );

            sc.nextLine();
        }
    }


    /*
     * CLOSE SCANNER
     */
    public void closeScanner() {

        sc.close();
    }
}


/*
 * ==========================================
 * MAIN CLASS
 * ==========================================
 */
public class Q1 {

    public static void main(String[] args) {


        /*
         * SCANNER FOR MENU
         */
        Scanner sc = new Scanner(System.in);


        /*
         * CREATE MANAGEMENT OBJECT
         */
        EmployeeManagement em =
                new EmployeeManagement();


        /*
         * FLAG
         *
         * true  = continue program
         * false = stop program
         */
        boolean flag = true;


        /*
         * WHILE LOOP
         *
         * Menu continues while flag is true.
         */
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
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");


            /*
             * TRY-CATCH FOR MENU INPUT
             */
            try {

                System.out.print(
                    "Enter your choice: "
                );

                int choice = sc.nextInt();


                /*
                 * SWITCH
                 */
                switch (choice) {


                    /*
                     * ADD
                     */
                    case 1:

                        em.addEmployee();

                        break;


                    /*
                     * DISPLAY
                     */
                    case 2:

                        em.displayEmployees();

                        break;


                    /*
                     * UPDATE
                     */
                    case 3:

                        em.updateEmployee();

                        break;


                    /*
                     * DELETE
                     */
                    case 4:

                        em.deleteEmployee();

                        break;


                    /*
                     * EXIT
                     */
                    case 5:

                        System.out.println(
                            "Exiting program..."
                        );


                        /*
                         * FLAG becomes false.
                         *
                         * while(flag) will stop.
                         */
                        flag = false;


                        /*
                         * BREAK exits switch.
                         */
                        break;


                    /*
                     * INVALID CHOICE
                     */
                    default:

                        System.out.println(
                            "Invalid choice! Enter 1-5."
                        );

                        break;
                }


            }

            /*
             * EXCEPTION HANDLING
             *
             * If user enters:
             *
             * abc
             *
             * instead of:
             *
             * 1, 2, 3, 4 or 5
             */
            catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input! Please enter a number."
                );


                /*
                 * Remove invalid input from Scanner.
                 */
                sc.nextLine();
            }
        }


        /*
         * CLOSE SCANNER
         */
        sc.close();


        System.out.println(
            "Program ended successfully."
        );
    }
}

