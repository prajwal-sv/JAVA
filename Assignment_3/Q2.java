package Assignment_3;

import java.util.Scanner;

import Assignment_1.sum;

class BMI{
    private  double height , weight ;
    BMI(double height,double weight){
        this.height = height;
        this.weight = weight ;

    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height ;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight ;
    }

    public double CalculateBMI(){
        return weight / (height*height);
    }



}

public class Q2 {

    

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

    BMI b =  new BMI(0, 0);

    System.out.print("Enter height in meters: "); 
    b.setHeight(sc.nextDouble());
     System.out.print("Enter weight in kg: "); 
     b.setWeight(sc.nextDouble());


     System.out.println("BMI = "+ b.CalculateBMI());
    }

   


    


    
}
