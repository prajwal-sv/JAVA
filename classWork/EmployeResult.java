package classWork;

import java.util.Scanner;


class e{
    static float salary;
    static {
    salary=123.67f; ;
   }
    

    void getdata(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name :");
        String name =  sc.nextLine();
        System.out.println("enter your age :");
        int age =  sc.nextInt();
        System.out.println("Name: " + name); 
        
        System.out.println("Age: " + age);

    }
    void cal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the basic salry:");
        float Bs = sc.nextFloat();

        salary = (float)(Bs + Bs * 1.27 + Bs * 0.34 + Bs * 0.01);
        System.out.println("Total Slary : "+salary);
    }

}
class EmployeResult {
    public static void main(String[] args) {
   e emp = new e();
        emp.getdata();
        emp.cal();

    }
}