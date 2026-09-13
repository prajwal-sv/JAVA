package Assignment_3;

 class Rectangle{
        int Length ;
        int Width ;

    Rectangle(int Length , int Width){

            this.Length =  Length;
            this.Width = Width;


        }

    public float calculateArea(){
            return  Length*Width;

    }
    public float calculatePerimeter(){

        return 2*(Length+Width);

    }

    

    }

public class Q2 {
   

    public static void main(String[] args) {

        Rectangle R1 = new Rectangle(10, 20);
        System.out.println("area "+R1.calculateArea());
        System.out.println("area "+R1.calculatePerimeter());

    }


}
